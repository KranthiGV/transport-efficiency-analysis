import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;

public class CitibikeMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");

        if (key.get() == 0) { // Skip header row
            return;
        }

        boolean skipRow = false;
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                skipRow = true;
                context.getCounter(CitibikeCounter.Counters.REMOVED_ROWS).increment(1);
                break;
            }
        }

        if (!skipRow) {
            try {
                // a. Calculate trip duration (in seconds)
                long durationInSeconds = CitibikeUtils.calculateRideDurationInSeconds(fields[2], fields[3]);

                // b. Extract date and time components (into year, month, hour, day of the week)
                String[] dateComponents = CitibikeUtils.extractDateComponents(fields[2]);

                // c. Calculate distance
                double distance = CitibikeUtils.calculateDistance(
                        Double.parseDouble(fields[8]), Double.parseDouble(fields[9]),
                        Double.parseDouble(fields[10]), Double.parseDouble(fields[11]));

                // Append the new columns to the output
                String output = String.join(",", fields) + "," + durationInSeconds + "," + String.join(",", dateComponents) + "," + distance;
                context.write(NullWritable.get(), new Text(output));

                context.getCounter(CitibikeCounter.Counters.CLEANED_ROWS).increment(1);
            } catch (ParseException e) {
                context.getCounter(CitibikeCounter.Counters.REMOVED_ROWS).increment(1);
                // Log the error if required
            }
        }
    }
}

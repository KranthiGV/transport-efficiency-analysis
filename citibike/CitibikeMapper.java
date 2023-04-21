import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;

public class CitibikeMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    private static final String OUTPUT_SEPARATOR = ",";
    private boolean headerWritten = false;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");

        if (key.get() == 0 && value.toString().contains("ride_id")) {
            // Skip the header row in the input file
            return;
        }

        if (!headerWritten) {
            // Write the updated header
            String header = "ride_id,rideable_type,started_at,ended_at,start_station_name,start_station_id,end_station_name,end_station_id,start_lat,start_lng,end_lat,end_lng,member_casual,trip_duration_seconds,year,month,day,hour,day_of_week,distance_km";
            context.write(new Text(header), new Text());
            headerWritten = true;
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

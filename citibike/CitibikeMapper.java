import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CitibikeMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            // Skip header line
            return;
        }

        context.getCounter(CitibikeCounter.Counters.ORIGINAL_ROWS).increment(1);

        String line = value.toString();
        String[] fields = line.split(",");

        boolean skipRow = false;
        for (String field : fields) {
            if (field.trim().isEmpty()) {
                skipRow = true;
                break;
            }
        }

        if (!skipRow) {
            String startedAt = fields[2];
            String endedAt = fields[3];
            double startLat = Double.parseDouble(fields[8]);
            double startLng = Double.parseDouble(fields[9]);
            double endLat = Double.parseDouble(fields[10]);
            double endLng = Double.parseDouble(fields[11]);

            if (!CitibikeUtils.isValidDateTime(startedAt) || !CitibikeUtils.isValidDateTime(endedAt)) {
                context.getCounter(CitibikeCounter.Counters.INVALID_DATE_TIME).increment(1);
                skipRow = true;
            }

            if (!CitibikeUtils.isValidLatitude(startLat) || !CitibikeUtils.isValidLongitude(startLng) ||
                    !CitibikeUtils.isValidLatitude(endLat) || !CitibikeUtils.isValidLongitude(endLng)) {
                context.getCounter(CitibikeCounter.Counters.INVALID_LAT_LNG).increment(1);
                skipRow = true;
            }
        }

        if (!skipRow) {
            context.write(NullWritable.get(), value);
            context.getCounter(CitibikeCounter.Counters.CLEANED_ROWS).increment(1);
        } else {
            context.getCounter(CitibikeCounter.Counters.REMOVED_ROWS).increment(1);
        }
    }
}

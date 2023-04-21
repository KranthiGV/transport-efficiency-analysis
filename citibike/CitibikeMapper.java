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
            context.write(NullWritable.get(), value);
            context.getCounter(CitibikeCounter.Counters.CLEANED_ROWS).increment(1);
        } else {
            context.getCounter(CitibikeCounter.Counters.REMOVED_ROWS).increment(1);
        }
    }
}

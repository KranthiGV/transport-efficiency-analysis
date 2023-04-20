package com.citibike;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CitibikeMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Skip the header of the CSV file
        if (key.get() == 0 && value.toString().contains("ride_id")) {
            return;
        }

        String line = value.toString();
        String[] fields = line.split(",", -1);

        // Check for null values
        boolean hasNull = false;
        for (String field : fields) {
            if (field.isEmpty()) {
                hasNull = true;
                break;
            }
        }

        if (!hasNull) {
            context.write(NullWritable.get(), value);
        }
    }
}

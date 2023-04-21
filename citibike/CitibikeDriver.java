import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class CitibikeDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "Citibike Data Cleaning");
        job.setJarByClass(CitibikeDriver.class);
        job.setMapperClass(CitibikeMapper.class);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        boolean success = job.waitForCompletion(true);

        if (success) {
            long originalRows = job.getCounters().findCounter(CitibikeCounter.Counters.ORIGINAL_ROWS).getValue();
            long cleanedRows = job.getCounters().findCounter(CitibikeCounter.Counters.CLEANED_ROWS).getValue();
            long removedRows = job.getCounters().findCounter(CitibikeCounter.Counters.REMOVED_ROWS).getValue();
            long invalidDateTime = job.getCounters().findCounter(CitibikeCounter.Counters.INVALID_DATE_TIME).getValue();
            long invalidLatLng = job.getCounters().findCounter(CitibikeCounter.Counters.INVALID_LAT_LNG).getValue();
        
            System.out.println("Number of original rows: " + originalRows);
            System.out.println("Number of cleaned rows: " + cleanedRows);
            System.out.println("Number of removed rows: " + removedRows);
            System.out.println("Number of invalid date/time rows: " + invalidDateTime);
            System.out.println("Number of invalid latitude/longitude rows: " + invalidLatLng);
        }
        
        System.exit(success ? 0 : 1);

    }
}
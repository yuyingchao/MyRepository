package com.mapreducesort;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.entity.traffic;

/**
 * mapreduce
 * 
 * 2016-11-28
 * 
 * @author yyc
 * 
 */
public class trafficmapreduce {
	public static class TrafficMapper extends
			Mapper<LongWritable, Text, traffic, Text> {
		Text text = new Text();
		traffic t = new traffic();

		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			String[] split = value.toString().split("\t");
			Integer uppackagenum = Integer.valueOf(split[6]);
			Integer downpackagenum = Integer.valueOf(split[7]);
			Integer upnum = Integer.valueOf(split[8]);
			Integer downnum = Integer.valueOf(split[9]);
			String phonenum = split[1];
			t.setUppackagenum(uppackagenum);
			t.setDownpackagenum(downpackagenum);
			t.setUpnum(upnum);
			t.setDownnum(downnum);
			text.set(phonenum);
			context.write(t, text);
		}

		public static void main(String[] args) throws IOException,
				ClassNotFoundException, InterruptedException {
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf);
			job.setJarByClass(trafficmapreduce.class);
			job.setMapperClass(TrafficMapper.class);
			job.setMapOutputKeyClass(traffic.class);
			job.setMapOutputValueClass(Text.class);
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			job.waitForCompletion(true);
		}

	}
}

package com.mapreducesort;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.entity.sortBean;

public class sortmapreduce  {

	public static  class sortmapper extends Mapper<LongWritable, Text, sortBean, Text>{
		sortBean bean =  new sortBean();
		Text v = new Text();
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
		String[] split = value.toString().split(",");
		bean.set(split[0], Integer.valueOf(split[1]));
		v.set(split[1]);
		context.write(bean, v);
		}
		
		
	}
	
	
	public static class sortreduce extends Reducer<sortBean,Text,Text,Text>{
   Text key=new Text();
		@Override
		protected void reduce(sortBean sortbean, Iterable<Text> iterable,
			Context context)
				throws IOException, InterruptedException {
			for (Text text : iterable) {
				key.set(sortbean.getLeft());
				context.write(key, text);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		 Job job = Job.getInstance(new Configuration());
		job.setJarByClass(sortmapreduce.class);
		job.setMapperClass(sortmapper.class);
		job.setMapOutputKeyClass(sortBean.class);
		job.setMapOutputValueClass(Text.class);
		job.setGroupingComparatorClass(groupSort.class);
		
		job.setReducerClass(sortreduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}

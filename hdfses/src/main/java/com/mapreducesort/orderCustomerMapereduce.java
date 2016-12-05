package com.mapreducesort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.entity.orderBean;

public class orderCustomerMapereduce {

	private static orderBean order= new orderBean();
  public static class orderCustomer extends Mapper<LongWritable, Text, LongWritable, orderBean>{
 
 LongWritable key = new LongWritable();
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
	   String[] split = value.toString().split(",");
	   if(split.length == 3){
       order.set("customer",split[1]+","+split[2]);
       key.set(Long.valueOf(split[0]));
		  context.write(key, order);
	   }
		
		if(split.length == 4){
			order.set("order", split[1]+","+split[2]);
			key.set(Long.valueOf(split[0]));
			context.write(key, order);
		}
		
	}
	  
	public static class orderreduce extends Reducer<LongWritable, orderBean, LongWritable, Text>{
    Text text= new Text();
		@Override
		protected void reduce(LongWritable key,
				Iterable<orderBean> iterable,
				Context context)
				throws IOException, InterruptedException {
			String customStr=null;
			List<String> orderList=new ArrayList<String>();
			
			for (orderBean orders : iterable) {
				String flag=orders.getFalg();
				if(flag.equals("customer")){
					customStr=orders.getData();
				}else{
					orderList.add(orders.getData());
					
				}
			}
			for (String orderData : orderList) {
				text.set(customStr+","+orderData);
				context.write(key, text);
			}
		}
		
		
		
	}
	  
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration);
		job.setJarByClass(orderCustomerMapereduce.class);
		job.setMapperClass(orderCustomer.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(orderBean.class);
		job.setReducerClass(orderreduce.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
	  
	  
  }
	
	
	
}

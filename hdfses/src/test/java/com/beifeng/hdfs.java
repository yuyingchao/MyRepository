package com.beifeng;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class hdfs{ 
	FileSystem fs =null;
	@Before
	public void getFileSystem() throws IOException, InterruptedException, URISyntaxException{
		Configuration cof=new Configuration();
		fs=FileSystem.get(new URI("hdfs://linux03:8020"), cof, "beifeng");
		
	}
	@Test
	public void downLoad() throws IllegalArgumentException, IOException{
	FSDataInputStream in =fs.open(new Path("/input/ll.input"));
	FileOutputStream out = new FileOutputStream("/opt/data/ll.input");
	IOUtils.copyBytes(in, out, 4096, true);
	}
	@Test
	public void upload() throws IllegalArgumentException, IOException{
		FSDataOutputStream out =fs.create(new Path("/kkk/ec.input"));
		FileInputStream in = new FileInputStream("/opt/data/wc.input");
		IOUtils.copyBytes(in, out, 4096, true);
	}
	@Test
	public void mkdir() throws IllegalArgumentException, IOException{
		boolean mkdirs = fs.mkdirs(new Path("/kkk"));
		System.out.println(mkdirs);
	}
	@Test
	public void del() throws IllegalArgumentException, IOException{
		boolean delete = fs.delete(new Path("/input/wc.input"), true);
		System.out.println(delete);
	}
}

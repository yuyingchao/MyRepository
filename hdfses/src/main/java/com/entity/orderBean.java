package com.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
/**
 * ∂©µ•¥¶¿Ì
 * 
 * @author yyc
 *
 */
public class orderBean implements Writable{
    private String falg;
    private String data;
    
    public orderBean(){
    	
    	
    }
    
	public void set(String falg, String data) {
		
		this.falg = falg;
		this.data = data;
	}

	@Override
	public String toString() {
		return   falg + ", "+data ;
	}

	public String getFalg() {
		return falg;
	}

	public void setFalg(String falg) {
		this.falg = falg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void write(DataOutput out) throws IOException {
		out.writeUTF(falg);
		out.writeUTF(data);
		
		
	}

	public void readFields(DataInput in) throws IOException {
	 this.falg = in.readUTF();
	this.data = in.readUTF();
	}

	
	
	
	
}

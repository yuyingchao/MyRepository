package com.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
/**
 * 
 * @author yyc
 * 2016-11-28
 *
 */
public class traffic implements WritableComparable<traffic>{
  private int uppackagenum;
  private int downpackagenum;
  private int upnum;
  private int downnum;
  public traffic(){
	  
	  
  }
	public traffic(int uppackagenum, int downpackagenum, int upnum, int downnum) {
	super();
	this.uppackagenum = uppackagenum;
	this.downpackagenum = downpackagenum;
	this.upnum = upnum;
	this.downnum = downnum;
}
	public int getUppackagenum() {
	return uppackagenum;
}

public void setUppackagenum(int uppackagenum) {
	this.uppackagenum = uppackagenum;
}

public int getDownpackagenum() {
	return downpackagenum;
}

public void setDownpackagenum(int downpackagenum) {
	this.downpackagenum = downpackagenum;
}

public int getUpnum() {
	return upnum;
}

public void setUpnum(int upnum) {
	this.upnum = upnum;
}

public int getDownnum() {
	return downnum;
}

public void setDownnum(int downnum) {
	this.downnum = downnum;
}

	public void write(DataOutput out) throws IOException {
		out.writeInt(uppackagenum);
		out.writeInt(downpackagenum);
		out.writeInt(upnum);
		out.writeInt(downnum);
		
	}

	public void readFields(DataInput in) throws IOException {
		this.uppackagenum= in.readInt();
		this.downpackagenum=in.readInt();
		this.upnum=in.readInt();
		this.downnum=in.readInt();
		
	}

	public int compareTo(traffic o) {
		int num = -(this.downnum+this.upnum)+(o.downnum+o.upnum);
		return num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + downnum;
		result = prime * result + downpackagenum;
		result = prime * result + upnum;
		result = prime * result + uppackagenum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		traffic other = (traffic) obj;
		if (downnum != other.downnum)
			return false;
		if (downpackagenum != other.downpackagenum)
			return false;
		if (upnum != other.upnum)
			return false;
		if (uppackagenum != other.uppackagenum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TotalPackNum=" + (downpackagenum + uppackagenum) + "\t"
				+ "TotalPayLoad=" + (downnum + upnum);
	}
	

}

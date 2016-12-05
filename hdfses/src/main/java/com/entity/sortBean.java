package com.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
/**
 * ��������
 * @author yyc��
 * 2016-11-29
 *
 */
public class sortBean implements WritableComparable<sortBean>{
    private String left;
    private int right;

	@Override
	public String toString() {
		return "sortBean [left=" + left + ", right=" + right + "]";
	}

	public sortBean(){	
	}

	public void set(String left, int right) {		
		this.left = left;
		this.right = right;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void write(DataOutput out) throws IOException {
	out.writeUTF(left);
	out.writeInt(right);
		
	}

	public void readFields(DataInput in) throws IOException {
		 this.left = in.readUTF();
		  this.right = in.readInt();
	}

	public int compareTo(sortBean o) {
		int num = this.getLeft().compareTo(o.getLeft());
		int num2=(num==0)?this.getRight()-o.getRight():num;
		return num2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + right;
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
		sortBean other = (sortBean) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right != other.right)
			return false;
		return true;
	}

}

package com.mapreducesort;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.file.tfile.RawComparable;

import com.entity.sortBean;

public class groupSort  implements RawComparator<sortBean>{

	public int compare(sortBean o1, sortBean o2) {
		System.out.println("compare..................");
		return o2.getLeft().compareTo(o1.getLeft());
	}

	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		
		return WritableComparator.compareBytes(b1, s1, l1-4, b2, s2, l2-4);
	}
	


}

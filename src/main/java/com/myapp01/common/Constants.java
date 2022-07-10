package com.myapp01.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 定数定義
 *
 */
public class Constants {
	// 性別リスト
	public static final List<String>GENDER_LIST;
	public static final List<String>BLOOD_TYPE_LIST;
	static {
		GENDER_LIST = new ArrayList<String>();
		GENDER_LIST.add("男");
		GENDER_LIST.add("女");
		
		BLOOD_TYPE_LIST = new ArrayList<String>();
		BLOOD_TYPE_LIST.add("A");
		BLOOD_TYPE_LIST.add("B");
		BLOOD_TYPE_LIST.add("O");
		BLOOD_TYPE_LIST.add("AB");
	}
}

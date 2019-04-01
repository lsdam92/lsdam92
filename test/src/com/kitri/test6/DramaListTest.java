package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;



public class DramaListTest {

	public static void main(String[] args) {
		Drama dr[] = new Drama[4];
		int len = dr.length;
//		for (int i = 0; i < len; i++) {
//			dr[0] = new Drama("그 겨울, 바람이분다", "SBS", "김규태", "조인성", "송혜교");
//			dr[1] = new Drama("백년의 유산", "MBC", "주성우", "", "");
//			dr[2] = new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해");
//			dr[3] = new Drama("최고다 이순신", "KBS", "윤성식", "", "아이유");
//			System.out.println(dr[i]);
//		}	
		List<Drama> list = new ArrayList<Drama>();
//		list.add("그 겨울, 바람이분다", "SBS", "김규태", "조인성", "송혜교");
//		list.add("백년의 유산", "MBC", "주성우", "", "");
//		list.add("아이리스2", "KBS", "표민수", "장혁", "이다해");
//		list.add("최고다 이순신", "KBS", "윤성식", "", "아이유");
		len = dr.length;
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	
	}

}

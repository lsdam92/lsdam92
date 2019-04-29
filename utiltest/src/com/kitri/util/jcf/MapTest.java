package com.kitri.util.jcf;

import java.util.*;

public class MapTest {
//	같은key값을 가지고 put하면 덮어씌어진다
	public static void main(String[] args) {
		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>();		//가장자주쓰임
//		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>();
		map.put("DS24", new PlayerDto(24,"오재원", 4, 0.321));
		map.put("DS9", new PlayerDto(9,"페르난데스", 3, 0.421));
		map.put("KW24", new PlayerDto(24,"박병호", 3, 0.431));
		map.put("HH19", new PlayerDto(19,"정근우", 7, 0.321));
		
		int size = map.size();
		System.out.println("등록 인원 : " + size);
		
		int number = 24;
		System.out.println("두산의 " + number + "번 선수의 정보!!");
		PlayerDto playerDto = map.get("DS"+number);
		System.out.println(playerDto);
//		map에서는 넣을때 put 뽑을때 get
//		전체명단을 뽑기위해선 순서없이 저장되므로 Collection<v>으로 부른다 v= values
	}
}

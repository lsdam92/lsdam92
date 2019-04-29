package com.kitri.util.jcf;

import java.util.*;


public class PlayerList {

//	List<PlayerDto> list = new ArrayList<PlayerDto>();	동시다발적으로 저장은 하지만 속도가 빠르므로 많이쓰임
	List<PlayerDto> list = new Vector<PlayerDto>();	//Vector는 완벽한순서저장 동기화처리가 되어있음
	
	private void playerRegister(PlayerDto playerDto) {
		list.add(playerDto);
	}
	
	private void  playerList () {	//list에 객체가 저장되는 개념이 아니고 주소값이 저장됨
		System.out.println("=== 두산베어스 팀명단 ===");
		System.out.println("------------------");
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private PlayerDto playerSearch(int number) { //주소값에서의 number를 뽑음
		PlayerDto playerDto = null;
		int size = list.size();
		for(int i = 0; i< size; i++) {
			PlayerDto dto= list.get(i);
			if(number ==dto.getNumber()){
				playerDto = dto;
				break;
			}
		}
		return playerDto;
	}
	
	private void playerInfo(PlayerDto playerDto) {
		if(playerDto != null)
			System.out.println(playerDto);
		else
			System.out.println("선수는 없습니다");
	}
	
	public static void main(String[] args) {
		PlayerList pl = new PlayerList();
		
		pl.playerRegister(new PlayerDto(24,"오재원", 4, 0.321));
		pl.playerRegister(new PlayerDto(13,"하경민", 5, 0.351));
		pl.playerRegister(new PlayerDto(34,"란드블럼", 1, 0.001));
		pl.playerRegister(new PlayerDto(9,"페르난데스", 3, 0.421));
		pl.playerRegister(new PlayerDto(38,"김대한", 7, 0.384));		
		
		pl.playerList();
		
		int number = 13;
		System.out.println(number + "번 선수정보 !");
		PlayerDto playerDto = pl.playerSearch(number);
		pl.playerInfo(playerDto);
		
		
		number = 13;
		double score = 0.357;
		System.out.println(number + "번 선수가 안타!!! 타율이 " + score + "로 변경");
		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);
		pl.playerInfo(playerDto);
		
		pl.playerList();
	}

}

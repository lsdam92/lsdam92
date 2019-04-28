package com.kitri.haksa.service;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDao;
import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService {

	HaksaDto haksaDto;
//	HaksaDao haksaDao = new HaksaDao();
	private HaksaDao haksaDao = new HaksaDao();

	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private String job[] = { "학 번", "과 목", "부 서" };
	private BufferedReader in;

	int age;
	String name;
	int num;
	String value;
	
	public HaksaServiceImpl() {
		this.list = new ArrayList<HaksaDto>();
		this.in = new BufferedReader(new InputStreamReader(System.in));
	}

	public void menu() {

		System.out.println(
				"======== 메뉴 선택 ========\n1.등록\n2.찾기" + "\n3.삭제" + "\n4.전체 출력\n-------------\n0.종료\n----------");

		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호를 선택해 주세요.. ");
			int num = Integer.parseInt(in.readLine().trim());
			if (num == 1) {
				registerMenu();
			} else if (num == 2) {
				findNameMenu();
			} else if (num == 3) {
				deleteMenu();
			} else if (num == 4) {
				selectAll();
			} else if (num == 0) {
				processExit();
			} else {
				System.out.println("0~4번만  입력해주세요.");
				menu();
			}

		} catch (IOException e) {

			e.printStackTrace();
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public void registerMenu() {

		System.out.println("======== 메뉴 선택 ========");
		System.out.println("1.학생\n2.교수\n3.관리자\n4.이전으로");
		System.out.println("-----------------------");
		in = new BufferedReader(new InputStreamReader(System.in));

		try {

			System.out.print("번호를 선택해 주세요.. ");
			num = Integer.parseInt(in.readLine().trim());

			if (num == 1) {
				System.out.print("나 이 : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("이 름 : ");
				name = in.readLine().trim();
				System.out.print(job[0] + " : ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 2) {
				System.out.print("나 이 : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("이 름 : ");
				name = in.readLine().trim();
				System.out.print(job[1] + " : ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 3) {
				System.out.print("나 이 : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("이 름 : ");
				name = in.readLine().trim();
				System.out.print(job[2] + " ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 4) {
				menu();
			} else {
				System.out.println("0~4번 만 입력하세요.");
				registerMenu();
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void register(HaksaDto haksa) {
		list.add(haksa);
		System.out.println("등록 되었습니다");
	}

	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		try {
			String name = in.readLine().trim();
			HaksaDto haksaDto = findName(name);
			if (haksaDto != null)
				System.out.println("나이 : " + haksaDto.getAge() + "\t이름 : " + haksaDto.getName() + "\t"
						+ job[haksaDto.getKey()] + " : " + haksaDto.getValue());
			else
				System.out.println("찾을 수 없습니다.");

			System.out.print("계속 하시려면 1, 종료하시려면 아무키를 입력해주세요 ");
			int exit = Integer.parseInt(in.readLine());
			if (exit == 1)
				menu();
			else
				processExit();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public HaksaDto findName(String name) {
		HaksaDto haksa = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			HaksaDto dto = list.get(i);
			if (dto.getName().equals(name)) {
				haksa = dto;
				break;
			}
		}
		return haksa;
	}

	@Override
	public void deleteMenu() {
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		try {
			String name = in.readLine().trim();

			if (delete(name) != 0)
				System.out.println(name + "님을 삭제");
			else
				System.out.println("찾을 수 없습니다.");

			System.out.print("계속 하시려면 1, 종료하시려면 아무키를  입력해주세요 ");
			int exit = Integer.parseInt(in.readLine());
			if (exit == 1)
				menu();
			else
				processExit();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int delete(String name) {
		
		return haksaDao.delete(name);

	}

	public void selectAll() {
		list = haksaDao.selectAllList();

		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}

		System.out.print("계속 하시려면 1, 종료하시려면 아무키를 입력해주세요 ");
		try {
			int exit = Integer.parseInt(in.readLine());
			if (exit == 1)
				menu();
			else
				processExit();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processExit() {
		System.exit(0);
	}

}

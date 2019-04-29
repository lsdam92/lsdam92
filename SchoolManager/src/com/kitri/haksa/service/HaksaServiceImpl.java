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
	private String job[] = { "�� ��", "�� ��", "�� ��" };
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
				"======== �޴� ���� ========\n1.���\n2.ã��" + "\n3.����" + "\n4.��ü ���\n-------------\n0.����\n----------");

		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("��ȣ�� ������ �ּ���.. ");
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
				System.out.println("0~4����  �Է����ּ���.");
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

		System.out.println("======== �޴� ���� ========");
		System.out.println("1.�л�\n2.����\n3.������\n4.��������");
		System.out.println("-----------------------");
		in = new BufferedReader(new InputStreamReader(System.in));

		try {

			System.out.print("��ȣ�� ������ �ּ���.. ");
			num = Integer.parseInt(in.readLine().trim());

			if (num == 1) {
				System.out.print("�� �� : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("�� �� : ");
				name = in.readLine().trim();
				System.out.print(job[0] + " : ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 2) {
				System.out.print("�� �� : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("�� �� : ");
				name = in.readLine().trim();
				System.out.print(job[1] + " : ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 3) {
				System.out.print("�� �� : ");
				age = Integer.parseInt(in.readLine().trim());
				System.out.print("�� �� : ");
				name = in.readLine().trim();
				System.out.print(job[2] + " ");
				value = in.readLine().trim();

				haksaDao.register(new HaksaDto(age, name, num - 1, value));
				menu();
			}
			if (num == 4) {
				menu();
			} else {
				System.out.println("0~4�� �� �Է��ϼ���.");
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
		System.out.println("��� �Ǿ����ϴ�");
	}

	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		try {
			String name = in.readLine().trim();
			HaksaDto haksaDto = findName(name);
			if (haksaDto != null)
				System.out.println("���� : " + haksaDto.getAge() + "\t�̸� : " + haksaDto.getName() + "\t"
						+ job[haksaDto.getKey()] + " : " + haksaDto.getValue());
			else
				System.out.println("ã�� �� �����ϴ�.");

			System.out.print("��� �Ͻ÷��� 1, �����Ͻ÷��� �ƹ�Ű�� �Է����ּ��� ");
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
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		try {
			String name = in.readLine().trim();

			if (delete(name) != 0)
				System.out.println(name + "���� ����");
			else
				System.out.println("ã�� �� �����ϴ�.");

			System.out.print("��� �Ͻ÷��� 1, �����Ͻ÷��� �ƹ�Ű��  �Է����ּ��� ");
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

		System.out.print("��� �Ͻ÷��� 1, �����Ͻ÷��� �ƹ�Ű�� �Է����ּ��� ");
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

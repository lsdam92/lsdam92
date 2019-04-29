package com.kitri.haksa.data;

public class HaksaDto {

	private int age;
	private String name;
	private int key;
	private String keyname;

	private String value;

	public HaksaDto(int age, String name, int key, String value) {
		this.age = age;
		this.name = name;
		this.key = key;
		this.value = value;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

//	public String getKeyname() {
//		return keyname;
//	}
//	
//	public void setKeyname(String keyname) {
//		this.keyname = keyname;
//	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String info = "나이 : " + getAge();
		info += "이름 : " + getName();
		info += "직업 : ";
		
		if(key == 1) {
			info += "학생";
			info += "학번 : ";
		} else if(key == 2) {
			info += "교수";
			info += "과목 : ";
		} else {
			info += "관리자";
			info += "부서 : ";
		}
		
		info += getValue();
		return info;
	}

}

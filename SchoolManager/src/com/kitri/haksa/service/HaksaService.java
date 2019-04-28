package com.kitri.haksa.service;

import com.kitri.haksa.data.HaksaDto;

public interface HaksaService {
	
	
	public abstract void menu();
	public abstract void registerMenu();
	public abstract void register(HaksaDto haksa); 
	public abstract void findNameMenu(); 
	public abstract HaksaDto findName(String name); 
	public abstract void deleteMenu();
	public abstract int delete(String name);
	public abstract void selectAll(); 
	public abstract void processExit();
}
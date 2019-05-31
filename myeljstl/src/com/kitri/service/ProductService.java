package com.kitri.service;

import java.util.List;

import com.kitri.dao.ProductDao;
import com.kitri.dto.Product;

import NotFoundException.NotFoundException;

public class ProductService {
	private ProductDao dao;
	public ProductService() {
		dao = new ProductDao();
	}
	public List<Product> findAll(){
		return dao.selectAll();
	}
	public Product findByNo(String no){
		return dao.selectByNo(no);
	}
}

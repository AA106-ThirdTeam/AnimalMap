package com.animal_index.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
public class Animal_indexService{
	private Animal_indexDAO_interface dao; 

	public Animal_indexService(){
		dao = new Animal_indexDAO();
	}

	//====以下是insert方法====
	public Animal_indexVO addAnimal_index(String animal_detail,String animal_class,String animal_class_No){
		Animal_indexVO animal_indexVO = new Animal_indexVO();

		animal_indexVO.setAnimal_detail(animal_detail);
		animal_indexVO.setAnimal_class(animal_class);
		animal_indexVO.setAnimal_class_No(animal_class_No);

		dao.insert(animal_indexVO);

		return animal_indexVO;
	}

	//====以下是update方法====
	public Animal_indexVO updateAnimal_index(String animal_No,String animal_detail,String animal_class,String animal_class_No){

		Animal_indexVO animal_indexVO = new Animal_indexVO();

		animal_indexVO.setAnimal_No(animal_No);
		animal_indexVO.setAnimal_detail(animal_detail);
		animal_indexVO.setAnimal_class(animal_class);
		animal_indexVO.setAnimal_class_No(animal_class_No);

		dao.update(animal_indexVO);

		return animal_indexVO;
	}

	//====以下是delete方法====
	public void deleteAnimal_index(String  animal_No){
		dao.delete(animal_No);
	}

	//====以下是getOne方法====
	public Animal_indexVO getOneAnimal_index(String  animal_No){
		return dao.findByPrimaryKey(animal_No);
	}

	//====以下是getAll方法====
	public List<Animal_indexVO> getAll(){
		return dao.getAll();
	}
}

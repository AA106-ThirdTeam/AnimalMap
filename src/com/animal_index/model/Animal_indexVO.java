package com.animal_index.model;

import java.sql.*; 
import java.util.Set; 
import java.util.LinkedHashSet;; 

/** 
 *表格名稱 : <br>
 *	中文:動物圖鑑<br>
 *	英文:animal_index<br>
 */ 
public class Animal_indexVO implements java.io.Serializable{
	private static final long serialVersionUID = 1L; 
	private	String animal_No; 
	private	String animal_detail; 
	private	String animal_class; 
	private	String animal_class_No; 
	public	String getAnimal_No() { 
		return this.animal_No;
	} 
	public	String getAnimal_detail() { 
		return this.animal_detail;
	} 
	public	String getAnimal_class() { 
		return this.animal_class;
	} 
	public	String getAnimal_class_No() { 
		return this.animal_class_No;
	} 
	public	void setAnimal_No(String aAnimal_No) { 
		this.animal_No = aAnimal_No; 
	} 
 
	public	void setAnimal_detail(String aAnimal_detail) { 
		this.animal_detail = aAnimal_detail; 
	} 
 
	public	void setAnimal_class(String aAnimal_class) { 
		this.animal_class = aAnimal_class; 
	} 
 
	public	void setAnimal_class_No(String aAnimal_class_No) { 
		this.animal_class_No = aAnimal_class_No; 
	} 
 
}
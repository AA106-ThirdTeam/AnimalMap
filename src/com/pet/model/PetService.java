package com.pet.model;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/** 
 *表格名稱 : <br>
 *	中文:自家寵物<br>
 *	英文:pet<br>
 */ 
public class PetService{
	private PetDAO_interface dao; 

	public PetService(){
		dao = new PetDAO();
	}

	//====以下是insert方法====
	public PetVO addPet(String mem_Id,String pet_name,String pet_type,String pet_gender,String pet_heal,String pet_Vac,String pet_color,String pet_body,String pet_age,String pet_Neu,String pet_chip,java.sql.Date pet_birth,String pet_status,java.sql.Date pet_CreDATE,String pet_city,String pet_town,String pet_road,Double pet_FinLat,Double pet_FinLon){
		PetVO petVO = new PetVO();

		petVO.setMem_Id(mem_Id);
		petVO.setPet_name(pet_name);
		petVO.setPet_type(pet_type);
		petVO.setPet_gender(pet_gender);
		petVO.setPet_heal(pet_heal);
		petVO.setPet_Vac(pet_Vac);
		petVO.setPet_color(pet_color);
		petVO.setPet_body(pet_body);
		petVO.setPet_age(pet_age);
		petVO.setPet_Neu(pet_Neu);
		petVO.setPet_chip(pet_chip);
		petVO.setPet_birth(pet_birth);
		petVO.setPet_status(pet_status);
		petVO.setPet_CreDATE(pet_CreDATE);
		petVO.setPet_city(pet_city);
		petVO.setPet_town(pet_town);
		petVO.setPet_road(pet_road);
		petVO.setPet_FinLat(pet_FinLat);
		petVO.setPet_FinLon(pet_FinLon);

		dao.insert(petVO);

		return petVO;
	}

	//====以下是update方法====
	public PetVO updatePet(String pet_Id,String mem_Id,String pet_name,String pet_type,String pet_gender,String pet_heal,String pet_Vac,String pet_color,String pet_body,String pet_age,String pet_Neu,String pet_chip,java.sql.Date pet_birth,String pet_status,java.sql.Date pet_CreDATE,String pet_city,String pet_town,String pet_road,Double pet_FinLat,Double pet_FinLon){

		PetVO petVO = new PetVO();

		petVO.setPet_Id(pet_Id);
		petVO.setMem_Id(mem_Id);
		petVO.setPet_name(pet_name);
		petVO.setPet_type(pet_type);
		petVO.setPet_gender(pet_gender);
		petVO.setPet_heal(pet_heal);
		petVO.setPet_Vac(pet_Vac);
		petVO.setPet_color(pet_color);
		petVO.setPet_body(pet_body);
		petVO.setPet_age(pet_age);
		petVO.setPet_Neu(pet_Neu);
		petVO.setPet_chip(pet_chip);
		petVO.setPet_birth(pet_birth);
		petVO.setPet_status(pet_status);
		petVO.setPet_CreDATE(pet_CreDATE);
		petVO.setPet_city(pet_city);
		petVO.setPet_town(pet_town);
		petVO.setPet_road(pet_road);
		petVO.setPet_FinLat(pet_FinLat);
		petVO.setPet_FinLon(pet_FinLon);

		dao.update(petVO);

		return petVO;
	}

	//====以下是delete方法====
	public void deletePet(String  pet_Id){
		dao.delete(pet_Id);
	}

	//====以下是getOne方法====
	public PetVO getOnePet(String  pet_Id){
		return dao.findByPrimaryKey(pet_Id);
	}

	//====以下是getAll方法====
	public List<PetVO> getAll(){
		return dao.getAll();
	}
	//====以下是getAll_jdbcUtil_CompositeQuery方法====
	public List<PetVO> getAll(Map<String, String[]> map){
		return dao.getAll(map);
	}

    //====以下是getSet方法====
    public Set<PetVO> getPetsByMem_Id(String mem_Id) {
        return dao.getPetsByMem_Id(mem_Id);
    }
}

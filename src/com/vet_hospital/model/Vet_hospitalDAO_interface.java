package com.vet_hospital.model;

import java.util.*; 

public interface Vet_hospitalDAO_interface {
	public void insert(Vet_hospitalVO vet_hospitalVO);
	public void update(Vet_hospitalVO vet_hospitalVO);
    public void delete(String hos_Id);
	public Vet_hospitalVO findByPrimaryKey(String hos_Id);
	public List<Vet_hospitalVO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Vet_hospitalVO> getAll(Map<String, String[]> map);

    //查詢某診所的會員編號(負責人)(一對多)(回傳 Set)
    public Set<Vet_hospitalVO> getVet_hospitalsByMem_Id(String hos_MemId);
}

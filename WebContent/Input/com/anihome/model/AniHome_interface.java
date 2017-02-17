package com.anihome.model;
import java.util.*;
public interface AniHome_interface {
          public void insert(AniHomeVO anihomeVO);
          public void update(AniHomeVO anihomeVO);
          public void delete(Integer aniHome_Id);
          public AniHomeVO findByPrimaryKey(Integer aniHome_Id);
          public List<AniHomeVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AniHomeVO> getAll(Map<String, String[]> map); 
}

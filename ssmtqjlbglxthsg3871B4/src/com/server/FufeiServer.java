package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Fufei;

public interface FufeiServer {

  public int add(Fufei po);

  public int update(Fufei po);
  
  
  
  public int delete(int id);

  public List<Fufei> getAll(Map<String,Object> map);
  public List<Fufei> getsyfufei1(Map<String,Object> map);
  public List<Fufei> getsyfufei2(Map<String,Object> map);
  public List<Fufei> getsyfufei3(Map<String,Object> map);
  public Fufei quchongFufei(Map<String, Object> acount);

  public Fufei getById( int id);

  public List<Fufei> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Fufei> select(Map<String, Object> map);
}
//	所有List

package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Dingzhuoxinxi;

public interface DingzhuoxinxiServer {

  public int add(Dingzhuoxinxi po);

  public int update(Dingzhuoxinxi po);
  
  
  
  public int delete(int id);

  public List<Dingzhuoxinxi> getAll(Map<String,Object> map);
  public List<Dingzhuoxinxi> getsydingzhuoxinxi1(Map<String,Object> map);
  public List<Dingzhuoxinxi> getsydingzhuoxinxi2(Map<String,Object> map);
  public List<Dingzhuoxinxi> getsydingzhuoxinxi3(Map<String,Object> map);
  public Dingzhuoxinxi quchongDingzhuoxinxi(Map<String, Object> acount);

  public Dingzhuoxinxi getById( int id);

  public List<Dingzhuoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Dingzhuoxinxi> select(Map<String, Object> map);
}
//	所有List

package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Huodongxinxi;

public interface HuodongxinxiServer {

  public int add(Huodongxinxi po);

  public int update(Huodongxinxi po);
  
  
  
  public int delete(int id);

  public List<Huodongxinxi> getAll(Map<String,Object> map);
  public List<Huodongxinxi> getsyhuodongxinxi1(Map<String,Object> map);
  public List<Huodongxinxi> getsyhuodongxinxi2(Map<String,Object> map);
  public List<Huodongxinxi> getsyhuodongxinxi3(Map<String,Object> map);
  public Huodongxinxi quchongHuodongxinxi(Map<String, Object> acount);

  public Huodongxinxi getById( int id);

  public List<Huodongxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Huodongxinxi> select(Map<String, Object> map);
}
//	所有List

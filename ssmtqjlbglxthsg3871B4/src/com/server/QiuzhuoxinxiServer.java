package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qiuzhuoxinxi;

public interface QiuzhuoxinxiServer {

  public int add(Qiuzhuoxinxi po);

  public int update(Qiuzhuoxinxi po);
  
  
  
  public int delete(int id);

  public List<Qiuzhuoxinxi> getAll(Map<String,Object> map);
  public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi1(Map<String,Object> map);
  public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi2(Map<String,Object> map);
  public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi3(Map<String,Object> map);
  public Qiuzhuoxinxi quchongQiuzhuoxinxi(Map<String, Object> acount);

  public Qiuzhuoxinxi getById( int id);

  public List<Qiuzhuoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qiuzhuoxinxi> select(Map<String, Object> map);
}
//	所有List

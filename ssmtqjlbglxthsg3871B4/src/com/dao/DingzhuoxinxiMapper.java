package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dingzhuoxinxi;

public interface DingzhuoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dingzhuoxinxi record);

    int insertSelective(Dingzhuoxinxi record);

    Dingzhuoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dingzhuoxinxi record);
	
    int updateByPrimaryKey(Dingzhuoxinxi record);
	public Dingzhuoxinxi quchongDingzhuoxinxi(Map<String, Object> huiyuanbianhao);
	public List<Dingzhuoxinxi> getAll(Map<String, Object> map);
	public List<Dingzhuoxinxi> getsydingzhuoxinxi1(Map<String, Object> map);
	public List<Dingzhuoxinxi> getsydingzhuoxinxi3(Map<String, Object> map);
	public List<Dingzhuoxinxi> getsydingzhuoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dingzhuoxinxi> getByPage(Map<String, Object> map);
	public List<Dingzhuoxinxi> select(Map<String, Object> map);
//	所有List
}


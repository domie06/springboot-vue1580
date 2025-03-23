package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huodongxinxi;

public interface HuodongxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huodongxinxi record);

    int insertSelective(Huodongxinxi record);

    Huodongxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huodongxinxi record);
	
    int updateByPrimaryKey(Huodongxinxi record);
	public Huodongxinxi quchongHuodongxinxi(Map<String, Object> bianhao);
	public List<Huodongxinxi> getAll(Map<String, Object> map);
	public List<Huodongxinxi> getsyhuodongxinxi1(Map<String, Object> map);
	public List<Huodongxinxi> getsyhuodongxinxi3(Map<String, Object> map);
	public List<Huodongxinxi> getsyhuodongxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huodongxinxi> getByPage(Map<String, Object> map);
	public List<Huodongxinxi> select(Map<String, Object> map);
//	所有List
}


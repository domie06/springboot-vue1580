package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fufei;

public interface FufeiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fufei record);

    int insertSelective(Fufei record);

    Fufei selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fufei record);
	
    int updateByPrimaryKey(Fufei record);
	public Fufei quchongFufei(Map<String, Object> huiyuanbianhao);
	public List<Fufei> getAll(Map<String, Object> map);
	public List<Fufei> getsyfufei1(Map<String, Object> map);
	public List<Fufei> getsyfufei3(Map<String, Object> map);
	public List<Fufei> getsyfufei2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Fufei> getByPage(Map<String, Object> map);
	public List<Fufei> select(Map<String, Object> map);
//	所有List
}


package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qiuzhuoxinxi;

public interface QiuzhuoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qiuzhuoxinxi record);

    int insertSelective(Qiuzhuoxinxi record);

    Qiuzhuoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qiuzhuoxinxi record);
	
    int updateByPrimaryKey(Qiuzhuoxinxi record);
	public Qiuzhuoxinxi quchongQiuzhuoxinxi(Map<String, Object> qiuzhuohao);
	public List<Qiuzhuoxinxi> getAll(Map<String, Object> map);
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi1(Map<String, Object> map);
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi3(Map<String, Object> map);
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qiuzhuoxinxi> getByPage(Map<String, Object> map);
	public List<Qiuzhuoxinxi> select(Map<String, Object> map);
//	所有List
}


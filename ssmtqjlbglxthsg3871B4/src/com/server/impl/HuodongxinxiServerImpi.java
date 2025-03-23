package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HuodongxinxiMapper;
import com.entity.Huodongxinxi;
import com.server.HuodongxinxiServer;
@Service
public class HuodongxinxiServerImpi implements HuodongxinxiServer {
   @Resource
   private HuodongxinxiMapper gdao;
	@Override
	public int add(Huodongxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huodongxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huodongxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huodongxinxi> getsyhuodongxinxi1(Map<String, Object> map) {
		return gdao.getsyhuodongxinxi1(map);
	}
	public List<Huodongxinxi> getsyhuodongxinxi2(Map<String, Object> map) {
		return gdao.getsyhuodongxinxi2(map);
	}
	public List<Huodongxinxi> getsyhuodongxinxi3(Map<String, Object> map) {
		return gdao.getsyhuodongxinxi3(map);
	}
	
	@Override
	public Huodongxinxi quchongHuodongxinxi(Map<String, Object> account) {
		return gdao.quchongHuodongxinxi(account);
	}

	@Override
	public List<Huodongxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huodongxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huodongxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


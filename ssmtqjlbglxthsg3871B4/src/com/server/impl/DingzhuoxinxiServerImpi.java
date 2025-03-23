package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DingzhuoxinxiMapper;
import com.entity.Dingzhuoxinxi;
import com.server.DingzhuoxinxiServer;
@Service
public class DingzhuoxinxiServerImpi implements DingzhuoxinxiServer {
   @Resource
   private DingzhuoxinxiMapper gdao;
	@Override
	public int add(Dingzhuoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dingzhuoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dingzhuoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dingzhuoxinxi> getsydingzhuoxinxi1(Map<String, Object> map) {
		return gdao.getsydingzhuoxinxi1(map);
	}
	public List<Dingzhuoxinxi> getsydingzhuoxinxi2(Map<String, Object> map) {
		return gdao.getsydingzhuoxinxi2(map);
	}
	public List<Dingzhuoxinxi> getsydingzhuoxinxi3(Map<String, Object> map) {
		return gdao.getsydingzhuoxinxi3(map);
	}
	
	@Override
	public Dingzhuoxinxi quchongDingzhuoxinxi(Map<String, Object> account) {
		return gdao.quchongDingzhuoxinxi(account);
	}

	@Override
	public List<Dingzhuoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dingzhuoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dingzhuoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


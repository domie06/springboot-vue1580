package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FufeiMapper;
import com.entity.Fufei;
import com.server.FufeiServer;
@Service
public class FufeiServerImpi implements FufeiServer {
   @Resource
   private FufeiMapper gdao;
	@Override
	public int add(Fufei po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Fufei po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Fufei> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Fufei> getsyfufei1(Map<String, Object> map) {
		return gdao.getsyfufei1(map);
	}
	public List<Fufei> getsyfufei2(Map<String, Object> map) {
		return gdao.getsyfufei2(map);
	}
	public List<Fufei> getsyfufei3(Map<String, Object> map) {
		return gdao.getsyfufei3(map);
	}
	
	@Override
	public Fufei quchongFufei(Map<String, Object> account) {
		return gdao.quchongFufei(account);
	}

	@Override
	public List<Fufei> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Fufei> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Fufei getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


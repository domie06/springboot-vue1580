package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QiuzhuoxinxiMapper;
import com.entity.Qiuzhuoxinxi;
import com.server.QiuzhuoxinxiServer;
@Service
public class QiuzhuoxinxiServerImpi implements QiuzhuoxinxiServer {
   @Resource
   private QiuzhuoxinxiMapper gdao;
	@Override
	public int add(Qiuzhuoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qiuzhuoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qiuzhuoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi1(Map<String, Object> map) {
		return gdao.getsyqiuzhuoxinxi1(map);
	}
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi2(Map<String, Object> map) {
		return gdao.getsyqiuzhuoxinxi2(map);
	}
	public List<Qiuzhuoxinxi> getsyqiuzhuoxinxi3(Map<String, Object> map) {
		return gdao.getsyqiuzhuoxinxi3(map);
	}
	
	@Override
	public Qiuzhuoxinxi quchongQiuzhuoxinxi(Map<String, Object> account) {
		return gdao.quchongQiuzhuoxinxi(account);
	}

	@Override
	public List<Qiuzhuoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qiuzhuoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qiuzhuoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}


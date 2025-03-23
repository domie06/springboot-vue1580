package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Qiuzhuoxinxi;
import com.server.QiuzhuoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QiuzhuoxinxiController {
	@Resource
	private QiuzhuoxinxiServer qiuzhuoxinxiService;


   
	@RequestMapping("addQiuzhuoxinxi.do")
	public String addQiuzhuoxinxi(HttpServletRequest request,Qiuzhuoxinxi qiuzhuoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qiuzhuoxinxi.setAddtime(time.toString().substring(0, 19));
		qiuzhuoxinxiService.add(qiuzhuoxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qiuzhuoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qiuzhuoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQiuzhuoxinxi.do")
	public String doUpdateQiuzhuoxinxi(int id,ModelMap map,Qiuzhuoxinxi qiuzhuoxinxi){
		qiuzhuoxinxi=qiuzhuoxinxiService.getById(id);
		map.put("qiuzhuoxinxi", qiuzhuoxinxi);
		return "qiuzhuoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("qiuzhuoxinxiDetail.do")
	public String qiuzhuoxinxiDetail(int id,ModelMap map,Qiuzhuoxinxi qiuzhuoxinxi){
		qiuzhuoxinxi=qiuzhuoxinxiService.getById(id);
		map.put("qiuzhuoxinxi", qiuzhuoxinxi);
		return "qiuzhuoxinxi_detail";
	}
//	前台详细
	@RequestMapping("qzxxDetail.do")
	public String qzxxDetail(int id,ModelMap map,Qiuzhuoxinxi qiuzhuoxinxi){
		qiuzhuoxinxi=qiuzhuoxinxiService.getById(id);
		map.put("qiuzhuoxinxi", qiuzhuoxinxi);
		return "qiuzhuoxinxidetail";
	}
//	
	@RequestMapping("updateQiuzhuoxinxi.do")
	public String updateQiuzhuoxinxi(int id,ModelMap map,Qiuzhuoxinxi qiuzhuoxinxi,HttpServletRequest request,HttpSession session){
		qiuzhuoxinxiService.update(qiuzhuoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qiuzhuoxinxiList.do";
	}

//	分页查询
	@RequestMapping("qiuzhuoxinxiList.do")
	public String qiuzhuoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiuzhuoxinxi qiuzhuoxinxi, String qiuzhuohao, String zhuangtai, String meixiaoshijifei, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=qiuzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiuzhuoxinxi> list=qiuzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiuzhuoxinxi_list";
	}
	
	
	

	
	
	@RequestMapping("qzxxList.do")
	public String qzxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiuzhuoxinxi qiuzhuoxinxi, String qiuzhuohao, String zhuangtai, String meixiaoshijifei, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=qiuzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiuzhuoxinxi> list=qiuzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiuzhuoxinxilist";
	}
	
	
	@RequestMapping("qiuzhuoxinxiList2.do")
	public String qiuzhuoxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiuzhuoxinxi qiuzhuoxinxi, String qiuzhuohao, String zhuangtai, String meixiaoshijifei, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=qiuzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiuzhuoxinxi> list=qiuzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiuzhuoxinxi_list2";
	}
	
	
	

	
	
	@RequestMapping("deleteQiuzhuoxinxi.do")
	public String deleteQiuzhuoxinxi(int id,HttpServletRequest request){
		qiuzhuoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qiuzhuoxinxiList.do";
	}
	
	
}

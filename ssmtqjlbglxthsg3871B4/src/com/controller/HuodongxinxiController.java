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

import com.entity.Huodongxinxi;
import com.server.HuodongxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuodongxinxiController {
	@Resource
	private HuodongxinxiServer huodongxinxiService;


   
	@RequestMapping("addHuodongxinxi.do")
	public String addHuodongxinxi(HttpServletRequest request,Huodongxinxi huodongxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huodongxinxi.setAddtime(time.toString().substring(0, 19));
		huodongxinxiService.add(huodongxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huodongxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huodongxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuodongxinxi.do")
	public String doUpdateHuodongxinxi(int id,ModelMap map,Huodongxinxi huodongxinxi){
		huodongxinxi=huodongxinxiService.getById(id);
		map.put("huodongxinxi", huodongxinxi);
		return "huodongxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huodongxinxiDetail.do")
	public String huodongxinxiDetail(int id,ModelMap map,Huodongxinxi huodongxinxi){
		huodongxinxi=huodongxinxiService.getById(id);
		map.put("huodongxinxi", huodongxinxi);
		return "huodongxinxi_detail";
	}
//	前台详细
	@RequestMapping("hdxxDetail.do")
	public String hdxxDetail(int id,ModelMap map,Huodongxinxi huodongxinxi){
		huodongxinxi=huodongxinxiService.getById(id);
		map.put("huodongxinxi", huodongxinxi);
		return "huodongxinxidetail";
	}
//	
	@RequestMapping("updateHuodongxinxi.do")
	public String updateHuodongxinxi(int id,ModelMap map,Huodongxinxi huodongxinxi,HttpServletRequest request,HttpSession session){
		huodongxinxiService.update(huodongxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huodongxinxiList.do";
	}

//	分页查询
	@RequestMapping("huodongxinxiList.do")
	public String huodongxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongxinxi huodongxinxi, String bianhao, String biaoti, String neirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		int total=huodongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongxinxi> list=huodongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongxinxi_list";
	}
	
	@RequestMapping("huodongxinxiList2.do")
	public String huodongxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongxinxi huodongxinxi, String bianhao, String biaoti, String neirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		int total=huodongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongxinxi> list=huodongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongxinxi_list2";
	}
	
	
	@RequestMapping("hdxxList.do")
	public String hdxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huodongxinxi huodongxinxi, String bianhao, String biaoti, String neirong){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		
		int total=huodongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huodongxinxi> list=huodongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huodongxinxilist";
	}
	
	@RequestMapping("deleteHuodongxinxi.do")
	public String deleteHuodongxinxi(int id,HttpServletRequest request){
		huodongxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huodongxinxiList.do";
	}
	
	@RequestMapping("quchongHuodongxinxi.do")
	public void quchongHuodongxinxi(Huodongxinxi huodongxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", huodongxinxi.getBianhao());
		   System.out.println("bianhao==="+huodongxinxi.getBianhao());
		   System.out.println("bianhao222==="+huodongxinxiService.quchongHuodongxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(huodongxinxiService.quchongHuodongxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}

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

import com.entity.Huiyuanxinxi;
import com.server.HuiyuanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuiyuanxinxiController {
	@Resource
	private HuiyuanxinxiServer huiyuanxinxiService;


   
	@RequestMapping("addHuiyuanxinxi.do")
	public String addHuiyuanxinxi(HttpServletRequest request,Huiyuanxinxi huiyuanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huiyuanxinxi.setAddtime(time.toString().substring(0, 19));
		huiyuanxinxiService.add(huiyuanxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huiyuanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huiyuanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuiyuanxinxi.do")
	public String doUpdateHuiyuanxinxi(int id,ModelMap map,Huiyuanxinxi huiyuanxinxi){
		huiyuanxinxi=huiyuanxinxiService.getById(id);
		map.put("huiyuanxinxi", huiyuanxinxi);
		return "huiyuanxinxi_updt";
	}
	
	@RequestMapping("doUpdateHuiyuanxinxi2.do")
	public String doUpdateHuiyuanxinxi2(ModelMap map,Huiyuanxinxi huiyuanxinxi,HttpServletRequest request){
		huiyuanxinxi=huiyuanxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("huiyuanxinxi", huiyuanxinxi);
		return "huiyuanxinxi_updt2";
	}
	
@RequestMapping("updateHuiyuanxinxi2.do")
	public String updateHuiyuanxinxi2(int id,ModelMap map,Huiyuanxinxi huiyuanxinxi){
		huiyuanxinxiService.update(huiyuanxinxi);
		return "redirect:doUpdateHuiyuanxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("huiyuanxinxiDetail.do")
	public String huiyuanxinxiDetail(int id,ModelMap map,Huiyuanxinxi huiyuanxinxi){
		huiyuanxinxi=huiyuanxinxiService.getById(id);
		map.put("huiyuanxinxi", huiyuanxinxi);
		return "huiyuanxinxi_detail";
	}
//	前台详细
	@RequestMapping("hyxxDetail.do")
	public String hyxxDetail(int id,ModelMap map,Huiyuanxinxi huiyuanxinxi){
		huiyuanxinxi=huiyuanxinxiService.getById(id);
		map.put("huiyuanxinxi", huiyuanxinxi);
		return "huiyuanxinxidetail";
	}
//	
	@RequestMapping("updateHuiyuanxinxi.do")
	public String updateHuiyuanxinxi(int id,ModelMap map,Huiyuanxinxi huiyuanxinxi,HttpServletRequest request,HttpSession session){
		huiyuanxinxiService.update(huiyuanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huiyuanxinxiList.do";
	}

//	分页查询
	@RequestMapping("huiyuanxinxiList.do")
	public String huiyuanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuanxinxi huiyuanxinxi, String huiyuanbianhao, String mima, String xingming, String xingbie, String huiyuandengji, String zhekou, String shouji, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=huiyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuanxinxi> list=huiyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuanxinxi_list";
	}
	
	
	
	@RequestMapping("hyxxList.do")
	public String hyxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huiyuanxinxi huiyuanxinxi, String huiyuanbianhao, String mima, String xingming, String xingbie, String huiyuandengji, String zhekou, String shouji, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=huiyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huiyuanxinxi> list=huiyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huiyuanxinxilist";
	}
	
	@RequestMapping("deleteHuiyuanxinxi.do")
	public String deleteHuiyuanxinxi(int id,HttpServletRequest request){
		huiyuanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huiyuanxinxiList.do";
	}
	
	@RequestMapping("quchongHuiyuanxinxi.do")
	public void quchongHuiyuanxinxi(Huiyuanxinxi huiyuanxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("huiyuanbianhao", huiyuanxinxi.getHuiyuanbianhao());
		   System.out.println("huiyuanbianhao==="+huiyuanxinxi.getHuiyuanbianhao());
		   System.out.println("huiyuanbianhao222==="+huiyuanxinxiService.quchongHuiyuanxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(huiyuanxinxiService.quchongHuiyuanxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "会员编号可以用！");
				  
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

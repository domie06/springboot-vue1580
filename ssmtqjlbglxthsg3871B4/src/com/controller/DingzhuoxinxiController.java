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

import com.entity.Dingzhuoxinxi;
import com.server.DingzhuoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DingzhuoxinxiController {
	@Resource
	private DingzhuoxinxiServer dingzhuoxinxiService;


   
	@RequestMapping("addDingzhuoxinxi.do")
	public String addDingzhuoxinxi(HttpServletRequest request,Dingzhuoxinxi dingzhuoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		dingzhuoxinxi.setAddtime(time.toString().substring(0, 19));
		dingzhuoxinxiService.add(dingzhuoxinxi);
		
		String sql="";
		sql="update qiuzhuoxinxi set zhuangtai='已订' where qiuzhuohao='"+dingzhuoxinxi.getQiuzhuohao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		
		
		//session.setAttribute("backurl", "dingzhuoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:dingzhuoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDingzhuoxinxi.do")
	public String doUpdateDingzhuoxinxi(int id,ModelMap map,Dingzhuoxinxi dingzhuoxinxi){
		dingzhuoxinxi=dingzhuoxinxiService.getById(id);
		map.put("dingzhuoxinxi", dingzhuoxinxi);
		return "dingzhuoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("dingzhuoxinxiDetail.do")
	public String dingzhuoxinxiDetail(int id,ModelMap map,Dingzhuoxinxi dingzhuoxinxi){
		dingzhuoxinxi=dingzhuoxinxiService.getById(id);
		map.put("dingzhuoxinxi", dingzhuoxinxi);
		return "dingzhuoxinxi_detail";
	}
//	前台详细
	@RequestMapping("dzxxDetail.do")
	public String dzxxDetail(int id,ModelMap map,Dingzhuoxinxi dingzhuoxinxi){
		dingzhuoxinxi=dingzhuoxinxiService.getById(id);
		map.put("dingzhuoxinxi", dingzhuoxinxi);
		return "dingzhuoxinxidetail";
	}
//	
	@RequestMapping("updateDingzhuoxinxi.do")
	public String updateDingzhuoxinxi(int id,ModelMap map,Dingzhuoxinxi dingzhuoxinxi,HttpServletRequest request,HttpSession session){
		dingzhuoxinxiService.update(dingzhuoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:dingzhuoxinxiList.do";
	}

//	分页查询
	@RequestMapping("dingzhuoxinxiList.do")
	public String dingzhuoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingzhuoxinxi dingzhuoxinxi, String qiuzhuohao, String meixiaoshijifei1,String meixiaoshijifei2, String dingzhuoshijian, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(meixiaoshijifei1==null||meixiaoshijifei1.equals("")){pmap.put("meixiaoshijifei1", null);}else{pmap.put("meixiaoshijifei1", meixiaoshijifei1);}
		if(meixiaoshijifei2==null||meixiaoshijifei2.equals("")){pmap.put("meixiaoshijifei2", null);}else{pmap.put("meixiaoshijifei2", meixiaoshijifei2);}
		if(dingzhuoshijian==null||dingzhuoshijian.equals("")){pmap.put("dingzhuoshijian", null);}else{pmap.put("dingzhuoshijian", dingzhuoshijian);}
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=dingzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingzhuoxinxi> list=dingzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingzhuoxinxi_list";
	}
	
	@RequestMapping("dingzhuoxinxiList2.do")
	public String dingzhuoxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingzhuoxinxi dingzhuoxinxi, String qiuzhuohao, String meixiaoshijifei1,String meixiaoshijifei2, String dingzhuoshijian, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String beizhu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("huiyuanbianhao", (String)request.getSession().getAttribute("username"));
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(meixiaoshijifei1==null||meixiaoshijifei1.equals("")){pmap.put("meixiaoshijifei1", null);}else{pmap.put("meixiaoshijifei1", meixiaoshijifei1);}
		if(meixiaoshijifei2==null||meixiaoshijifei2.equals("")){pmap.put("meixiaoshijifei2", null);}else{pmap.put("meixiaoshijifei2", meixiaoshijifei2);}
		if(dingzhuoshijian==null||dingzhuoshijian.equals("")){pmap.put("dingzhuoshijian", null);}else{pmap.put("dingzhuoshijian", dingzhuoshijian);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=dingzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingzhuoxinxi> list=dingzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingzhuoxinxi_list2";
	}
	
	
	@RequestMapping("dzxxList.do")
	public String dzxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingzhuoxinxi dingzhuoxinxi, String qiuzhuohao, String meixiaoshijifei1,String meixiaoshijifei2, String dingzhuoshijian, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(meixiaoshijifei1==null||meixiaoshijifei1.equals("")){pmap.put("meixiaoshijifei1", null);}else{pmap.put("meixiaoshijifei1", meixiaoshijifei1);}
		if(meixiaoshijifei2==null||meixiaoshijifei2.equals("")){pmap.put("meixiaoshijifei2", null);}else{pmap.put("meixiaoshijifei2", meixiaoshijifei2);}
		if(dingzhuoshijian==null||dingzhuoshijian.equals("")){pmap.put("dingzhuoshijian", null);}else{pmap.put("dingzhuoshijian", dingzhuoshijian);}
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=dingzhuoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingzhuoxinxi> list=dingzhuoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingzhuoxinxilist";
	}
	
	@RequestMapping("deleteDingzhuoxinxi.do")
	public String deleteDingzhuoxinxi(int id,HttpServletRequest request){
		dingzhuoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:dingzhuoxinxiList.do";
	}
	
	
}

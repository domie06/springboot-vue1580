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

import com.entity.Fufei;
import com.server.FufeiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class FufeiController {
	@Resource
	private FufeiServer fufeiService;


   
	@RequestMapping("addFufei.do")
	public String addFufei(HttpServletRequest request,Fufei fufei,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		fufei.setAddtime(time.toString().substring(0, 19));
		fufeiService.add(fufei);
		
		
		String sql="";
		sql="update qiuzhuoxinxi set zhuangtai='空闲' where qiuzhuohao='"+fufei.getQiuzhuohao()+"'";
		db dbo = new db();
		dbo.hsgexecute(sql);
		

		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "fufeiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:fufeiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateFufei.do")
	public String doUpdateFufei(int id,ModelMap map,Fufei fufei){
		fufei=fufeiService.getById(id);
		map.put("fufei", fufei);
		return "fufei_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("fufeiDetail.do")
	public String fufeiDetail(int id,ModelMap map,Fufei fufei){
		fufei=fufeiService.getById(id);
		map.put("fufei", fufei);
		return "fufei_detail";
	}
//	前台详细
	@RequestMapping("ffDetail.do")
	public String ffDetail(int id,ModelMap map,Fufei fufei){
		fufei=fufeiService.getById(id);
		map.put("fufei", fufei);
		return "fufeidetail";
	}
//	
	@RequestMapping("updateFufei.do")
	public String updateFufei(int id,ModelMap map,Fufei fufei,HttpServletRequest request,HttpSession session){
		fufeiService.update(fufei);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:fufeiList.do";
	}

//	分页查询
	@RequestMapping("fufeiList.do")
	public String fufeiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fufei fufei, String qiuzhuohao, String meixiaoshijifei, String zongshichang1,String zongshichang2, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String zongjine, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(zongshichang1==null||zongshichang1.equals("")){pmap.put("zongshichang1", null);}else{pmap.put("zongshichang1", zongshichang1);}
		if(zongshichang2==null||zongshichang2.equals("")){pmap.put("zongshichang2", null);}else{pmap.put("zongshichang2", zongshichang2);}
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=fufeiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fufei> list=fufeiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fufei_list";
	}
	
	@RequestMapping("fufeiList2.do")
	public String fufeiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fufei fufei, String qiuzhuohao, String meixiaoshijifei, String zongshichang1,String zongshichang2, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String zongjine, String beizhu, String issh,HttpServletRequest request){
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
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(zongshichang1==null||zongshichang1.equals("")){pmap.put("zongshichang1", null);}else{pmap.put("zongshichang1", zongshichang1);}
		if(zongshichang2==null||zongshichang2.equals("")){pmap.put("zongshichang2", null);}else{pmap.put("zongshichang2", zongshichang2);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=fufeiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fufei> list=fufeiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fufei_list2";
	}
	
	
	@RequestMapping("ffList.do")
	public String ffList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fufei fufei, String qiuzhuohao, String meixiaoshijifei, String zongshichang1,String zongshichang2, String huiyuanbianhao, String xingming, String huiyuandengji, String zhekou, String zongjine, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(qiuzhuohao==null||qiuzhuohao.equals("")){pmap.put("qiuzhuohao", null);}else{pmap.put("qiuzhuohao", qiuzhuohao);}
		if(meixiaoshijifei==null||meixiaoshijifei.equals("")){pmap.put("meixiaoshijifei", null);}else{pmap.put("meixiaoshijifei", meixiaoshijifei);}
		if(zongshichang1==null||zongshichang1.equals("")){pmap.put("zongshichang1", null);}else{pmap.put("zongshichang1", zongshichang1);}
		if(zongshichang2==null||zongshichang2.equals("")){pmap.put("zongshichang2", null);}else{pmap.put("zongshichang2", zongshichang2);}
		if(huiyuanbianhao==null||huiyuanbianhao.equals("")){pmap.put("huiyuanbianhao", null);}else{pmap.put("huiyuanbianhao", huiyuanbianhao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(huiyuandengji==null||huiyuandengji.equals("")){pmap.put("huiyuandengji", null);}else{pmap.put("huiyuandengji", huiyuandengji);}
		if(zhekou==null||zhekou.equals("")){pmap.put("zhekou", null);}else{pmap.put("zhekou", zhekou);}
		if(zongjine==null||zongjine.equals("")){pmap.put("zongjine", null);}else{pmap.put("zongjine", zongjine);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=fufeiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fufei> list=fufeiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fufeilist";
	}
	
	@RequestMapping("deleteFufei.do")
	public String deleteFufei(int id,HttpServletRequest request){
		fufeiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:fufeiList.do";
	}
	
	
}

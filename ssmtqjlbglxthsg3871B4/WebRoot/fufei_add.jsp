<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<%

		
 java.util.Date date = new java.util.Date();
java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);

String result = format.format(date);


String aa=request.getParameter("shichang");

int ss=connDbBean.getBetweenDayNumber(aa,result);


int sa=(ss/60)+1;



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加付费</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="fufei_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addFufei.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加付费</td>
						</tr>
						<tr ><td width="200">球桌号：</td><td><input name='qiuzhuohao' type='text' id='qiuzhuohao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.qiuzhuohao.value='<%=connDbBean.readzd("dingzhuoxinxi","qiuzhuohao","id",request.getParameter("id"))%>';document.form1.qiuzhuohao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">每小时计费：</td><td><input name='meixiaoshijifei' type='text' id='meixiaoshijifei' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.meixiaoshijifei.value='<%=connDbBean.readzd("dingzhuoxinxi","meixiaoshijifei","id",request.getParameter("id"))%>';document.form1.meixiaoshijifei.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">总时长：</td><td><input name='zongshichang' type='text' id='zongshichang' value='<%=sa%>' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelzongshichang' />没满一个小时按一个小时计费</td></tr>
		<tr ><td width="200">会员编号：</td><td><input name='huiyuanbianhao' type='text' id='huiyuanbianhao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("dingzhuoxinxi","xingming","id",request.getParameter("id"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">会员等级：</td><td><input name='huiyuandengji' type='text' id='huiyuandengji' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.huiyuandengji.value='<%=connDbBean.readzd("dingzhuoxinxi","huiyuandengji","id",request.getParameter("id"))%>';document.form1.huiyuandengji.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">折扣：</td><td><input name='zhekou' type='text' id='zhekou' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zhekou.value='<%=connDbBean.readzd("dingzhuoxinxi","zhekou","id",request.getParameter("id"))%>';document.form1.zhekou.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">总金额：</td><td><input name='zongjine' type='text' id='zongjine' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>
		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zongshichangobj = document.getElementById("zongshichang"); if(zongshichangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(zongshichangobj.value)){document.getElementById("clabelzongshichang").innerHTML=""; }else{document.getElementById("clabelzongshichang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var zongjinej=1;if(document.getElementById("meixiaoshijifei").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("meixiaoshijifei").value);}if(document.getElementById("zongshichang").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("zongshichang").value);}if(document.getElementById("zhekou").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("zhekou").value);}document.getElementById("zongjine").value=zongjinej;
	


return true;   
}   
popheight=450;
</script>  

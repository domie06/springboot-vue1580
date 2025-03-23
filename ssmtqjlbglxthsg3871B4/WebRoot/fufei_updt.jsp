<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改付费</TITLE>
	    
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
			<form action="updateFufei.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改付费<input type="hidden" name="id" value="${fufei.id}" /></td>
						</tr>
						<tr ><td width="200">球桌号：</td><td><input name='qiuzhuohao' type='text' id='qiuzhuohao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">每小时计费：</td><td><input name='meixiaoshijifei' type='text' id='meixiaoshijifei' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">总时长：</td><td><input name='zongshichang' type='text' id='zongshichang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelzongshichang' />必需数字型</td></tr>		<tr ><td width="200">会员编号：</td><td><input name='huiyuanbianhao' type='text' id='huiyuanbianhao' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">会员等级：</td><td><input name='huiyuandengji' type='text' id='huiyuandengji' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">折扣：</td><td><input name='zhekou' type='text' id='zhekou' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>		<tr ><td width="200">总金额：</td><td><input name='zongjine' type='text' id='zongjine' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.qiuzhuohao.value='${fufei.qiuzhuohao}';</script>	<script language="javascript">document.form1.meixiaoshijifei.value='${fufei.meixiaoshijifei}';</script>	<script language="javascript">document.form1.zongshichang.value='${fufei.zongshichang}';</script>	<script language="javascript">document.form1.huiyuanbianhao.value='${fufei.huiyuanbianhao}';</script>	<script language="javascript">document.form1.xingming.value='${fufei.xingming}';</script>	<script language="javascript">document.form1.huiyuandengji.value='${fufei.huiyuandengji}';</script>	<script language="javascript">document.form1.zhekou.value='${fufei.zhekou}';</script>	<script language="javascript">document.form1.zongjine.value='${fufei.zongjine}';</script>	<script language="javascript">document.form1.beizhu.value='${fufei.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	    var zongjinej=1;if(document.getElementById("meixiaoshijifei").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("meixiaoshijifei").value);}if(document.getElementById("zongshichang").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("zongshichang").value);}if(document.getElementById("zhekou").value!=""){zongjinej=zongjinej*parseFloat(document.getElementById("zhekou").value);}document.getElementById("zongjine").value=zongjinej;	


return true;   
}   
popheight=450;
</script>  

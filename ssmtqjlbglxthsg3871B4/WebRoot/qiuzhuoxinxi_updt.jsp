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
		<TITLE>修改球桌信息</TITLE>
	    
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
	document.location.href="qiuzhuoxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateQiuzhuoxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改球桌信息<input type="hidden" name="id" value="${qiuzhuoxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">球桌号：</td><td><input name='qiuzhuohao' type='text' id='qiuzhuohao' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelqiuzhuohao' /></td></tr>		<tr ><td width="200">状态：</td><td><select name='zhuangtai' id='zhuangtai'><option value="空闲">空闲</option><option value="已订">已订</option></select>&nbsp;*<label id='clabelzhuangtai' /></td></tr>		<tr ><td width="200">每小时计费：</td><td><input name='meixiaoshijifei' type='text' id='meixiaoshijifei' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.qiuzhuohao.value='${qiuzhuoxinxi.qiuzhuohao}';</script>	<script language="javascript">document.form1.zhuangtai.value='${qiuzhuoxinxi.zhuangtai}';</script>	<script language="javascript">document.form1.meixiaoshijifei.value='${qiuzhuoxinxi.meixiaoshijifei}';</script>	<script language="javascript">document.form1.beizhu.value='${qiuzhuoxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var qiuzhuohaoobj = document.getElementById("qiuzhuohao"); if(qiuzhuohaoobj.value==""){document.getElementById("clabelqiuzhuohao").innerHTML="&nbsp;&nbsp;<font color=red>请输入球桌号</font>";return false;}else{document.getElementById("clabelqiuzhuohao").innerHTML="  "; } 	var zhuangtaiobj = document.getElementById("zhuangtai"); if(zhuangtaiobj.value==""){document.getElementById("clabelzhuangtai").innerHTML="&nbsp;&nbsp;<font color=red>请输入状态</font>";return false;}else{document.getElementById("clabelzhuangtai").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  

<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="fufeihsgb" scope="page" class="com.bean.FufeiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=fufei.xls");
%>
<html>
  <head>
    <title>付费</title>
  </head>

  <body >
 <%
			String sql="select * from fufei  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>球桌号</td>    <td align='center'>每小时计费</td>    <td align='center'>总时长</td>    <td align='center'>会员编号</td>    <td align='center'>姓名</td>    <td align='center'>会员等级</td>    <td align='center'>折扣</td>    <td align='center'>总金额</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=fufeihsgb.getAllFufei(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.qiuzhuohao}</td>    <td>${u.meixiaoshijifei}</td>    <td>${u.zongshichang}</td>    <td>${u.huiyuanbianhao}</td>    <td>${u.xingming}</td>    <td>${u.huiyuandengji}</td>    <td>${u.zhekou}</td>    <td>${u.zongjine}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=fufei'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>


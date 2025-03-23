<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>付费详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  付费详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>球桌号：</td><td width='39%'>${fufei.qiuzhuohao}</td>     <td width='11%'>每小时计费：</td><td width='39%'>${fufei.meixiaoshijifei}</td></tr><tr>     <td width='11%'>总时长：</td><td width='39%'>${fufei.zongshichang}</td>     <td width='11%'>会员编号：</td><td width='39%'>${fufei.huiyuanbianhao}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${fufei.xingming}</td>     <td width='11%'>会员等级：</td><td width='39%'>${fufei.huiyuandengji}</td></tr><tr>     <td width='11%'>折扣：</td><td width='39%'>${fufei.zhekou}</td>     <td width='11%'>总金额：</td><td width='39%'>${fufei.zongjine}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${fufei.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


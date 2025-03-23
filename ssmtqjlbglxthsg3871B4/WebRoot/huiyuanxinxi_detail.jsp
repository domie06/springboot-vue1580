<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>会员信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  会员信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>会员编号：</td><td width='39%'>${huiyuanxinxi.huiyuanbianhao}</td>     <td width='11%'>密码：</td><td width='39%'>${huiyuanxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${huiyuanxinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${huiyuanxinxi.xingbie}</td></tr><tr>     <td width='11%'>会员等级：</td><td width='39%'>${huiyuanxinxi.huiyuandengji}</td>     <td width='11%'>折扣：</td><td width='39%'>${huiyuanxinxi.zhekou}</td></tr><tr>     <td width='11%'>手机：</td><td width='39%'>${huiyuanxinxi.shouji}</td>     <td width='11%'>备注：</td><td width='39%'>${huiyuanxinxi.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>


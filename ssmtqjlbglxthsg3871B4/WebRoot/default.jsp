<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<title>台球俱乐部管理系统</title>
<LINK href="qtimages/style.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="950" height="1043" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
	<tr>
		<td><jsp:include page="qttop.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td><table id="__01" width="950" height="735" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td valign="top" background="qtimages/1_02_01_06.gif"><jsp:include page="qtleft.jsp"></jsp:include></td>
            <td valign="top" style="background:url(qtimages/1_02_02_01_02_02_03.gif) repeat-y  right center; "><table id="__01" width="744" height="735" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table id="__01" width="744" height="256" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="744" height="44" background="qtimages/1_02_02_01_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="31%" align="center" valign="middle"><strong><a href="xwtzList.do?lb=站内新闻">站内新闻</a></strong></td>
                        <td width="69%">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><table id="__01" width="744" height="212" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="255" height="212" align="right">
						<%=new db().DynamicImage(250,192) %></td>
                        <td><table id="__01" width="489" height="212" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td><img src="qtimages/1_02_02_01_02_02_01.gif" width="8" height="212" alt=""></td>
                            <td width="468" height="212" valign="top"><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0" class="newsline">
                                                           <c:forEach items="${syxinwentongzhi1 }" var="a">
														    <tr height="25">
                                <td width="4%" height="20" align="center"><img src="qtimages/1.jpg" width="9" height="9"></td>
                                <td width="79%" class="newslist"><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a></td>
                                <td width="17%" align="right" class="newslist">${fn:substring(a.addtime, 0, 10)}</td>
                              </tr>
							  </c:forEach>
                                                          
                                                          </table></td>
                            <td><img src="qtimages/1_02_02_01_02_02_03.gif" width="13" height="212" alt=""></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td><table id="__01" width="744" height="214" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="744" height="37" background="qtimages/1_02_02_02_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="21%" align="center" valign="middle"><strong>商品展示</strong></td>
                        <td width="79%">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><table id="__01" width="744" height="169" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="11" background="qtimages/1_02_02_02_02_01.gif">&nbsp;</td>
                        <td width="712" height="169" bgcolor="#F0F4F7"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
						  
						    <c:forEach items="${syshangpinxinxi1}" var="a">
						  
                                                        <td height="163" align="center"><table width="20%" height="163" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td height="137" align="center"><a href="spxxDetail.do?id=${a.id}"><img src="${a.tupian}" width="131" height="130" border="0"></a></td>
                                </tr>
                                <tr>
                                  <td height="25" align="center"><a href="spxxDetail.do?id=${a.id}">${a.shangpinmingcheng}</a></td>
                                </tr>
                            </table></td>
							
							  </c:forEach>
                                                     
							
							
                                </tr>
                        </table></td>
                        <td width="21" background="qtimages/1_02_02_02_02_03.gif">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><img src="qtimages/1_02_02_02_03.gif" width="744" height="8" alt=""></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td><table id="__01" width="744" height="265" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td><table id="__01" width="365" height="265" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="365" height="39" background="qtimages/1_02_02_03_01_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="37%" align="center" valign="middle"><strong><a href="xwtzList.do?lb=站内新闻">站内新闻</a></strong></td>
                            <td width="63%">&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td><table id="__01" width="365" height="214" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="11" background="qtimages/1_02_02_03_01_02_01.gif">&nbsp;</td>
                            <td width="342" height="214" valign="top" bgcolor="#F0F4F7"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="newsline">
                                                            
															<c:forEach items="${syxinwentongzhi2}" var="a">
															<tr height="25">
                                <td width="8%" align="center" class="newslist"><img height="7" src="qtimages/1.jpg" width="7" /></td>
                                <td width="92%" class="newslist"><a href="gg_detail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a></td>
                              </tr>
							  
							   </c:forEach>
                                                           
                                                          </table></td>
                            <td width="12" background="qtimages/1_02_02_03_01_02_03.gif">&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td><img src="qtimages/1_02_02_03_01_03.gif" width="365" height="12" alt=""></td>
                      </tr>
                    </table></td>
                    <td width="5" background="qtimages/1_02_02_03_02.gif">&nbsp;</td>
                    <td><table id="__01" width="365" height="265" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="365" height="39" background="qtimages/1_02_02_03_01_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="37%" align="center" valign="middle"><strong><a href="xwtzList.do?lb=站内新闻">站内新闻</a></strong></td>
                              <td width="63%">&nbsp;</td>
                            </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td><table id="__01" width="365" height="214" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="11" background="qtimages/1_02_02_03_01_02_01.gif">&nbsp;</td>
                              <td width="342" height="214" valign="top" bgcolor="#F0F4F7"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="newsline">
                                                               <c:forEach items="${syxinwentongzhi3}" var="a">
															<tr height="25">
                                <td width="8%" align="center" class="newslist"><img height="7" src="qtimages/1.jpg" width="7" /></td>
                                <td width="92%" class="newslist"><a href="gg_detail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a></td>
                              </tr>
							  
							   </c:forEach>
                                                              </table></td>
                              <td width="12" background="qtimages/1_02_02_03_01_02_03.gif">&nbsp;</td>
                            </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td><img src="qtimages/1_02_02_03_01_03.gif" width="365" height="12" alt=""></td>
                      </tr>
                    </table></td>
                    <td><img src="qtimages/1_02_02_03_04.gif" width="8" height="265" alt=""></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
	</tr>
	<tr>
		<td>
		<jsp:include page="qtdown.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>
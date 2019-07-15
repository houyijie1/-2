<%@ page import="com.hand.servlet.Servlets" %>
<%@ page language="java"  contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="com.hand.cn.Company" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.hand.dao.ConnMysql" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<html>
<title>Insert title here</title>
<body>
<h2>
<%
    Servlets ttt=new Servlets();
        int i=0;
    ArrayList<Company> list=new ArrayList<Company>();
         //  list=null;
    list = ttt.select();
    try {
         i++;
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
      <%=list.size()%>
        <%=i%>
  <%  Iterator<Company> it = list.iterator();
    Company company=new Company();
    while (it.hasNext()) {
        company = (Company) it.next();%>


        <%=company.getId()%>
        <%=company.getName()%>


    <%}%>
Hello World!</h2>
</body>
</html>

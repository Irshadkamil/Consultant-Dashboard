

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Consultant</title>
    </head>
    <body>
        <form action="SearchConsultant.jsp" method="post">
            Search By Name<input type="text" name="name">&nbsp;&nbsp;<span><input type="submit" value="SearchByName"> </span><br><br>
                <%
                    PrintWriter pw = response.getWriter();
                    String name = request.getParameter("name");
                    //String roll = request.getParameter("roll");
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true", "root", "kamil397@");
                        PreparedStatement p = con.prepareStatement("Select * from Mentor where name='" + name + "'");
                        out.print("<table width =75% border=1>");
                        out.print("<caption>Consultant Details</caption>");
                        ResultSet rs = p.executeQuery();
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int col = rsmd.getColumnCount();
                        out.print("<tr>");
                        for (int i = 1; i <= col; i++) {
                            out.print("<th>" + rsmd.getColumnName(i) + "</th>");
                        }
                        out.print("<tr>");
                        while (rs.next()) {
                            out.print("<tr><td>" + rs.getInt(1)+"</td><td>" + rs.getString(2) + "</td><td>" +
                        rs.getString(3) + "</td>+<td>" + rs.getString(4) + "</td>+<td>" + rs.getString(5) 
                                    + "</td></tr>");

                        }
//                        
                        out.print("</table>");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                %>
            
        </form>
                <br><br><br>
                <form action="SearchConsultant.jsp" method="post">
                Search By Roll<input type="tex" name="roll">&nbsp;&nbsp;<span><input type="submit" value="SearchByRoll"> </span><br><br>
                <%
                    PrintWriter pw1 = response.getWriter();
                    String roll = request.getParameter("roll");
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true", "root", "kamil397@");
                        PreparedStatement p1 = con1.prepareStatement("Select * from Mentor where roll='" + roll + "'");
                        out.print("<table width =75% border=1>");
                        out.print("<caption>Consultant Details</caption>");
                        ResultSet rs1 = p1.executeQuery();
                        ResultSetMetaData rsmd = rs1.getMetaData();
                        int col = rsmd.getColumnCount();
                        out.print("<tr>");
                        for (int i = 1; i <= col; i++) {
                            out.print("<th>" + rsmd.getColumnName(i) + "</th>");
                        }
                        out.print("<tr>");
                        while (rs1.next()) {
                            out.print("<tr><td>" + rs1.getInt(1)+"</td><td>" + rs1.getString(2) +
                            "</td><td>" + rs1.getString(3) + "</td>+<td>" + rs1.getString(4) + 
                            "</td>+<td>" + rs1.getString(5) + "</td></tr>");

                        }
                        out.print("</table>");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                %>
            </form>
    </body>
</html>

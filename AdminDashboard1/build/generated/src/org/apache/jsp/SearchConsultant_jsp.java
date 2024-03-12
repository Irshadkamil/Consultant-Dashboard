package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.io.PrintWriter;

public final class SearchConsultant_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search Consultant</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"SearchConsultant.jsp\" method=\"post\">\n");
      out.write("            Search By Name<input type=\"text\" name=\"name\">&nbsp;&nbsp;<span><input type=\"submit\" value=\"SearchByName\"> </span><br><br>\n");
      out.write("                ");

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

                
      out.write("\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("                <br><br><br>\n");
      out.write("                <form action=\"SearchConsultant.jsp\" method=\"post\">\n");
      out.write("                Search By Roll<input type=\"tex\" name=\"roll\">&nbsp;&nbsp;<span><input type=\"submit\" value=\"SearchByRoll\"> </span><br><br>\n");
      out.write("                ");

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

                
      out.write("\n");
      out.write("            </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

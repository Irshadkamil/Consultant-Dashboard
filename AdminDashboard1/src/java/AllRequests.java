import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllRequests extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true","root","kamil397@");
            PreparedStatement p = con.prepareStatement("Select * from MentorRequest");
            out.print("<table width =75% border=1>");
            out.print("<caption>Consultant Requests</caption>");
            ResultSet rs = p.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int col =rsmd.getColumnCount();
            out.print("<tr>");
            for(int i=1;i<=col;i++){
                out.print("<th>"+rsmd.getColumnName(i)+"</th>");
            }
            out.print("<th colspan='2'>Action</th>");
            out.print("<tr>");
            while(rs.next()){
                out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+
                        "<a href='ConsultantDetails?id="+rs.getInt(1)+"'> Accept</a>"+"</td><td>"+"<a href='ConsultantReject?id="+rs.getInt(1)+"'>Reject</a>"+"</td></tr>");
                
            }
            out.print("</table>");
        }
        catch(Exception e){
            out.print(e);
        }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

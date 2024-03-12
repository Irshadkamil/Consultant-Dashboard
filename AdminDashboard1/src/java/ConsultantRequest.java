
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class ConsultantRequest extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         String id=request.getParameter("user");
          String pass=request.getParameter("pass");
         if(id.equals("123") && pass.equals("irshad") )
         {
             request.getRequestDispatcher("/AllRequests").forward(request, response);
             request.getRequestDispatcher("SearchConsultant.jsp").include(request, response);
         }
         else
         {
             out.print("incorrect password");
             request.getRequestDispatcher("index.jsp").include(request, response);
             request.getRequestDispatcher("SearchConsultant.jsp").include(request, response);
         }
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
         }
    }

    

     

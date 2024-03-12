
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class ConsultantDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            int i = Integer.parseInt(request.getParameter("id"));
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true", "root", "kamil397@");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from MentorRequest where id=" + i + ";");
                rs.next();
                System.out.println(rs);
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String roll = rs.getString(3);
                String mobileno = rs.getString(4);
                System.out.println(name);
                con.close();
                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true", "root", "kamil397@");
                PreparedStatement p = con1.prepareStatement("insert into Mentor values(?,?,?,?,?)");
                p.setInt(1, id);
                p.setString(2, name);
                p.setString(3, roll);
                p.setString(4, mobileno);
                p.setString(5, "Accepted!");
                int rowAffected = p.executeUpdate();
                con1.close();
                Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/consultant?useSSL=false&allowPublicKeyRetrieval=true", "root", "kamil397@");
                PreparedStatement p2 = con2.prepareStatement("delete from mentorrequest where id =" + i + ";");
                int rowAffected2 = p2.executeUpdate();
                con2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            out.println("<h1>Mentor request accepted successfully!  </h1>");
            request.getRequestDispatcher("/AllRequests").include(request, response);


        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

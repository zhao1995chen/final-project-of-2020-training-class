

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class DeleteCoffeeServlet
 */
@WebServlet("/DeleteCoffeeServlet")
public class DeleteCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int DeleteCoffee(String coffee)  throws SQLException {
        Connection con=null;
        PreparedStatement  delete= null;
       

        String insertStatement =
            "delete from COFFEES " +
            "where COF_NAME=? ";

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
	         con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=CST","root","1234");
	      
            con.setAutoCommit(false);    
            delete = con.prepareStatement(insertStatement);

            //for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) { }
                delete.setString(1, coffee);          
               int rs= delete.executeUpdate();
                con.commit();
                return rs;
            
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } finally {
            if (delete != null) {
                delete.close();
            }
            if (delete != null) {
                delete.close();
            }
            con.setAutoCommit(true);
        }
        return 0;
    }   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        int rs=0;
	        try {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet InsertCoffee</title>");            
	            out.println("</head>");
	            out.println("<body>");
	             String coffee=request.getParameter("coffee");
	           
	            try {
	                rs= DeleteCoffee(coffee);
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	            if(rs>0)
	                out.println("新增成功");
	            else
	            	out.println("新增失敗");
	            out.println("</body>");
	            out.println("</html>");
	        } finally {            
	            out.close();
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

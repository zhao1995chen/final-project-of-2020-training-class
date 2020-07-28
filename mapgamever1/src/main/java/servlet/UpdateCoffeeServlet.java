

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class UpdateCoffeeServlet
 */
@WebServlet("/UpdateCoffeeServlet")
public class UpdateCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int  updateCoffeeSales(String coffee,String sale,String total)
    	    throws SQLException {
    	    Connection con=null;
    	    PreparedStatement updateSales = null;
    	    PreparedStatement updateTotal = null;

    	    String updateString =
    	        "update COFFEES " +
    	        "set SALES = ?  where COF_NAME = ?";

    	    String updateStatement =
    	        "update COFFEES " +
    	        "set TOTAL = TOTAL + ? " +
    	        "where COF_NAME = ?";
            int rs=0;
    	    try {
    	         Class.forName("com.mysql.cj.jdbc.Driver");
    	         con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=CST","root","1234");
    	      
    	        con.setAutoCommit(false);
    	        updateSales = con.prepareStatement(updateString);
    	        updateTotal = con.prepareStatement(updateStatement);

    	        //for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) { }
    	            updateSales.setInt(1, Integer.parseInt(sale));
    	            updateSales.setString(2, coffee);
    	            updateSales.executeUpdate();
    	            updateTotal.setInt(1, Integer.parseInt(total));
    	            updateTotal.setString(2, coffee);
    	            rs=updateTotal.executeUpdate();
    	            con.commit();
    	            return rs;
    	    } catch (Exception e ) {
    	        System.out.println(e.getMessage());
    	        if (con != null) {
    	            try {
    	                System.err.print("Transaction is being rolled back");
    	                con.rollback();
    	            } catch(SQLException excep) {
    	                System.out.println(e.getMessage());
    	            }
    	        }
    	    } finally {
    	        if (updateSales != null) {
    	            updateSales.close();
    	        }
    	        if (updateTotal != null) {
    	            updateTotal.close();
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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCoffee</title>");            
            out.println("</head>");
            out.println("<body>");
            String coffee=request.getParameter("coffee");
            String sale=request.getParameter("sale");
            String total=request.getParameter("total");
            int rs=0;
            try {
                rs=updateCoffeeSales(coffee,sale,total);
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

package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.SingletonConnection;

/**
 * Servlet implementation class VerifierAdmijn
 */
@WebServlet("/VerifierAdmijn")
public class VerifierAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifierAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		int nb=0;
		Connection conn=new SingletonConnection().getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from admins where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2,password);
			
			ResultSet res=ps.executeQuery();
			res.next();
			nb=res.getRow();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(nb==1) {
			this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/identification.jsp?action=admin").forward(request, response);
		}
	}

}

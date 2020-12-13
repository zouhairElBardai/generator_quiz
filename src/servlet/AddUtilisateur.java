package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Fichier;
import metier.SingletonConnection;

/**
 * Servlet implementation class AddUtilisateur
 */
@WebServlet("/AddUtilisateur")
public class AddUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=new SingletonConnection().getConnection();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setAttribute("listTT", listTT());
			request.setAttribute("listCM", listCM());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/utilisateur.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
				
		addUser(nom, prenom);
		doGet(request, response);
	}
	
	//ajouter un utilisateur
	private void addUser(String nom,String prenom) {
		try {
			PreparedStatement ps=conn.prepareStatement("insert into users(id_user,nom_user,prenom_user) values(null,?,?)");
			ps.setString(1,nom);
			ps.setString(2,prenom);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//la liste des fichier de type texte à trous
	private List<Fichier> listTT() throws SQLException{
		List<Fichier> listF=new ArrayList<Fichier>();
		PreparedStatement ps=conn.prepareStatement("select * from fichier where type_file='texteTrous'");
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Fichier qFile=new Fichier();
			qFile.setType_file(res.getString(2));
			qFile.setTheme(res.getString(3));
			qFile.setName_file(res.getString(4));
			qFile.setChemin_file(res.getString(5));
			
			listF.add(qFile);
		}
		
		ps.close();
		res.close();
		
		return listF;
	}
	
	//la liste des fichier de type choix multiples
	private List<Fichier> listCM() throws SQLException{
		List<Fichier> listF=new ArrayList<Fichier>();
		PreparedStatement ps=conn.prepareStatement("select * from fichier where type_file='choix multiples'");
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Fichier qFile=new Fichier();
			qFile.setType_file(res.getString(2));
			qFile.setTheme(res.getString(3));
			qFile.setName_file(res.getString(4));
			qFile.setChemin_file(res.getString(5));
			
			listF.add(qFile);
		}
		
		ps.close();
		res.close();
		
		return listF;
	}
	
	
}


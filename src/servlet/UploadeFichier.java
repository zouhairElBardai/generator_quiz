package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadeFichier")
public class UploadeFichier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String FILE_CHEMIN = "F://zouMaster/zouhairS1/JEE/travail/QuizzProject/WebContent/file/";///modifier ce chemin par votre chemin de fichier file
	public UploadeFichier() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On récupère le champ quizzType comme d'habitude
		String quizzType = request.getParameter("quizzType");
		System.out.println("quizzType est : " + quizzType);
		request.setAttribute("quizzType", quizzType);

		// On récupère le champ du fichier
		Part part = request.getPart("fichier");
		System.out.println("la part est " + part);
	
		// On vérifie qu'on a bien reçu un fichier
		String cheminFile = getNomFichier(part);

		System.out.println("chemin est :" + cheminFile);

		String nomFichier =null;
		// Si on a bien un fichier
		if (cheminFile != null && !cheminFile.isEmpty()) {
			String nomChamp = part.getName();
			
			nomFichier = cheminFile.substring(cheminFile.lastIndexOf('/') + 1)
					.substring(cheminFile.lastIndexOf('\\') + 1);
			System.out.println("nomfichier est :" + nomFichier);

			// On écrit définitivement le fichier sur le disque
			uploadeFichier(cheminFile,nomFichier);
			

			request.setAttribute(nomChamp, nomFichier);
		}

		this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	private void uploadeFichier(String chemin,String nomFichier) throws IOException {
		BufferedReader flot = null;
		File file = new File(FILE_CHEMIN+nomFichier);
		System.out.println("ooooooo "+nomFichier);
		PrintWriter ecrire = new PrintWriter(new FileWriter(file));
		String str;
		try {
			flot = new BufferedReader(new FileReader(nomFichier));
			
			while ((str = flot.readLine()) != null)
				System.out.println(str);
				ecrire.println(str);
				
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture du fichier!!");
		} finally {
			if (flot != null)
				flot.close();
				ecrire.close();
		}
	
		
		   
	}

	

	private static String getNomFichier(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}

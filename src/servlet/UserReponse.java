package servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Choix;
import metier.Fichier;
import metier.Question;
import metier.QuestionChoix;
import metier.SingletonConnection;

@WebServlet("/UserReponse")
public class UserReponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = new SingletonConnection().getConnection();

	///modifier ce chemin par votre chemin de fichier file
	public static final String FILE_CHEMIN = "F://zouMaster/zouhairS1/JEE/travail/QuizzProject/WebContent/file/";

	public UserReponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typeFile = request.getParameter("type_file");
		String theme = request.getParameter("theme");
		request.setAttribute("title", theme);
		request.setAttribute("typeFile", typeFile);

		if (typeFile.equals("choix multiples")) {
			try {
				List<QuestionChoix> listQC = lectureFileCM(theme);
				request.setAttribute("listQC", listQC);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (typeFile.equals("texteTrous")) {
			try {
				ArrayList<String> questionTrous = lectureFileTT(theme);
				request.setAttribute("questionTT", questionTrous);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		this.getServletContext().getRequestDispatcher("/userReponse.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// lecture les fichiers de type choix multiple
	private List<QuestionChoix> lectureFileCM(String theme) throws SQLException, FileNotFoundException {
		List<QuestionChoix> listQ = new ArrayList<QuestionChoix>();
		PreparedStatement ps = conn.prepareStatement("select * from fichier where theme=?");
		ps.setString(1, theme);
		ResultSet res = ps.executeQuery();
		String nameFichier = null;
		while (res.next()) {
			nameFichier = res.getString(4);
		}
		ps.close();
		res.close();

		File file = new File(FILE_CHEMIN + nameFichier + ".txt");
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			QuestionChoix qChoix = new QuestionChoix();
			String line = scanner.nextLine();
			if (line.contains("!")) {
				Question question = new Question();
				String[] parti = line.split("!");
				qChoix.setEnonce(parti[0]);// les question

				String[] choixT = parti[1].split(",");
				int nbChoixCorrect = (Integer.parseInt(parti[2])); /// numéro de choix correct

				List<Choix> listChoix = new ArrayList<Choix>();
				System.out.println("nb de choix" + choixT.length);
				for (int i = 0; i < choixT.length; i++) {
					Choix choix = new Choix();
					String vChoix = choixT[i]; // la valeur de choix
					choix.setValeurChoix(vChoix);

					int nb = i + 1;
					if (nb == nbChoixCorrect) {
						choix.setValid(true);
					} else {
						choix.setValid(false);
					}
					choix.setQestion(qChoix);

					listChoix.add(choix);

				}
				qChoix.setChoix(listChoix);
			}

			listQ.add(qChoix);
		}

		return listQ;
	}

	// lecture les fichiers de type text a trous
	@SuppressWarnings("null")
	private ArrayList<String> lectureFileTT(String theme) throws SQLException, FileNotFoundException {
		PreparedStatement ps = conn.prepareStatement("select * from fichier where theme=?");
		ps.setString(1, theme);
		ResultSet res = ps.executeQuery();
		String nameFichier = null;
		while (res.next()) {
			nameFichier = res.getString(4);
			System.out.println("le nom fichier est : " + nameFichier);
		}
		ps.close();
		res.close();

		File file = new File(FILE_CHEMIN + nameFichier + ".txt");
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		ArrayList<String> list=new ArrayList<String>();
		int i = 1;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println("la line est : " + line);
			list.add(line);
		}

		return list;
	}

	/*
	 * public List<QuestionChoix> lectureFileCM(String theme) throws SQLException,
	 * FileNotFoundException{ List<QuestionChoix> listQ=new
	 * ArrayList<QuestionChoix>(); PreparedStatement
	 * ps=conn.prepareStatement("select * from fichier where theme=?");
	 * ps.setString(1, theme); ResultSet res=ps.executeQuery(); String
	 * nameFichier=null; while(res.next()) { nameFichier=res.getString(4);
	 * System.out.println("le nom fichier est : "+nameFichier); } ps.close();
	 * res.close();
	 * 
	 * File file=new File(FILE_CHEMIN+nameFichier+".txt"); Scanner scanner=new
	 * Scanner(file); scanner.nextLine(); while(scanner.hasNextLine()) {
	 * QuestionChoix qChoix=new QuestionChoix(); String line=scanner.nextLine();
	 * System.out.println("  hh  "+line); if(line.contains("!")) { Question
	 * question=new Question(); String[] parti=line.split("!");
	 * question.setEnonce(parti[0]);
	 * System.out.println("la question est : "+question.getEnonce());
	 * qChoix.setQuest(question); String[] choixT =parti[1].split(","); int
	 * nbChoixCorrect=(Integer.parseInt(parti[2]));
	 * 
	 * System.out.println("nemuro de choix corect "+nbChoixCorrect);
	 * 
	 * List<Choix> listChoix =new ArrayList<Choix>();
	 * System.out.println("nb de choix"+choixT.length); for(int
	 * i=0;i<choixT.length;i++) { Choix choix=new Choix();
	 * System.out.println("le choix est "+choixT[i]); String vChoix=choixT[i];
	 * choix.setValeurChoix(vChoix); System.out.println("222 "+vChoix); int nb=i+1;
	 * if(nb==nbChoixCorrect) { choix.setValid(true); System.out.println("true "+i);
	 * }else { choix.setValid(false); System.out.println("false "+i); }
	 * choix.setQestion(qChoix);
	 * 
	 * listChoix.add(choix);
	 * 
	 * } qChoix.setChoix(listChoix); }
	 * 
	 * listQ.add(qChoix); }
	 * 
	 * 
	 * 
	 * 
	 * return listQ; }
	 */

}

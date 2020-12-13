package metier;

import java.util.List;

public class QuestionChoix {
	private static int idQuestion=0;
	private String enonce;
	private List<Choix> choix;
	public QuestionChoix() {
		super();
	}
	public QuestionChoix(String enonce, List<Choix> choix) {
		super();
		this.idQuestion ++;
		this.enonce = enonce;
		this.choix = choix;
	}
	public static int getIdQuestion() {
		return idQuestion;
	}
	public static void setIdQuestion(int idQuestion) {
		QuestionChoix.idQuestion = idQuestion;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public List<Choix> getChoix() {
		return choix;
	}
	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}
	
	
}

package metier;

public class Question {
	private int idQuestion;
	private String enonce;
	public Question() {
		super();
	}
	public Question(String enonce) {
		this.idQuestion ++;
		this.enonce = enonce;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	
	
}

package metier;

public class Choix {
	private int idChoix;
	private String valeurChoix;
	private boolean isValid;
	private QuestionChoix qestion;
	
	
	public Choix() {
		super();
	}


	public Choix(int idChoix, String valeurChoix, boolean isValid, QuestionChoix qestion) {
		super();
		this.idChoix = idChoix;
		this.valeurChoix = valeurChoix;
		this.isValid = isValid;
		this.qestion = qestion;
	}


	public int getIdChoix() {
		return idChoix;
	}


	public void setIdChoix(int idChoix) {
		this.idChoix = idChoix;
	}


	public String getValeurChoix() {
		return valeurChoix;
	}


	public void setValeurChoix(String valeurChoix) {
		this.valeurChoix = valeurChoix;
	}


	public boolean isValid() {
		return isValid;
	}


	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}


	public QuestionChoix getQestion() {
		return qestion;
	}


	public void setQestion(QuestionChoix qestion) {
		this.qestion = qestion;
	}


}

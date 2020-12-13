package metier;

public class Fichier {
	private int id_file;
	private String type_file;
	private String theme;
	private String name_file;
	private String chemin_file;
	public Fichier() {
		super();
	}

	public Fichier(int id_file, String type_file, String theme, String name_file, String chemin_file) {
		super();
		this.id_file = id_file;
		this.type_file = type_file;
		this.theme=theme;
		this.name_file = name_file;
		this.chemin_file = chemin_file;
	}



	public int getId_file() {
		return id_file;
	}
	public void setId_file(int id_file) {
		this.id_file = id_file;
	}
	public String getType_file() {
		return type_file;
	}
	public void setType_file(String type_file) {
		this.type_file = type_file;
	}
	public String getName_file() {
		return name_file;
	}
	public void setName_file(String name_file) {
		this.name_file = name_file;
	}
	public String getChemin_file() {
		return chemin_file;
	}
	public void setChemin_file(String chemin_file) {
		this.chemin_file = chemin_file;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	

}

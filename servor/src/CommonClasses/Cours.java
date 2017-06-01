package CommonClasses;

public class Cours {
	private int id;
	private String intitule;
	private String nom;
	private Format format;
	private String path;

	public Cours() {
		this.id = -1;
		this.intitule = null;
		this.nom = null;
		this.format = null;
		this.path = null;
	}

	public Cours(int id, String intitule, String nom, Format format, String path) {
		this.id = id;
		this.intitule = intitule;
		this.nom = nom;
		this.format = format;
		this.path = path;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Format getFormat() {
		return this.format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
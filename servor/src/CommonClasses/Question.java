package CommonClasses;

import java.util.HashMap;

public class Question {
	private int id;
	private String laQuestion;
	private HashMap<String, Boolean> reponses = new HashMap<>();

	public Question() {
		this.id = -1;
		this.laQuestion = null;
		this.reponses = null;
	}

	public Question(int id, String l, HashMap<String, Boolean> r) {
		this.id = id;
		this.laQuestion = l;
		this.reponses = r;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return laQuestion;
	}

	public void setLaQuestion(String laQuestion) {
		this.laQuestion = laQuestion;
	}

	public HashMap<String, Boolean> getReponses() {
		return reponses;
	}
}

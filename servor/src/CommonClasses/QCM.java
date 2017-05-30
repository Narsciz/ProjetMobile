package CommonClasses;

import java.util.Vector;


public class QCM {
    private int id;
    private String intitule;
    private String nom;
    private String code;
    private Vector<Question> questions;
    private Vector<String> destinataires;

    public QCM()
    {
        this.id = -1;
        this.nom = null;
        this.questions = null;
        this.destinataires = null;
    }

    public QCM(int id, String nom, Vector<Question> q, Vector<String> destinataires)
    {
        this.id = id;
        this.nom = nom;
        this.questions=q;
        this.destinataires = destinataires;
    }
    
    public QCM(int id, String nom, String intitule, String code)
    {
    	this.id = id;
    	this.intitule=intitule;
    	this.nom = nom;
    	this.code = code;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getIntitule(){return this.intitule;}
    public void setIntitule(String intitule){this.intitule = intitule;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public Vector<Question> getQuestions() {return questions;}
    public void setQuestions(Vector<Question> questions) {this.questions = questions;}
    public Vector<String> getDestinataires() {return destinataires;}
    public void setDestinataires(Vector<String> destinataires) {this.destinataires = destinataires;}
    public String getCode()
    {
    	return this.code;
    }
}

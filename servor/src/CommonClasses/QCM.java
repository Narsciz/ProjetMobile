package CommonClasses;

import java.util.Vector;


public class QCM {
    private int id;
    private Matiere matiere;
    private String intitule;
    private String nom;
    private Vector<Question> questions;
    private Utilisateur createur;
    private Vector<Utilisateur> destinataires;

    public QCM()
    {
        this.id = -1;
        this.nom = null;
        this.questions = null;
        this.createur = null;
        this.destinataires = null;
    }

    public QCM(int id, String nom, Vector<Question> q, Utilisateur createur, Vector<Utilisateur> destinataires)
    {
        this.id = id;
        this.nom = nom;
        this.questions=q;
        this.createur = createur;
        this.destinataires = destinataires;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Matiere getMatiere(){return this.matiere;}
    public void setMatiere(Matiere matiere){this.matiere = matiere;}
    public String getIntitule(){return this.intitule;}
    public void setIntitule(String intitule){this.intitule = intitule;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public Vector<Question> getQuestions() {return questions;}
    public void setQuestions(Vector<Question> questions) {this.questions = questions;}
    public Utilisateur getCreateur() {return createur;}
    public void setCreateur(Utilisateur createur) {this.createur = createur;}
    public Vector<Utilisateur> getDestinataires() {return destinataires;}
    public void setDestinataires(Vector<Utilisateur> destinataires) {this.destinataires = destinataires;}
}

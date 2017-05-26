package CommonClasses;

import java.util.Vector;


public class QCM {
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Vector<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Vector<Question> questions) {
        this.questions = questions;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public Vector<Utilisateur> getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(Vector<Utilisateur> destinataires) {
        this.destinataires = destinataires;
    }
}

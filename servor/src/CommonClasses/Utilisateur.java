package CommonClasses;


public class Utilisateur {
    private String idMail;
    private String nom;
    private String prenom;
    private boolean etudiant;
    private String mdp;
    private Annee annee;

    public Utilisateur()
    {
        this.idMail = null;
        this.nom = null;
        this.prenom = null;
        this.etudiant = true;
        this.mdp = null;
        this.annee = null;
    }

    public Utilisateur(String idMail, String nom, String prenom, boolean etudiant, String mdp, Annee annee)
    {
        this.idMail = idMail;
        this.nom = nom;
        this.prenom = prenom;
        this.etudiant = etudiant;
        this.mdp = mdp;
        this.annee = annee;
    }

    public String getIdMail(){return this.idMail;}
    public void setIdMail(String idMail){this.idMail = idMail;}
    public String getNom(){return this.nom;}
    public void setNom(String nom){this.nom = nom;}
    public String getPrenom(){return this.prenom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public boolean getEtudiant(){return this.etudiant;}
    public void setEtudiant(boolean etudiant){this.etudiant = etudiant;}
    public String getMdp(){return this.mdp;}
    public void setMdp(String mdp){this.mdp = mdp;}
    public Annee getAnnee(){return this.annee;}
    public void setAnnee(Annee annee){this.annee = annee;}
}

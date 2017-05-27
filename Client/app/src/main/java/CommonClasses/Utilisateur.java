package CommonClasses;


public class Utilisateur {

    private String identifiant;
    private Annee annee;
    String nom;
    String prenom;
    boolean type;

    public Utilisateur(String i,String p,String n,boolean t,Annee a){

        identifiant=i;
        nom=n;
        prenom=p;
        type=t;
        annee=a;
    }

    public Annee getAnnee(){
        return annee;
    }

    public String getIdentifiant(){
        return identifiant;
    }


}

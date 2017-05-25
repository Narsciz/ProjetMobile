package progmobile.coursenligne.CommonClasses;



public class Cours {

    private String intitule;
    private Annee annee;
    private Matiere matiere;
    private boolean video;

    public Cours(String i,Annee a,Matiere m,boolean v){
        intitule=i;
        annee=a;
        matiere=m;
        video=v;
    }


}

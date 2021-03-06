package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;

import CommonClasses.Annee;
import CommonClasses.StaticMethods;
import CommonClasses.Utilisateur;

/**
 * AskServerTask appelle le client dans un thread et met ensuite à jour dans postExecute()
 * l'interface du main thread
 */

public class AskServerTask extends AsyncTask<Void,Void,String> {

    private AbstractActivity context;//activité courante
    private String question;//question posé par le client

    AskServerTask(AbstractActivity c,String r){
        context=c;
        question=r;
    }

    @Override
    protected void onPreExecute(){
        //Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Void... params) {
        return new AskServer().ask(question);
    }

    @Override
    protected void onPostExecute(String result) {

        //Toast.makeText(context, result, Toast.LENGTH_SHORT).show();

        String[] r= result.split(";");

        String switchValue=r[0].toLowerCase();

        switch(switchValue){
            case "inscription":
                inscription(r);
                break;
            case "authentification":
                authentification(r);
                break;
            case "matiere":
                matiere(r);
                break;
            case "intitulecours":

                intituleCours(r);
                break;
            case "intituleqcm":
                intituleQcm(r);
                break;
            case "qcm":
                qcm(r);
                break;
            case "valider":
                valider(r);
                break;
            case "qcmafaire":
                qcmAfaire(r);
                break;
            case "creationqcm":
                creationQcm(r);
                break;
            case "creationcours":
                creationCours(r);
                break;
            case "getusers":
                getUsers(r);
                break;
            case "validerqcm":
                validerQcm(r);
                break;
            case "echo":
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, "Erreur :"+result, Toast.LENGTH_SHORT).show();
        }
    }

    private void validerQcm(String[] r) {
        try{
            if (r[1].equals("true"))
                Toast.makeText(context, "Qcm a été correctement validé", Toast.LENGTH_SHORT).show();
            else Toast.makeText(context, "Validation qcm refusée", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context, "Exception : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void getUsers(String[] r) {
        Intent intent=new Intent(context,ChooseQcmUserActivity.class);
        Bundle b=new Bundle();
        b.putStringArray("users",r);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    private void creationQcm(String[] r) {
        try{
            if (r[1].equals("true"))
                Toast.makeText(context, "Le qcm a été correctement ajouté", Toast.LENGTH_SHORT).show();
            else Toast.makeText(context, "Le qcm a été refusé par le serveur", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(context, "Exception creationQcm :"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void creationCours(String[] r) {
        try{
            if (r[1].equals("true"))
                Toast.makeText(context, "Le cours a été correctement ajouté", Toast.LENGTH_SHORT).show();
            else Toast.makeText(context, "Le cours a été refusé par le serveur", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(context, "Exception creationCours :"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void inscription(String[] r) {
        try {
            if (r[1].equals("true"))
                context.startActivity(new Intent(context, AuthentificationActivity.class));
            else
                Toast.makeText(context,"La serveur a refusé l'inscription", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"inscription exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }


    private void authentification(String[] r){

        try {
            if (r[1].equals("false")){
                Toast.makeText(context, "L'authentification a été refusé par le serveur", Toast.LENGTH_SHORT).show();
                return;
            }

            String[] q = question.split(";");
            String email = q[1];
            String prenom = r[1];
            String mdp=q[2];
            String nom = r[2];
            boolean type = Boolean.valueOf(r[3]);
            Annee annee = StaticMethods.StringToAnnee(r[4]);
            context.setSession(new Utilisateur(email,nom,prenom,type,mdp,annee));

            new AskServerTask(context,"qcmAfaire;"+context.session.getIdMail()).execute();
        }
        catch (Exception e){
            Toast.makeText(context,"authentification exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void matiere(String[] r) {
        Bundle b=new Bundle();
        String[] listeIntitules = Arrays.copyOfRange(r,1,r.length);
        b.putStringArray("intitules",listeIntitules);
        Intent i=new Intent(context,IntitulesActivity.class);
        i.putExtras(b);
        context.startActivity(i);
    }

    private void intituleCours(String[] r){
        try {
            Bundle b = new Bundle();
            Intent intent;
            intent = new Intent(context, CoursActivity.class);
            String[] listeNomCours = new String[r.length - 1];
            String[] listeTypeCours = new String[r.length - 1];
            String[] listePathCours = new String[r.length - 1];

            for (int i = 1; i < r.length; i++) {
                String[] currentCours = r[i].split("\\|");
                listeNomCours[i - 1] = currentCours[0];
                listeTypeCours[i - 1] = currentCours[1];
                listePathCours[i - 1] = currentCours[2];
            }
            b.putStringArray("listeNomCours", listeNomCours);
            b.putStringArray("listeTypeCours", listeTypeCours);
            b.putStringArray("listePathCours", listePathCours);
            b.putString("intitule",question.split(";")[1]);
            intent.putExtras(b);

            context.startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(context,"intituleCours exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void intituleQcm(String[] r){

        try {
            Bundle b = new Bundle();
            Intent intent;
            intent = new Intent(context, QcmActivity.class);
            String[] listeNomQcm = new String[r.length - 1];
            String[] listeIdQcm = new String[r.length - 1];

            for (int i = 1; i < r.length; i++) {
                String[] currentQcm = r[i].split("\\|");

                listeNomQcm[i - 1] = currentQcm[0];
                listeIdQcm[i - 1] = currentQcm[1];
            }

            b.putStringArray("listeNomQcm", listeNomQcm);
            b.putStringArray("listeIdQcm", listeIdQcm);
            b.putString("intitule",question.split(";")[1]);
            intent.putExtras(b);

            context.startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(context,"intituleQcm exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void qcm(String[] r) {
        try {
            Intent intent = new Intent(context, DoQcmActivity.class);
            String serialQcm="";
            for (int i=1;i<r.length;i++){
                serialQcm+=r[i]+";";
            }
            intent.putExtra("serialQcm", serialQcm);
            intent.putExtra("nomQcm",question.split(";")[2]);
            intent.putExtra("idQcm",question.split(";")[1]);
            context.startActivity(intent);
        }
        catch(Exception e){
            Toast.makeText(context,"qcm exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void valider(String[] r){
        try{
            if (r[1].equals("true"))
                Toast.makeText(context,"Le qcm a été validé",Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(context,"La validation a été refusé par le serveur",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"Validation Exception : "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }


    private void qcmAfaire(String[] r) {
        try{
            context.clearQcmAfaire();
            for (int i = 1; i < r.length; i++) {
                String[] currentQcm = r[i].split("\\|");
                String nomQcm=currentQcm[0];
                String idQcm=currentQcm[1];
                context.put(nomQcm,idQcm);
            }

            context.startActivity(new Intent(context, HomeActivity.class));
        }
        catch(Exception e){
            Toast.makeText(context,"qcmAfaire exception : "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}

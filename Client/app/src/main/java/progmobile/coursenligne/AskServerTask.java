package progmobile.coursenligne;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;

import CommonClasses.Annee;
import CommonClasses.StaticMethods;
import CommonClasses.Utilisateur;

/**
 * Created by Millenium on 27/05/2017.
 */

public class AskServerTask extends AsyncTask<Void,Void,String> {

    private AbstractActivity context;
    private String question;

    AskServerTask(AbstractActivity c,String r){
        context=c;
        question=r;
    }

    @Override
    protected String doInBackground(Void... params) {
        /*AskServer c=new AskServer(params[0]);
        c.run();
        return c.getResponse();*/
        return new AskServer().ask(question);
    }

    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        String[] r= result.split(";");

        switch(r[0]){
            case "inscription":
                inscription(r);
                break;
            case "authentification":
                authentification(r);
                break;
            case "matiere":
                matiere(r);
                break;
            case "intituleCours":

                intituleCours(r);
                break;
            case "intituleQcm":

                intituleQcm(r);
                break;
            case "qcm":
                qcm(r);
                break;
            case "valider":
                valider(r);
                break;
            case "qcmAfaire":
                qcmAfaire(r);
                break;
            default:
        }
    }

    private void inscription(String[] r) {
        if (r.length<2)
            return;
        if (r[1].equals("true"))
            context.startActivity(new Intent(context,AuthentificationActivity.class));
        else
            Toast.makeText(context,"Le serveur a refusé l'inscription",Toast.LENGTH_SHORT).show();
    }

    private void authentification(String[] r) {
        String[] q=question.split(";");
        if (q.length<2 || r.length<5)
            return;
        String email=q[1];
        String prenom=r[1];
        String nom=r[2];
        boolean type=StaticMethods.StringToBool(r[3]);
        Annee annee=StaticMethods.StringToAnnee(r[4]);

        AbstractActivity.setSession(new Utilisateur(email,prenom,nom,type,annee));
        context.startActivity(new Intent(context,HomeActivity.class));
    }

    private void matiere(String[] r) {
        Bundle b=new Bundle();
        String[] listeIntitules = Arrays.copyOfRange(r,1,r.length);
        b.putStringArray("intitules",listeIntitules);
        Intent i=new Intent(context,IntitulesActivity.class);
        i.putExtras(b);
        context.startActivity(i);
    }

    private void intituleCours(String[] r) {

        Bundle b=new Bundle();
        Intent intent;
        intent=new Intent(context,CoursActivity.class);
        String[] listeNomCours=new String[r.length-1];
        String[] listeTypeCours=new String[r.length-1];
        String[] listePathCours=new String[r.length-1];

        for (int i=1;i<r.length;i++){
            String[] currentCours=r[i].split("\\|");
            if (currentCours.length<3)
                return;

            listeNomCours[i-1]=currentCours[0];
            listeTypeCours[i-1]=currentCours[1];
            listePathCours[i-1]=currentCours[2];

        }
        b.putStringArray("listeNomCours",listeNomCours);
        b.putStringArray("listeTypeCours",listeTypeCours);
        b.putStringArray("listePathCours",listePathCours);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    private void intituleQcm(String[] r){

        Bundle b=new Bundle();
        Intent intent;
        intent=new Intent(context,QcmActivity.class);
        String[] listeNomQcm=new String[r.length-1];
        String[] listeIdQcm=new String[r.length-1];

        for (int i=1;i<r.length;i++){

            String[] currentQcm=r[i].split("\\|");
            if (currentQcm.length<2)
                return;


            listeNomQcm[i-1]=currentQcm[0];
            listeIdQcm[i-1]=currentQcm[1];
        }
        b.putStringArray("listeNomQcm",listeNomQcm);
        b.putStringArray("listeIdQcm",listeIdQcm);
        intent.putExtras(b);

        context.startActivity(intent);
    }

    private void qcm(String[] r) {
        Intent intent=new Intent(context,DoQcmActivity.class);
        intent.putExtra("serialQcm",r[1]);
        context.startActivity(intent);
    }

    private void valider(String[] result) {
    }

    private void qcmAfaire(String[] r) {
        Bundle b=new Bundle();
        Intent intent;
        intent=new Intent(context,QcmAfaireActivity.class);
        String[] listeNomQcm=new String[r.length-1];
        String[] listeIdQcm=new String[r.length-1];

        for (int i=1;i<r.length;i++){

            String[] currentQcm=r[i].split("\\|");
            if (currentQcm.length<2)
                return;


            listeNomQcm[i-1]=currentQcm[0];
            listeIdQcm[i-1]=currentQcm[1];
        }
        b.putStringArray("listeNomQcm",listeNomQcm);
        b.putStringArray("listeIdQcm",listeIdQcm);
        intent.putExtras(b);

        context.startActivity(intent);
    }


}

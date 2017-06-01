package progmobile.coursenligne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Vector;

import CommonClasses.QCM;
import CommonClasses.Utilisateur;

/**
 * AbstractActivity est mère de toutes les activités du projet et sert à stocker certaines
 * informations sans avoir à utiliser des Bundle à chaque changement d'activité
 */
public class AbstractActivity extends AppCompatActivity {


    static Utilisateur session=null;//session utilisateur
    static HashMap<String,String> qcmsAfaire=new HashMap<>();//liste des qcmAfaire qu'un étudiant pourrait avoir à faire
    static String currentIntitule="";//intitulé courant (créé parce que j'avais des soucis avec la persistence des activités avec les bundle et putExtra)
    static String currentCreateQcmRequest="";//pareil qu'au dessus

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    static public void setSession(Utilisateur utilisateur){
        session=utilisateur;
    }

    static public Utilisateur getSession(){
        return session;
    }

    public void put(String nom,String id){
        qcmsAfaire.put(nom,id);
    }

    public void clearQcmAfaire() {
        qcmsAfaire.clear();

    }

}

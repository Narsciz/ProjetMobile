package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Vector;

public class HomeActivity extends AbstractActivity {

    boolean qcmAfaire=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new AskServerTask(this,"qcmAfaire;"+session.getIdMail()).execute();


        if (qcmsAfaire.isEmpty())
            qcmAfaire=false;
        else qcmAfaire=true;

        invalidateOptionsMenu();

        setContentView(R.layout.activity_home);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        if (session.getEtudiant() && qcmAfaire)
            inflater.inflate(R.menu.qcm_eleve_menu,menu);
        inflater.inflate(R.menu.base_menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_home:
                if (session.getEtudiant())
                    new AskServerTask(this,"qcmAfaire;"+session.getIdMail()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                else startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.item_deconnexion:
                startActivity(new Intent(this,AuthentificationActivity.class));
                break;
            case R.id.item_qcm_a_faire:
                /*String request="qcmAfaire;"+AbstractActivity.getSession().getIdMail();
                new AskServerTask(this,request).execute();*/
                startActivity(new Intent(this,QcmAfaireActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void consulterMatiere(View view){
    }

    public void consulterMath(View view) {
        String request="matiere;mathematiques;"+getSession().getAnnee();
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void consulterInformatique(View view) {
        String request="matiere;informatique;"+getSession().getAnnee();
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void consulterBio(View view) {
        String request="matiere;biologie;"+getSession().getAnnee();
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void consulterChimie(View view) {
        String request="matiere;chimie;"+getSession().getAnnee();
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void consulterPhysique(View view) {
        String request="matiere;physique;"+getSession().getAnnee();
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}

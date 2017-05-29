package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ChoixActivity extends AbstractActivity {


    String intitule="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        Bundle b=getIntent().getExtras();
        currentIntitule=b.getString("intitule");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();

        if (/*prof*/true) {
            inflater.inflate(R.menu.cours_prof_menu, menu);
            inflater.inflate(R.menu.qcm_prof_menu,menu);
        }

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
            case R.id.item_cours:
                startActivity(new Intent(this,CreateCoursActivity.class));
                break;
            case R.id.item_deconnexion:
                startActivity(new Intent(this,AuthentificationActivity.class));
                break;
            case R.id.item_qcm:
                startActivity(new Intent(this,CreateQcmActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void consulterCours(View view){
        String request="intituleCours;"+intitule+";cours";
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void consulterQcm(View view){
        String request="intituleQcm;"+intitule+";qcm";
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}

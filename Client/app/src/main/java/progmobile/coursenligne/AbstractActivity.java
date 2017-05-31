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

public class AbstractActivity extends AppCompatActivity {


    static Utilisateur session=null;
    static HashMap<String,String> qcmsAfaire=new HashMap<>();
    static String currentIntitule="";

    static String currentCreateQcmRequest="";

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

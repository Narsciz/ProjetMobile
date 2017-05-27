package progmobile.coursenligne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import CommonClasses.Utilisateur;

public class AbstractActivity extends AppCompatActivity {


    static Utilisateur session;
    AskServer askServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_abstract);
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

}

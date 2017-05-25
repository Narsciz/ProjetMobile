package progmobile.coursenligne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import progmobile.coursenligne.CommonClasses.Utilisateur;


public class AuthentificationActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
    }

    public void validerAuthentification(View view){

        //on récup email et mdp
        EditText emailEditText=(EditText)findViewById(R.id.edit_email);
        EditText mdpEditText=(EditText)findViewById(R.id.edit_mdp);
        String nom=emailEditText.getText().toString();
        String prenom=mdpEditText.getText().toString();

        if (/*vérif bdd*/true){
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
        else {
            //afficher une erreur
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.inscription_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_inscription:
                startActivity(new Intent(this,InscriptionActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

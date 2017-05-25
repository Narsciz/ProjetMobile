package progmobile.coursenligne;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;




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
}

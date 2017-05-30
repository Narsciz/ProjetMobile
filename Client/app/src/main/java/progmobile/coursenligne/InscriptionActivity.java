package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InscriptionActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Spinner spin=(Spinner)findViewById(R.id.insciption_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choix_annee, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void validerInscription(View view){
        CheckBox prof=(CheckBox)findViewById(R.id.inscription_checkbox);
        EditText emailE=(EditText)findViewById(R.id.inscription_email);
        EditText mdpE=(EditText)findViewById(R.id.inscription_mdp);
        EditText mdp2E=(EditText)findViewById(R.id.inscription_mdp2);
        EditText prenomE=(EditText)findViewById(R.id.inscription_prenom);
        EditText nomE=(EditText)findViewById(R.id.inscription_nom);
        Spinner spin=(Spinner)findViewById(R.id.insciption_spinner);

        String email=emailE.getText().toString();
        String mdp=mdpE.getText().toString();
        String mdp2=mdp2E.getText().toString();
        String prenom=prenomE.getText().toString();
        String nom=nomE.getText().toString();
        String type;
        String annee="none";

        if (!mdp.equals(mdp2)){
            Toast.makeText(this,"Mot de passes différents",Toast.LENGTH_SHORT).show();
            return;
        }

        if (prof.isChecked())
            type="true";
        else{
            annee=spin.getSelectedItem().toString();
            type="false";
        }





        String request="inscription;"+email+";"+mdp+";"+prenom+";"+nom+";"+type+";"+annee;
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);



    }

    public void modifyCheckBox(View view) {
        CheckBox prof=(CheckBox)findViewById(R.id.inscription_checkbox);
        Spinner spin = (Spinner) findViewById(R.id.insciption_spinner);
        if (prof.isChecked()) {

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.array_vide, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(adapter);
        }
        else {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.choix_annee, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(adapter);
        }
    }
}

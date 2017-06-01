package progmobile.coursenligne;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static android.R.attr.path;

public class CreateCoursActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cours);
        Spinner spinner = (Spinner) findViewById(R.id.createCours_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choix_lien, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    //bouton pour ajouter le cours
    public void ajouterCours(View view) {
        EditText nomCoursE=(EditText)findViewById(R.id.creationCours_nom);
        String nomCours=nomCoursE.getText().toString();
        EditText pathCoursE=(EditText)findViewById(R.id.creationCours_lien);
        String pathCours=pathCoursE.getText().toString();

        Spinner spinner = (Spinner) findViewById(R.id.createCours_spinner);

        String request="creationCours;"+nomCours+";"+currentIntitule+";"+spinner.getSelectedItem().toString()+";"+pathCours;
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}

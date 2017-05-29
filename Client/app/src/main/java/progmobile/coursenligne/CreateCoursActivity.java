package progmobile.coursenligne;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.path;

public class CreateCoursActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cours);
    }

    public void ajouterCours(View view) {
        EditText nomCoursE=(EditText)findViewById(R.id.creationCours_nom);
        String nomCours=nomCoursE.getText().toString();
        EditText pathCoursE=(EditText)findViewById(R.id.creationCours_lien);
        String pathCours=pathCoursE.getText().toString();


        String request="createCours;"+nomCours+";"+currentIntitule+";"+pathCours;
        new AskServerTask(this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}

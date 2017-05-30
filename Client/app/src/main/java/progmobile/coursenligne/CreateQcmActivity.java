package progmobile.coursenligne;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Vector;

import CommonClasses.QCM;

import static android.text.InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE;

public class CreateQcmActivity extends AbstractActivity {

    QCM qcm=new QCM();
    String serial="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EditText titreQcm=new EditText(this);
        titreQcm.setHint("Titre QCM");

        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        final LinearLayout qcmLayout=new LinearLayout(this);
        qcmLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout buttonsLayout=new LinearLayout(this);
        buttonsLayout.setOrientation(LinearLayout.HORIZONTAL);

        Spinner spin=new Spinner(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choix_nb_reponse, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        Vector<Vector<LinearLayout>> LLreponses=new Vector<>();
        final Vector<LinearLayout> LLQreponses=new Vector<>();




        Button ajouterQuestion=new Button(this);
        ajouterQuestion.setText("+ question");
        ajouterQuestion.setOnClickListener(new OnClickListenerLLayoutSpinnerVectorVector(qcmLayout,spin,LLreponses,LLQreponses){
            public void onClick(View v){

                LinearLayout questionReponse=new LinearLayout(CreateQcmActivity.this);
                questionReponse.setOrientation(LinearLayout.VERTICAL);
                Vector<LinearLayout> LLreponse=new Vector<>();
                LLQreponsesO.add(questionReponse);
                qcmLayoutO.addView(questionReponse);

                EditText question=new EditText(CreateQcmActivity.this);
                question.setHint("Question");
                question.setInputType(TYPE_TEXT_VARIATION_SHORT_MESSAGE);

                questionReponse.addView(question);

                LinearLayout reponses=new LinearLayout(CreateQcmActivity.this);
                reponses.setOrientation(LinearLayout.VERTICAL);


                int nbReponse=Integer.parseInt(spinnerO.getSelectedItem().toString());
                for (int i=0;i<nbReponse;i++){
                    LinearLayout reponse=new LinearLayout(CreateQcmActivity.this);
                    reponse.setOrientation(LinearLayout.HORIZONTAL);
                    CheckBox checkBox=new CheckBox(CreateQcmActivity.this);
                    EditText reponseString=new EditText(CreateQcmActivity.this);
                    reponseString.setHint("réponse "+i);
                    reponseString.setInputType(TYPE_TEXT_VARIATION_SHORT_MESSAGE);
                    reponse.addView(checkBox);
                    reponse.addView(reponseString);
                    reponses.addView(reponse);
                    LLreponse.add(reponse);
                }
                LLreponsesO.add(LLreponse);
                qcmLayoutO.addView(reponses);

            }
        });



        Button valider=new Button(this);
        valider.setText("Enregistrer");
        valider.setOnClickListener(new OnClickListenerLLayoutVectorVectorStringString(qcmLayout,LLreponses,LLQreponses,titreQcm, currentIntitule){
            public void onClick(View v){
                String request = "creationQcm;"+titreQcmO.getText().toString()+";"+ intituleQcmO +";";
                try {
                    int nbQR = LLQreponsesO.size();
                    for (int i = 0; i < nbQR; i++) {
                        LinearLayout currentQR = LLQreponsesO.get(i);
                        EditText question = (EditText) currentQR.getChildAt(0);
                        String questionString = question.getText().toString();
                        request += questionString + '|';

                        LinearLayout currentReponses = LLQreponsesO.get(i);
                        int nbReponse = currentReponses.getChildCount();
                        for (int j = 0; j < nbReponse; j++) {
                            LinearLayout reponseLL =  (LinearLayout)currentReponses.getChildAt(j);
                            CheckBox checkBox = (CheckBox) reponseLL.getChildAt(0);
                            String bool = "";
                            if (checkBox.isChecked())
                                bool = "true";
                            else bool = "false";

                            EditText reponseE = (EditText) reponseLL.getChildAt(1);
                            String reponseString = reponseE.getText().toString();
                            request += reponseString + '@' + bool;
                        }
                    }
                    Toast.makeText(CreateQcmActivity.this, request, Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    Toast.makeText(CreateQcmActivity.this, "Exception :"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
                new AskServerTask(CreateQcmActivity.this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });

        ScrollView scroll=new ScrollView(this);
        scroll.addView(layout);

        buttonsLayout.addView(ajouterQuestion);
        buttonsLayout.addView(spin);



        layout.addView(titreQcm);
        layout.addView(qcmLayout);
        layout.addView(buttonsLayout);
        layout.addView(valider);



        setContentView(scroll);
    }
}

package progmobile.coursenligne;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import CommonClasses.QCM;

import static android.text.InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE;

public class CreateQcmActivity extends AbstractActivity {

    QCM qcm=new QCM();
    String serial="";
    LayoutQcm layoutQcm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutQcm =new LayoutQcm(this);
        EditText titreQcm=new EditText(this);
        titreQcm.setHint("Titre QCM");

        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layoutQcm.setOrientation(LinearLayout.VERTICAL);

        LinearLayout buttonsLayout=new LinearLayout(this);
        buttonsLayout.setOrientation(LinearLayout.HORIZONTAL);

        Spinner spin=new Spinner(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choix_nb_reponse, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        Button ajouterQuestion=new Button(this);
        ajouterQuestion.setText("+ question");

        ajouterQuestion.setOnClickListener(new OnClickListenerLLayoutSpinner(layoutQcm,spin){
            public void onClick(View v){

                EditText question=new EditText(CreateQcmActivity.this);
                question.setHint("Question");
                question.setInputType(TYPE_TEXT_VARIATION_SHORT_MESSAGE);

                LayoutReponses reponses=new LayoutReponses(CreateQcmActivity.this);
                reponses.setOrientation(LinearLayout.VERTICAL);

                LayoutQReponse questionReponse=new LayoutQReponse(CreateQcmActivity.this,question,reponses);
                questionReponse.setOrientation(LinearLayout.VERTICAL);

                layoutQcmO.addQReponse(questionReponse);


                questionReponse.addView(question);


                int nbReponse=Integer.parseInt(spinnerO.getSelectedItem().toString());
                for (int i=0;i<nbReponse;i++){

                    CheckBox checkBox=new CheckBox(CreateQcmActivity.this);
                    EditText reponseString=new EditText(CreateQcmActivity.this);
                    reponseString.setHint("réponse "+i);
                    reponseString.setInputType(TYPE_TEXT_VARIATION_SHORT_MESSAGE);

                    LayoutCheckBoxReponse reponse=new LayoutCheckBoxReponse(CreateQcmActivity.this,checkBox,reponseString);
                    reponse.setOrientation(LinearLayout.HORIZONTAL);
                    reponse.addView(checkBox);
                    reponse.addView(reponseString);
                    reponses.addCheckBoxReponse(reponse);

                }

                layoutQcmO.addView(reponses);

            }
        });

        Button valider=new Button(this);
        valider.setText("Enregistrer");

        valider.setOnClickListener(new onClickListenerQcmLayoutString(layoutQcm,titreQcm){
            public void onClick(View v){
                currentCreateQcmRequest = "creationQcm;"+titreQcmO.getText().toString()+";"+ currentIntitule +";";
                try {
                    int nbQR = layoutQcm.size();
                    for (int i = 0; i < nbQR; i++) {
                        LayoutQReponse currentQR = layoutQcm.get(i);
                        EditText question = currentQR.getQuestion();
                        String questionString = question.getText().toString();
                        currentCreateQcmRequest += questionString + '|';

                        LayoutReponses currentReponses = currentQR.getReponses();
                        int nbReponse = currentReponses.size();
                        for (int j = 0; j < nbReponse; j++) {
                            LayoutCheckBoxReponse checkBoxReponse =  currentReponses.get(j);
                            CheckBox checkBox = checkBoxReponse.getCheckBox();
                            String bool;
                            if (checkBox.isChecked())
                                bool = "true";
                            else bool = "false";

                            EditText reponseE = checkBoxReponse.getReponse();
                            String reponseString = reponseE.getText().toString();
                            currentCreateQcmRequest += reponseString + '@' + bool;
                            if (j!=nbReponse-1)
                                currentCreateQcmRequest+='&';
                        }
                        if (i!=nbQR-1)
                            currentCreateQcmRequest+='$';
                    }
                    //Toast.makeText(CreateQcmActivity.this, currentCreateQcmRequest, Toast.LENGTH_LONG).show();
                    currentCreateQcmRequest+=";";
                    new AskServerTask(CreateQcmActivity.this,"getusers;"+currentIntitule).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                    //new AskServerTask(CreateQcmActivity.this,request).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }
                catch(Exception e){
                    Toast.makeText(CreateQcmActivity.this, "Exception :"+e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        ScrollView scroll=new ScrollView(this);
        scroll.addView(layout);

        buttonsLayout.addView(ajouterQuestion);
        buttonsLayout.addView(spin);

        layout.addView(titreQcm);
        layout.addView(layoutQcm);
        layout.addView(buttonsLayout);
        layout.addView(valider);

        setContentView(scroll);
    }
}

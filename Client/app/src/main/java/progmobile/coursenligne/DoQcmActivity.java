package progmobile.coursenligne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import CommonClasses.QCM;
import CommonClasses.Question;

public class DoQcmActivity extends AppCompatActivity {


    QCM qcm=new QCM();
    QCM qcmReponse=new QCM();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scroll=new ScrollView(this);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scroll.addView(layout);

        Bundle b=getIntent().getExtras();

        final String serialQcm=b.getString("serialQcm");
        int idQcm=b.getInt("idQcm");

        qcm=new QCM(b.getString("nomQcm"),serialQcm,idQcm);
        qcmReponse=new QCM(b.getString("nomQcm"),serialQcm,idQcm,false);
        TextView title=new TextView(this);
        title.setText(qcm.getNom()+"\n");

        title.setTextSize(35);
        layout.addView(title);

        Vector<Question> questions=qcm.getQuestions();
        for (int i=0;i<questions.size();i++){
            TextView questionView=new TextView(this);

            questionView.setText(questions.get(i).getQuestion());
            questionView.setTextSize(16);
            layout.addView(questionView);

            HashMap<String,Boolean> reponses=questions.get(i).getReponses();
            for (Map.Entry<String, Boolean> entry : reponses.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();

                LinearLayout reponseLayout=new LinearLayout(this);
                reponseLayout.setOrientation(LinearLayout.HORIZONTAL);

                CheckBox checkBox=new CheckBox(this);
                checkBox.setOnCheckedChangeListener(new OnCheckedChangeListenerIndexKeyQcm(i,key,qcmReponse) {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        qcm.getQuestions().get(index).getReponses().put(key,isChecked);
                    }
                });
                reponseLayout.addView(checkBox);

                TextView reponse=new TextView(this);
                reponse.setText(key);
                reponseLayout.addView(reponse);

                layout.addView(reponseLayout);
            }

        }



        Button valider=new Button(this);
        valider.setText("Valider QCM");
        layout.addView(valider);
        TextView resultat=new TextView(this);
        resultat.setText("%");
        layout.addView(resultat);
        valider.setOnClickListener(new OnClickListenerStringView(serialQcm,resultat){
            public void onClick(View v){
                QCM reponseQcm= new QCM("reponses",string,-1);
                textView.setText("Résultat : "+qcm.getResultat(reponseQcm)+"%");
            }
        });


        setContentView(scroll);



    }
}

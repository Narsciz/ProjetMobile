package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import CommonClasses.Annee;
import CommonClasses.Utilisateur;

/**
 * ChooseQcmUserActivity est l'activité qui permet de choisir les utilisateurs dont on veut
 * qu'ils soient notifié de la création du qcm en cours de validation
 */
public class ChooseQcmUserActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutUtilisateurs layout=new LayoutUtilisateurs(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        ScrollView scroll=new ScrollView(this);
        scroll.addView(layout);

        //on récupère la liste des users sérialisé "idUser|nomUser|prenomUser"
        String[] splitRequest=getIntent().getExtras().getStringArray("users");

        for (int i=1;i<splitRequest.length;i++){
            String[] splitUser=splitRequest[i].split("\\|");
            LayoutUtilisateur utilisateur=new LayoutUtilisateur(this,new Utilisateur(splitUser[0],splitUser[1],splitUser[2],true,null,null));
            utilisateur.setOrientation(LinearLayout.HORIZONTAL);
            layout.addUtilisateur(utilisateur);
        }

        Button valider=new Button(this);
        layout.addView(valider);
        valider.setText("Valider");

        //On passe le layout à l'évent pour qu'il puisse récupérer la valeur des checkboxs
        valider.setOnClickListener(new OnClickListenerLayoutUtilisateurs(layout) {
            public void onClick(View v) {
                for (int i=0;i<layoutO.size();i++){
                    LayoutUtilisateur l=layoutO.get(i);
                    if (l.getCheckBox().isChecked())
                        currentCreateQcmRequest+=l.getUtilisateur().getIdMail();
                }
                new AskServerTask(ChooseQcmUserActivity.this,currentCreateQcmRequest).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });

        setContentView(scroll);
    }
}

package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Map;
import java.util.Vector;

public class QcmAfaireActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //Vector<Button> boutons=new Vector<>();
        /*Bundle b=this.getIntent().getExtras();
        final String[] listeNomQcm=b.getStringArray("listeNomQcm");
        final String[] listeIdQcm=b.getStringArray("listeIdQcm");


        for (int i=0;i<listeNomQcm.length;i++) {
            boutons.add(new Button(this));
            boutons.get(i).setText(listeNomQcm[i]);

            boutons.get(i).setOnClickListener(new OnClickListenerString(listeIdQcm[i]){
                public void onClick(View v){
                    String request="qcmAfaire;"+intitule;
                    new AskServerTask(QcmAfaireActivity.this,request).execute();
                }
            });

            layout.addView(boutons.get(i));
        }
*/
        for (Map.Entry<String, String> entry : qcmsAfaire.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            Button bouton=new Button(this);
            bouton.setText(key);
            String request="qcm;"+value+";"+key;
            bouton.setOnClickListener(new OnClickListenerString(request){
                public void onClick(View v){

                    new AskServerTask(QcmAfaireActivity.this,intitule).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }
            });

            layout.addView(bouton);
        }
        scroll.addView(layout);
        setContentView(scroll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();


        inflater.inflate(R.menu.base_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_home:
                if (session.getEtudiant())
                    new AskServerTask(this,"qcmAfaire;"+session.getIdMail()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                else startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.item_deconnexion:
                startActivity(new Intent(this,DoQcmActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

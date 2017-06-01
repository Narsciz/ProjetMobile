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

import java.util.Vector;

public class IntitulesActivity extends AbstractActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Bundle b=this.getIntent().getExtras();
        final String[] listeIntitules=b.getStringArray("intitules");

        Vector<Button> boutons=new Vector<>();



        for (int i=0;i<listeIntitules.length;i++) {

            boutons.add(new Button(this));
            boutons.get(i).setText(listeIntitules[i]);


            boutons.get(i).setOnClickListener(new OnClickListenerString(listeIntitules[i]){
                public void onClick(View v){
                    Intent i=new Intent(IntitulesActivity.this,ChoixActivity.class);
                    i.putExtra("intitule",intitule);
                    currentIntitule=intitule;
                    startActivity(i);
                }
            });

            layout.addView(boutons.get(i));
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
                startActivity(new Intent(this,AuthentificationActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}

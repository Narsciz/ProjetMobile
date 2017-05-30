package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
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

public class QcmActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Vector<Button> boutons=new Vector<>();
        Bundle b=this.getIntent().getExtras();
        final String[] listeNomQcm=b.getStringArray("listeNomQcm");
        final String[] listeIdQcm=b.getStringArray("listeIdQcm");


        for (int i=0;i<listeNomQcm.length;i++) {
            boutons.add(new Button(this));
            boutons.get(i).setText(listeNomQcm[i]);
            String request="qcm;"+listeIdQcm[i]+";"+listeNomQcm[i];

            boutons.get(i).setOnClickListener(new OnClickListenerString(request){
                public void onClick(View v){
                    //String request="qcm;"+intitule;
                    new AskServerTask(QcmActivity.this,intitule).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
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

        if (/*prof*/true)
            inflater.inflate(R.menu.qcm_prof_menu,menu);

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
            case R.id.item_qcm:
                Intent intent=new Intent(this,CreateQcmActivity.class);
                Bundle b=getIntent().getExtras();
                String intitule=b.getString("intitule");
                intent.putExtra("intitule",intitule);
                startActivity(intent);
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

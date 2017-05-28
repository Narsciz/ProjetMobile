package progmobile.coursenligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Vector;

public class HomeActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        /*ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Vector<Button> boutons=new Vector<>();
        //récup liste matières utilisateur


        for (int i=0;i<100;i++) {
            boutons.add(new Button(this));
            boutons.get(i).setText("matière"+i);

            boutons.get(i).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(new Intent(HomeActivity.this,ChoixActivity.class));
                }
            });

            layout.addView(boutons.get(i));
        }

        scroll.addView(layout);
        setContentView(scroll);
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.base_menu,menu);
        //if (/*eleve*/ true && true /*qcm à faire != 0*/ )
        inflater.inflate(R.menu.qcm_eleve_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_home:
                startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.item_deconnexion:
                startActivity(new Intent(this,AuthentificationActivity.class));
                break;
            case R.id.item_qcm_a_faire:
                String request="qcmAfaire;"+AbstractActivity.getSession().getIdMail();
                new AskServerTask(this,request).execute();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void consulterMatiere(View view){
    }

    public void consulterMath(View view) {
        String request="matiere;mathematiques;"+getSession().getAnnee();
        new AskServerTask(this,request).execute();
    }

    public void consulterInformatique(View view) {
        String request="matiere;informatique;"+getSession().getAnnee();
        new AskServerTask(this,request).execute();
    }

    public void consulterBio(View view) {
        String request="matiere;biologie;"+getSession().getAnnee();
        new AskServerTask(this,request).execute();
    }

    public void consulterChimie(View view) {
        String request="matiere;chimie;"+getSession().getAnnee();
        new AskServerTask(this,request).execute();
    }

    public void consulterPhysique(View view) {
        String request="matiere;physique;"+getSession().getAnnee();
        new AskServerTask(this,request).execute();
    }
}

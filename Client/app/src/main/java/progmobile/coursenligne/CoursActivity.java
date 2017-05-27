package progmobile.coursenligne;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
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
import android.widget.Toast;

import java.io.File;
import java.util.Vector;


public class CoursActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Vector<Button> boutons=new Vector<>();
        Bundle b=this.getIntent().getExtras();
        final String[] listeNomCours=b.getStringArray("listeNomCours");
        final String[] listeTypeCours=b.getStringArray("listeTypeCours");
        final String[] listePathCours=b.getStringArray("listePathCours");



        for (int i=0;i<listeNomCours.length;i++) {
            boutons.add(new Button(this));
            boutons.get(i).setText(listeNomCours[i]);

            if (listeTypeCours[i].equals("pdf")){
                boutons.get(i).setOnClickListener(new OnClickListenerString( listePathCours[i]) {
                    public void onClick(View v) {
                        Intent intent;
                        intent = new Intent(CoursActivity.this, PdfActivity.class);
                        intent.putExtra("pathCours",intitule);
                        CoursActivity.this.startActivity(intent);
                    }
                });
            }
            else if (listeTypeCours[i].equals("video")){
                boutons.get(i).setOnClickListener(new OnClickListenerString( listePathCours[i]) {
                    public void onClick(View v) {
                        Intent intent;
                        intent = new Intent(CoursActivity.this, StreamingActivity.class);
                        intent.putExtra("pathCours",intitule);
                        CoursActivity.this.startActivity(intent);
                    }
                });
            }
            

            layout.addView(boutons.get(i));
        }

        scroll.addView(layout);
        setContentView(scroll);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();

        if (/*prof*/true)
            inflater.inflate(R.menu.cours_prof_menu,menu);

        inflater.inflate(R.menu.base_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_home:
                startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.item_cours:
                startActivity(new Intent(this,CreateCoursActivity.class));
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


package progmobile.coursenligne;

import android.content.Intent;
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

public class QcmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scroll=new ScrollView(this);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Vector<Button> boutons=new Vector<>();
        //récup liste QCMs utilisateur


        for (int i=0;i<100;i++) {
            boutons.add(new Button(this));
            boutons.get(i).setText("QCM"+i);

            boutons.get(i).setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(new Intent(QcmActivity.this,MatiereActivity.class));
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
                startActivity(new Intent(this,HomeActivity.class));
                break;
            case R.id.item_qcm:
                startActivity(new Intent(this,CreateQcmActivity.class));
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

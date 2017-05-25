package progmobile.coursenligne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatiereActivity extends AbstractActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();

        if (/*prof*/true) {
            inflater.inflate(R.menu.cours_prof_menu, menu);
            inflater.inflate(R.menu.qcm_prof_menu,menu);
        }

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
            case R.id.item_qcm:
                startActivity(new Intent(this,CreateQcmActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void consulterCours(View view){
        startActivity(new Intent(this,CoursActivity.class));
    }

    public void consulterQcm(View view){
        startActivity(new Intent(this,QcmActivity.class));
    }
}

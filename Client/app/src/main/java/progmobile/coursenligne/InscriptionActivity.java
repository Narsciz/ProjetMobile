package progmobile.coursenligne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
    }

    public void validerInscription(View view){
        CheckBox prof=(CheckBox)findViewById(R.id.inscription_checkbox);
        boolean p=prof.isChecked();
        if (p)
            startActivity(new Intent(this,HomeActivity.class));
        else
            startActivity(new Intent(this,InscriptionMatiereActivity.class));

    }
}

package progmobile.coursenligne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DoQcmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t=new TextView(this);
        Bundle b=getIntent().getExtras();
        String serialQcm=b.getString("serialQcm");
        t.setText("qcm"+serialQcm);
        setContentView(t);
    }
}

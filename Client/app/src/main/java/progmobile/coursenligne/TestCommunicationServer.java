package progmobile.coursenligne;

import android.content.Intent;
import android.database.CursorJoiner;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TestCommunicationServer extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_communication_server);
    }

    public void sendMessage(View view) throws InterruptedException {
        EditText e=(EditText)findViewById(R.id.editText);
        String s=e.getText().toString();
        EditText ip=(EditText)findViewById(R.id.test_ip);
        AskServer.setServerIP(ip.getText().toString());

        CheckBox c=(CheckBox)findViewById(R.id.test_checkbox);
        AskServer.setServeurMarchePas(c.isChecked());
        new AskServerTask(this,"echo;"+s).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    public void sendToAuthentification(View view){
        EditText ip=(EditText)findViewById(R.id.test_ip);
        AskServer.setServerIP(ip.getText().toString());
        CheckBox c=(CheckBox)findViewById(R.id.test_checkbox);
        AskServer.setServeurMarchePas(c.isChecked());
        startActivity(new Intent(this,AuthentificationActivity.class));
    }

}

package progmobile.coursenligne;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestCommunicationServer extends AbstractActivity {

    Thread t;
    AskServerTask askServerTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_communication_server);
    }

    public void sendMessage(View view) throws InterruptedException {
        EditText e=(EditText)findViewById(R.id.editText);
        String s=e.getText().toString();
        /*askServer =new AskServer();
        askServerTask =new AskServerTask(this);
        askServerTask.execute(s);*/
        new AskServerTask(this,s).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    public void sendToAuthentification(View view){
        startActivity(new Intent(this,AuthentificationActivity.class));
    }
}

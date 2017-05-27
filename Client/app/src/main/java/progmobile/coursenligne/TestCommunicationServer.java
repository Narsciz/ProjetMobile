package progmobile.coursenligne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TestCommunicationServer extends AbstractActivity {

    Thread t;
    Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_communication_server);
    }

    public void sendMessage(View view) throws InterruptedException {
        EditText e=(EditText)findViewById(R.id.editText);
        String s=e.getText().toString();
        client=new Client(s);
        task=new Task(this);
        task.execute(s);
    }
    public void sendToAuthentification(View view){
        startActivity(new Intent(this,AuthentificationActivity.class));
    }
}

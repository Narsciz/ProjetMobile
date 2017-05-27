package progmobile.coursenligne;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Millenium on 27/05/2017.
 */

public class Task extends AsyncTask<String,Void,String> {

    private Context context;

    Task(Context c){
        context=c;
    }



    @Override
    protected String doInBackground(String... params) {
        Client c=new Client(params[0]);
        c.run();
        return c.getResponse();
    }

    @Override
    protected void onPostExecute(String result){
        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
    }

}

package progmobile.coursenligne;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Millenium on 28/05/2017.
 */
public class OnClickListenerStringViewString implements View.OnClickListener {
    String string;
    TextView textView;
    String id;
    @Override
    public void onClick(View v) {

    }

    OnClickListenerStringViewString(String s, TextView v,String i){
        string=s;
        textView=v;
        id=i;
    }
}

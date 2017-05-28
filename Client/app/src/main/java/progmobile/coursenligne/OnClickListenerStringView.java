package progmobile.coursenligne;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Millenium on 28/05/2017.
 */
public class OnClickListenerStringView implements View.OnClickListener {
    String string;
    TextView textView;
    @Override
    public void onClick(View v) {

    }

    OnClickListenerStringView(String s,TextView v){
        string=s;
        textView=v;
    }
}

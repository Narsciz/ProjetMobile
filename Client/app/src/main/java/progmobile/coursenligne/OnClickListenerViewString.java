package progmobile.coursenligne;

import android.view.View;
import android.widget.TextView;

/**
 * Sert juste à passer en paramètre des objets
 */
public class OnClickListenerViewString implements View.OnClickListener {

    TextView resultatO;
    String requestO;
    @Override
    public void onClick(View v) {

    }

    OnClickListenerViewString(String s, TextView v, String i){
        resultatO=v;
        requestO=i;
    }
}

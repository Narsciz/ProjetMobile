package progmobile.coursenligne;


import android.view.View;

/**
 * Sert juste à passer en paramètre des objets
 */

public class OnClickListenerString implements View.OnClickListener {

    String intitule;
    OnClickListenerString(String i){
        intitule=i;
    }
    @Override
    public void onClick(View v) {

    }
}

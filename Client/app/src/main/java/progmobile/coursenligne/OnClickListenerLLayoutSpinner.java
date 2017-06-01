package progmobile.coursenligne;

import android.view.View;
import android.widget.Spinner;

/**
 * Sert juste à passer en paramètre des objets
 */
public class OnClickListenerLLayoutSpinner implements View.OnClickListener {
    LayoutQcm layoutQcmO;
    Spinner spinnerO;
    public OnClickListenerLLayoutSpinner(LayoutQcm layoutQcm, Spinner spin) {
        layoutQcmO = layoutQcm;
        spinnerO=spin;
    }

    @Override
    public void onClick(View v) {

    }
}

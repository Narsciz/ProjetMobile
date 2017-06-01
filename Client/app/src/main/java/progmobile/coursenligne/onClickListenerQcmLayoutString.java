package progmobile.coursenligne;

import android.view.View;
import android.widget.EditText;

/**
 * Sert juste à passer en paramètre des objets
 */
public class onClickListenerQcmLayoutString implements View.OnClickListener {
    LayoutQcm layoutQcmO;
    EditText titreQcmO;
    public onClickListenerQcmLayoutString(LayoutQcm q, EditText t) {
        layoutQcmO =q;
        titreQcmO=t;
    }

    @Override
    public void onClick(View v) {

    }
}

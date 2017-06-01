package progmobile.coursenligne;

import android.view.View;

/**
 * Sert juste à passer en paramètre des objets
 */
public class OnClickListenerLayoutUtilisateurs implements View.OnClickListener {
    protected LayoutUtilisateurs layoutO;

    public OnClickListenerLayoutUtilisateurs(LayoutUtilisateurs layout) {
        layoutO=layout;
    }

    @Override
    public void onClick(View v) {

    }
}

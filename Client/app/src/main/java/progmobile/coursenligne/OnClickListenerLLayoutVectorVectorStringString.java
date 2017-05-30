package progmobile.coursenligne;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class OnClickListenerLLayoutVectorVectorStringString implements View.OnClickListener {
    protected final LinearLayout qcmLayoutO;
    protected final Vector<LinearLayout> LLQreponsesO;
    protected Vector<Vector<LinearLayout>> LLreponsesO;
    protected EditText titreQcmO;
    protected String intituleQcmO;



    public OnClickListenerLLayoutVectorVectorStringString(LinearLayout q, Vector<Vector<LinearLayout>> v1, Vector<LinearLayout> v2, EditText t, String i) {
        qcmLayoutO=q;
        LLreponsesO=v1;
        LLQreponsesO=v2;
        titreQcmO=t;
        intituleQcmO=i;
    }

    @Override
    public void onClick(View v) {

    }
}

package progmobile.coursenligne;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Vector;

/**
 * Created by Millenium on 29/05/2017.
 */
public class OnClickListenerLLayoutSpinnerVectorVector implements View.OnClickListener {
    LinearLayout qcmLayoutO;
    Spinner spinnerO;
    Vector<Vector<LinearLayout>> LLreponsesO;
    Vector<LinearLayout> LLQreponsesO;
    public OnClickListenerLLayoutSpinnerVectorVector(LinearLayout q, Spinner s, Vector<Vector<LinearLayout>> v,Vector<LinearLayout> v2) {
        this.qcmLayoutO=q;
        spinnerO=s;
        LLreponsesO=v;
        LLQreponsesO=v2;
    }

    @Override
    public void onClick(View v) {

    }
}

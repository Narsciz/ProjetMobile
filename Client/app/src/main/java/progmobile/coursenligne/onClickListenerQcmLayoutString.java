package progmobile.coursenligne;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Millenium on 30/05/2017.
 */
public class onClickListenerQcmLayoutString implements View.OnClickListener {
    QcmLayout qcmLayoutO;
    EditText titreQcmO;
    public onClickListenerQcmLayoutString(QcmLayout q, EditText t) {
        qcmLayoutO=q;
        titreQcmO=t;
    }

    @Override
    public void onClick(View v) {

    }
}

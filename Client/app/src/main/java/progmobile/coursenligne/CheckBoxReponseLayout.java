package progmobile.coursenligne;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Millenium on 30/05/2017.
 */
public class CheckBoxReponseLayout extends LinearLayout {
    CheckBox checkBox;
    EditText reponse;

    public CheckBoxReponseLayout(Context context,CheckBox c,EditText e) {
        super(context);
        checkBox=c;
        reponse=e;
    }


    public CheckBox getCheckBox() {
        return checkBox;
    }

    public EditText getReponse() {
        return reponse;
    }
}

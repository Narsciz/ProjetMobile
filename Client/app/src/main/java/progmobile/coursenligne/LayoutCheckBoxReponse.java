package progmobile.coursenligne;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;


public class LayoutCheckBoxReponse extends LinearLayout {
    CheckBox checkBox;
    EditText reponse;

    public LayoutCheckBoxReponse(Context context, CheckBox c, EditText e) {
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

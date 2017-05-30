package progmobile.coursenligne;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class ReponsesLayout extends LinearLayout{
    Vector<CheckBoxReponseLayout> checkBoxReponses=new Vector<>();

    public ReponsesLayout(Context context) {
        super(context);
    }

    public void addCheckBoxReponse(CheckBoxReponseLayout c){
        super.addView(c);
        checkBoxReponses.add(c);
    }

    public int size() {
        return checkBoxReponses.size();
    }

    public CheckBoxReponseLayout get(int i) {
        return checkBoxReponses.get(i);
    }
}

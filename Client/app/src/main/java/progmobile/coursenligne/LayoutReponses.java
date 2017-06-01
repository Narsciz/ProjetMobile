package progmobile.coursenligne;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class LayoutReponses extends LinearLayout{
    Vector<LayoutCheckBoxReponse> checkBoxReponses=new Vector<>();

    public LayoutReponses(Context context) {
        super(context);
    }

    public void addCheckBoxReponse(LayoutCheckBoxReponse c){
        super.addView(c);
        checkBoxReponses.add(c);
    }

    public int size() {
        return checkBoxReponses.size();
    }

    public LayoutCheckBoxReponse get(int i) {
        return checkBoxReponses.get(i);
    }
}

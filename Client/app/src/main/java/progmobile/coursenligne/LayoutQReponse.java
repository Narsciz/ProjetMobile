package progmobile.coursenligne;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Millenium on 30/05/2017.
 */
public class LayoutQReponse extends LinearLayout {
    EditText question;
    LayoutReponses reponses;

    public LayoutQReponse(Context context, EditText e, LayoutReponses r) {
        super(context);
        question=e;
        reponses=r;
    }

    public void addReponse(LayoutReponses r){
        super.addView(r);
        //reponses.add(r);
    }

    public EditText getQuestion() {
        return question;
    }

    public LayoutReponses getReponses() {
        return reponses;
    }
}

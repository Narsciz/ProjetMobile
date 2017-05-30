package progmobile.coursenligne;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class QReponseLayout extends LinearLayout {
    EditText question;
    ReponsesLayout reponses;

    public QReponseLayout(Context context,EditText e,ReponsesLayout r) {
        super(context);
        question=e;
        reponses=r;
    }

    public void addReponse(ReponsesLayout r){
        super.addView(r);
        //reponses.add(r);
    }

    public EditText getQuestion() {
        return question;
    }

    public ReponsesLayout getReponses() {
        return reponses;
    }
}

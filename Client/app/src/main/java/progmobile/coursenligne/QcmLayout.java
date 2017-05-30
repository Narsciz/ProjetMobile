package progmobile.coursenligne;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class QcmLayout extends LinearLayout{
    Vector<QReponseLayout> QReponses=new Vector<>();

    public QcmLayout(Context context) {
        super(context);
    }


    public void addQReponse(QReponseLayout v){
        super.addView(v);
        QReponses.add(v);
    }

    public int size() {
        return QReponses.size();
    }

    public QReponseLayout get(int i) {
        return QReponses.get(i);
    }
}

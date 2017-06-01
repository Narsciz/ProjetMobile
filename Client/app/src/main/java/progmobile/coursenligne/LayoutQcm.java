package progmobile.coursenligne;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class LayoutQcm extends LinearLayout{
    Vector<LayoutQReponse> QReponses=new Vector<>();

    public LayoutQcm(Context context) {
        super(context);
    }


    public void addQReponse(LayoutQReponse v){
        super.addView(v);
        QReponses.add(v);
    }

    public int size() {
        return QReponses.size();
    }

    public LayoutQReponse get(int i) {
        return QReponses.get(i);
    }
}

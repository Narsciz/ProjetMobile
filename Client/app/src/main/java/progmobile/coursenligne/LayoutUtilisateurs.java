package progmobile.coursenligne;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Vector;

/**
 * Created by Millenium on 30/05/2017.
 */
public class LayoutUtilisateurs extends LinearLayout {

    Vector<LayoutUtilisateur> utilisateurs=new Vector<>();

    public LayoutUtilisateurs(Context context) {
        super(context);
    }

    public void addUtilisateur(LayoutUtilisateur utilisateur){
        utilisateurs.add(utilisateur);
        super.addView(utilisateur);
    }

    public int size() {
        return utilisateurs.size();
    }

    public LayoutUtilisateur get(int i) {
        return utilisateurs.get(i);
    }
}

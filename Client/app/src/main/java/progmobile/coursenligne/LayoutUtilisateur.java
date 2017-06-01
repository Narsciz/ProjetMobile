package progmobile.coursenligne;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import CommonClasses.Utilisateur;

/**
 * Created by Millenium on 30/05/2017.
 */
public class LayoutUtilisateur extends LinearLayout{

    Utilisateur utilisateur;
    CheckBox checkBox;
    TextView textView;

    public LayoutUtilisateur(Context c, Utilisateur u) {
        super(c);
        utilisateur=u;
        checkBox=new CheckBox(c);
        textView=new TextView(c);
        this.addView(checkBox);
        this.addView(textView);
        textView.setText(utilisateur.getNom()+" "+utilisateur.getPrenom());
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }
}

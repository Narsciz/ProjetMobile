package progmobile.coursenligne;

import android.widget.CompoundButton;

import CommonClasses.QCM;

/**
 * Sert juste à passer en paramètre des objets
 */
public class OnCheckedChangeListenerIndexKeyQcm implements CompoundButton.OnCheckedChangeListener {

    int index;
    String key;
    QCM qcm;

    OnCheckedChangeListenerIndexKeyQcm(int i, String k, QCM q){
        index=i;
        key=k;
        qcm=q;
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}

package CommonClasses;

/**
 * Created by Millenium on 27/05/2017.
 */

public class StaticMethods {
    static public Annee StringToAnnee(String s){
        s.toLowerCase();
        if (s=="l1")
            return Annee.L1;
        if (s=="l2")
            return Annee.L2;
        if (s=="l3")
            return Annee.L3;
        if (s=="m1")
            return Annee.M1;
        return Annee.M2;
    }

    static public boolean StringToBool(String s){
        s.toLowerCase();
        if (s=="true")
            return true;
        else return false;
    }
}

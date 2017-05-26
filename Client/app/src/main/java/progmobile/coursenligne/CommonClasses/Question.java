package CommonClasses;

import java.util.HashMap;
import java.util.Vector;



public class Question {

    private String laQuestion;
    private HashMap<String,Boolean> reponses=new HashMap<>();

    public Question(String l,HashMap<String,Boolean> r){
        laQuestion=l;
        reponses=r;
    }
    public String getQuestion(){
        return laQuestion;
    }

    public HashMap<String,Boolean> getReponses(){
        return reponses;
    }



}

package CommonClasses;

import java.util.HashMap;
import java.util.Vector;



public class Question {
    private long id;
    private String laQuestion;
    private HashMap<String,Boolean> reponses=new HashMap<>();

    public Question()
    {
        this.id = -1;
        this.laQuestion = null;
        this.reponses = null;
    }
    public Question(long id, String l,HashMap<String,Boolean> r){
        this.id = id;
        this.laQuestion=l;
        this.reponses=r;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion(){
        return laQuestion;
    }
    public void setLaQuestion(String laQuestion) {
        this.laQuestion = laQuestion;
    }

    public HashMap<String,Boolean> getReponses(){
        return reponses;
    }
}

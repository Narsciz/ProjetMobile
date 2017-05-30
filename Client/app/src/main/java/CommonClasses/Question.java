package CommonClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class Question {
    private int id;
    private String laQuestion;
    private HashMap<String,Boolean> reponses=new HashMap<>();

    public Question()
    {
        this.id = -1;
        this.laQuestion = null;
        this.reponses = null;
    }
    public Question(int id, String l,HashMap<String,Boolean> r){
        this.id = id;
        this.laQuestion=l;
        this.reponses=r;
    }

    public Question(String serial,boolean b) {
        try {
            String[] splitSerial = serial.split("\\|");
            id = -1;
            laQuestion = splitSerial[0];
            String[] lesReponses = splitSerial[1].split("&");
            for (int i = 0; i < lesReponses.length; i++) {
                String[] splitReponses = lesReponses[i].split("@");
                reponses.put(splitReponses[0], false);

            }
        }
        catch(Exception e){

        }
    }
    public Question(String serial) {
        try {
            String[] splitSerial = serial.split("\\|");
            id = -1;
            laQuestion = splitSerial[0];
            String[] lesReponses = splitSerial[1].split("&");
            for (int i = 0; i < lesReponses.length; i++) {
                String[] splitReponses = lesReponses[i].split("@");
                reponses.put(splitReponses[0], Boolean.valueOf(splitReponses[1]));
            }
        }
        catch(Exception e){

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isCorrect(Question question) {

        for (Map.Entry<String, Boolean> entry : reponses.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (question.getReponses().get(key)!=value)
                return false;
        }
        return true;
    }
}

package unify;

import javafx.beans.property.SimpleStringProperty;

/**
 * テーブルのデータを保存するクラス
 * Created by shimtom on 15/11/21.
 */
public class Sentence{
    private SimpleStringProperty sentence = new SimpleStringProperty();
    public Sentence(String sentence){
        this.sentence.set(sentence);
    }
    public SimpleStringProperty sentenceProperty(){
        return sentence;
    }
    public String getSentence(){
        return sentence.get();
    }
    public void setSentence(String sentence){
        this.sentence.set(sentence);
    }
}


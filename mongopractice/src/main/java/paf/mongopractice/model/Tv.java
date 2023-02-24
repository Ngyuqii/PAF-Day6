package paf.mongopractice.model;

import org.bson.Document;

import static paf.mongopractice.model.Constants.*;

public class Tv {

    private int id;
    private String name;
    private String url;
    
    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    //Create tv object from tv document in database
    public static Tv createTv (Document doc){
        Tv tvshow = new Tv();
        tvshow.setId(doc.getInteger(FIELD_ID));
        tvshow.setName(doc.getString(FIELD_NAME));
        tvshow.setUrl(doc.getString(FIELD_URL));
        return tvshow;
    }

    

    

    
}

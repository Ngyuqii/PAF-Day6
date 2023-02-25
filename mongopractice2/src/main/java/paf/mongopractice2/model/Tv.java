package paf.mongopractice2.model;

import org.bson.Document;

import static paf.mongopractice2.model.Constants.*;

public class Tv {

    private int id;
    private String name;
    private String url;
    private String type;
    private float ratingAvg;

    
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
    public String getType() {
        return type;
    }
    public float getRatingAvg() {
        return ratingAvg;
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
    public void setType(String type) {
        this.type = type;
    }
    public void setRatingAvg(float ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    //Create tv object from tv document in database
    public static Tv createTv (Document doc){
        Tv tvShow = new Tv();
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
        tvShow.setUrl(doc.getString(FIELD_URL));
        tvShow.setType(doc.getString(FIELD_TYPE));

        try {
            if (doc.getDouble(FIELD_RATING_AVERAGE) == null) {
                tvShow.setRatingAvg(0);
            }
            else {
                tvShow.setRatingAvg(doc.getDouble(FIELD_RATING_AVERAGE).floatValue());
            }
            		  
        } catch (Exception e) {
            tvShow.setRatingAvg(doc.getInteger(FIELD_RATING_AVERAGE).floatValue());
        } 
        return tvShow;
    }

    

    

    
}

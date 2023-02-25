package paf.mongopractice2.model;

public class Constants {

    //Set database and collection names
    public static final String DATABASE = "shows";
    public static final String COLLECTION = "tv";

    //All use fields
    public static final String FIELD_PKID = "_id";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_URL = "url";
    public static final String FIELD_LANGUAGE = "language";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_RATING = "rating";
    public static final String FIELD_AVERAGE = "average";
    public static final String FIELD_RATING_AVERAGE = "%s.%s".formatted(FIELD_RATING, FIELD_AVERAGE);
    
}

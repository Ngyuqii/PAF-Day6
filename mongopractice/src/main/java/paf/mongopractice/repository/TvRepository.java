package paf.mongopractice.repository;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static paf.mongopractice.model.Constants.*;

@Repository
public class TvRepository {

    @Autowired
    private MongoTemplate template;

    //Get all shows by language
    //db.tv.find({language: { $regex: 'english', $options: 'i' }})
    public List<Document> findShowsByLanguage(String lang) {

        //Create crtieria
        Criteria c = Criteria.where(FIELD_LANGUAGE).regex(lang, "i");
        //Criteria c = Criteria.where(FIELD_LANGUAGE).is(lang);

        //Create and perform a query
        Query q = Query.query(c);
        return template.find(q, Document.class, COLLECTION);

    }
    
}

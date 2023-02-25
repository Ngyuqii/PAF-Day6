package paf.mongopractice2.repository;

import java.util.Collections;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static paf.mongopractice2.model.Constants.*;

@Repository
public class TvRepository {

    @Autowired
    private MongoTemplate mTemplate;

    //Method to list out distinct tvshow types
    //db.tv.distinct("type")
    public List<String> getTypes() {
        List<String> result = mTemplate.findDistinct(new Query(), FIELD_TYPE, COLLECTION, String.class);
        Collections.sort(result);
        return result;
    }

    //Method to list out tvshows under the requested type, sort in descending order of rating.average
    /*
	    db.tvshows.find({
			type: { $regex: 'Animation', $options: 'i' }
		})
		.sort({ "rating.average": -1 })
		.projection({ _id: 0, id: 1, name: 1, "rating.average": 1 })
		.limit(20)
	  */
	 public List<Document> findShowsByType(String type) {
        return getShowsByType(type, 20);
    }

    public List<Document> getShowsByType(String type, int limit) {

       Criteria criteria = Criteria.where(FIELD_TYPE).regex(type, "i");

       Query query = Query.query(criteria)
            .with(Sort.by(Direction.DESC, FIELD_RATING_AVERAGE))
            .limit(limit);

       query.fields()
            .exclude(FIELD_PKID)
            .include(FIELD_ID, FIELD_NAME, FIELD_URL, FIELD_RATING_AVERAGE);

       return mTemplate.find(query, Document.class, COLLECTION);
    }

    //Method to get all shows by language
    //db.tv.find({language: { $regex: 'english', $options: 'i' }})
    public List<Document> findShowsByLanguage(String lang) {

        //Create crtieria
        //Criteria c = Criteria.where(FIELD_LANGUAGE).is(lang);
        Criteria c = Criteria.where(FIELD_LANGUAGE).regex(lang, "i");
        
        //Create and perform a query
        Query q = Query.query(c);
        return mTemplate.find(q, Document.class, COLLECTION);

    }
    
}

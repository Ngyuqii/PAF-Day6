package paf.mongopractice2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.mongopractice2.model.Tv;
import paf.mongopractice2.repository.TvRepository;

@Service
public class TvService {

    @Autowired
    private TvRepository tvRepo;

    //Method to list out distinct tvshow types
    public List<String> getAllTypes() {
        return tvRepo.getTypes();
    }

    //Method to list out tvshows under the requested type
    public List<Tv> findShowsByType(String type) {
        return tvRepo.findShowsByType(type)
            .stream()
            .map(v -> Tv.createTv(v))
            .toList();
    }

    //Method to get all shows by language, returns tv object
    public List<Tv> findTvShowsByLanguage(String lang) {
        return tvRepo.findShowsByLanguage(lang)
            .stream()
            .map(v -> Tv.createTv(v))
            .toList();
    }
    
}

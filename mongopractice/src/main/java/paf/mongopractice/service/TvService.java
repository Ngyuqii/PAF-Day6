package paf.mongopractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.mongopractice.model.Tv;
import paf.mongopractice.repository.TvRepository;

@Service
public class TvService {

    @Autowired
    private TvRepository tvRepo;

    public List<Tv> findTvShowsByLanguage(String lang) {
        return tvRepo.findShowsByLanguage(lang)
            .stream()
            .map(v -> Tv.create(v))
            .toList();
    }
    
}

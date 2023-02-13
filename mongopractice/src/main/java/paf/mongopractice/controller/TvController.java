package paf.mongopractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.mongopractice.model.Tv;
import paf.mongopractice.service.TvService;

@Controller
@RequestMapping("/tvshow")
public class TvController {

    @Autowired
    private TvService tvSvc;

    //Get /tvshow?lang=English
    @GetMapping
    public String findShowsByLanguage (@RequestParam(defaultValue = "English") String lang, Model model) {

        List<Tv> results = tvSvc.findTvShowsByLanguage(lang);
        model.addAttribute("tvshows", results);
        model.addAttribute("language", lang);

        return "tv";

    }
    
}

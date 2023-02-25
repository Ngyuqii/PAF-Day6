package paf.mongopractice2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.mongopractice2.model.Tv;
import paf.mongopractice2.service.TvService;

@Controller
@RequestMapping(path="/")
public class TvController {

    @Autowired
    private TvService tvSvc;

    // GET index
    @GetMapping
    public String getIndex(Model model) {
        List<String> showTypes = tvSvc.getAllTypes();
        model.addAttribute("showTypes", showTypes);
        return "index";
    }

    // GET /tvshow/type/{type}
	 @GetMapping(path="/tvshow/type/{type}")
	 public String getTvShowByType(@PathVariable String type, Model model) {
		 List<Tv> results = tvSvc.findShowsByType(type);
		 model.addAttribute("tvshows", results);
		 model.addAttribute("showType", type);
		 return "tvshowsbytype";
	 }

    //Get /tvshow?lang=English
    @GetMapping(path="/tvshow")
    public String findShowsByLanguage (@RequestParam(defaultValue = "English") String lang, Model model) {

        List<Tv> results = tvSvc.findTvShowsByLanguage(lang);
        model.addAttribute("tvshows", results);
        model.addAttribute("language", lang);

        return "tv";

    }
    
}

package studyhours.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import studyhours.backend.model.person;
import studyhours.backend.model.entry;
import studyhours.backend.model.entryRepository;
import studyhours.backend.model.personRepository;

@Controller
public class entryController {
        //bring entryRepository to controller
        @Autowired
        private entryRepository repository;
        //bring also personRepository to controller
        @Autowired
        private personRepository erepository;

        //show all hours input
        @RequestMapping("entrylist")
        public String showIndexPage(Model model) {
                model.addAttribute("entries", repository.findAll());
                return "entrylist";
        }

}

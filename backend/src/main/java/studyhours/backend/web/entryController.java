package studyhours.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import studyhours.backend.model.person;
import studyhours.backend.model.entry;
import studyhours.backend.model.entryRepository;
import studyhours.backend.model.personRepository;
import org.springframework.web.bind.annotation.RequestParam;


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

        //add new hour entry
        @RequestMapping("addentry")
        public String addEntry(Model model) {
                model.addAttribute("entry", new entry());
                model.addAttribute("persons", erepository.findAll());
                return "addentry";
        }

        //save hour entry
         @RequestMapping(value="/save", method = RequestMethod.POST)
         public String save(entry entry) {
                 repository.save(entry);
                 return "redirect:entrylist";
         }
        // delete hour entry if you are admin user
         @PreAuthorize("hasAuthority('ADMIN')")
         @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
         public String deleteEntry(@PathVariable("id") Long entryId, Model model) {
                     repository.deleteById(entryId);
                 return "redirect:../entrylist";
         }
          //edit hour entry available for all user roles
          @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
          public String editEntry(@PathVariable("id") Long Id, Model model) {
                  model.addAttribute("edit", repository.findById(Id));
                  model.addAttribute("persons", erepository.findAll());
                  return "editentry";
         
         }



        

}

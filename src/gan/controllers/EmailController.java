package gan.controllers;

import gan.models.Emails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Ganon on 2/5/2017.
 */
@Controller
@RequestMapping(value = "/")
public class EmailController {

    @Autowired
    public EmailController(){
        what();
    }

    @ModelAttribute("emails")
    public Emails what(){
        return new Emails(" ");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("emails", new Emails(" "));
        return "index";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String submit(@ModelAttribute("emails")Emails emails,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("emails", emails);

        return "index";
    }
}

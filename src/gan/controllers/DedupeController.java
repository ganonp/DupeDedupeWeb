package gan.controllers;
import gan.dedupe.Dedupe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import gan.test.EmailListGenerator;
import gan.models.Emails;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Ganon on 2/4/2017.
 */
@Controller
@RequestMapping(value = "/emails")
public class DedupeController {
    EmailListGenerator emailGenerator = new EmailListGenerator();
    Dedupe dedupe = new Dedupe();
    int numEmailsToGenerate = 10000;

    @RequestMapping(params = "dedupe", method = RequestMethod.POST)
    public String dedupeEmails(String emails, Model model) {
        Emails dupedEmails = new Emails(emails);
        long startTime = System.nanoTime();
        String[] dedupedEmails = dedupe.dedupeEmailList(dupedEmails.getEmailsArray());
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/(long)1000000 ;
        model.addAttribute("emails", dupedEmails);
        model.addAttribute("originalEmails", dupedEmails.getEmailsArray());
        model.addAttribute("dedupedEmails", dedupedEmails);
        model.addAttribute("duration",duration);
        return "index";
    }

    @RequestMapping(params = "generate", method = RequestMethod.POST)
    public String generateEmails(Model model) {

        String[] emailsWithDupes = emailGenerator.generateRandomEmailListWithDupes(numEmailsToGenerate);
        Emails dupedEmails = new Emails(emailsWithDupes);
        model.addAttribute("emails", dupedEmails);
        return "index";
    }
}

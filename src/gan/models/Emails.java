package gan.models;

import java.util.Arrays;

/**
 * Created by Ganon on 2/5/2017.
 */
public class Emails {
    private String[] emailsArray;
    private String emails;

    public Emails(String[] emailsArray){
        this.emailsArray = emailsArray;
        emails = emailsArrayToString(emailsArray);
    }

    public Emails(String emails){
        this.emails = emails;
        emailsArray = emailsStringToArray(emails);

    }

    public Emails(){
        emails = "";
        emailsArray = new String[]{""};
    }

    public String emailsArrayToString(String[] emailsArray){
        String emailString = Arrays.toString(emailsArray);
        return emailString;
    }

    public String[] emailsStringToArray(String emails){
        String[] emailsArray = emails.split(",");
        return emailsArray;
    }

    public String getEmails() {
        return emails;
    }

    public String[] getEmailsArray() {
        return emailsArray;
    }

    public void setEmailsArray(String[] emailsArray) {
        this.emailsArray = emailsArray;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }
}

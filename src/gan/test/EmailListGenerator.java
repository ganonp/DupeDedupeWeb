package gan.test;
import java.util.Random;

/**
 * Created by Ganon on 1/31/2017.
 */
public class EmailListGenerator {
    static Random random = new Random();
    static String email;
    static String[] emailList;

    static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers = "0123456789";
    static String specialChars = "!#$%&'*+-/=?^_`{|}~";
    static char hyphen = '-';
    static char dot = '.';

    /**
     * Uppercase and lowercase English letters (a-z, A-Z)
     Digits 0 to 9
     Characters ! # $ % & ' * + - / = ? ^ _ ` { | } ~
     Character . (dot, period, full stop) provided that it is not the first or last character, and provided also that it does not appear two or more times consecutively.
     */
    static String[] exampleUserNames = new String[]{"Omega_3","cReMe.freIcHe!","Sous-vide","~20minutes","good.Cholesterol?"};
    static String userName;


    /**
     * The domain name part of an email address has to conform to strict guidelines: it must match the requirements for a hostname, a list of dot-separated DNS labels, each label being limited to a length of 63 characters and consisting of:[7]
     uppercase and lowercase Latin letters A to Z and a to z;
     digits 0 to 9, provided that top-level domain names are not all-numeric;
     hyphen -, provided that it is not the first or last character.
     */
    static String[] exampleDomains = new String[]{"3-minute-egg.net","Chia.sed","Maillard.xxx","red.onion","jamie-oliver.edu","450.deg"};
    static String domain;
    static String topLevelDomain;

    private static String generateRandomUserName(){
        int userNameLength = random.nextInt(25);
        userName = "";
        String userNameChars = letters + numbers + specialChars;
        userName = userName + userNameChars.charAt(random.nextInt(userNameChars.length()));
        userNameChars = userNameChars + dot;
        for(int i = 0; i < userNameLength - 1;i++){
            userName = userName + userNameChars.charAt(random.nextInt(userNameChars.length()));
        }
        userNameChars = letters + numbers + specialChars;
        userName = userName + userNameChars.charAt(random.nextInt(userNameChars.length()));
        return userName;

    }

    private static String generateRandomDomain(){
        int domainLength = random.nextInt(8);
        domain = "";
        String domainChars = letters + numbers;
        domain = domain + domainChars.charAt(random.nextInt(domainChars.length()));
        domainChars = domainChars + hyphen;
        for(int i = 0; i < domainLength - 1;i++){
            domain = domain + domainChars.charAt(random.nextInt(domainChars.length()));
        }
        if(domain.contains("[a-zA-Z]")){
            domainChars = letters + numbers;
        }else{
            domainChars = letters;
        }
        domain = domain + domainChars.charAt(random.nextInt(domainChars.length()));
        return domain;
    }

    private static String generateRandomTopLevelDomain(){
        int topLevelDomainLength = 3;
        topLevelDomain = "";
        for(int i = 0; i < topLevelDomainLength; i++){
            topLevelDomain = topLevelDomain + letters.charAt(random.nextInt(letters.length()));
        }
       return topLevelDomain;
    }

    public static String generateRandomEmail(){
        email = generateRandomUserName() + "@" + generateRandomDomain() + "." + generateRandomTopLevelDomain();
        return email;
    }

    public static String[] generateRandomEmailListWithDupes(int numEmails){
        emailList = new String[numEmails];
        emailList[0] = generateRandomEmail();
        for(int i = 1; i < numEmails; i++){
            if(random.nextInt(numEmails) < i){
                emailList[i] = emailList[random.nextInt(i-1)];
            }else{
                emailList[i] = generateRandomEmail();
            }
        }
        return emailList;
    }

}

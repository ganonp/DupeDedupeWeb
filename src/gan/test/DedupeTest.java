package gan.test;
import gan.dedupe.Dedupe;

/**
 * Created by Ganon on 1/31/2017.
 */
public class DedupeTest {
    Dedupe deduper = new Dedupe();
    EmailListOrderComparator dedupeChecker = new EmailListOrderComparator();

    public void generateDupeEmailsListDedupeAndCheck(){
        String[] originalEmailList = EmailListGenerator.generateRandomEmailListWithDupes(100000);
        String[] dedupedEmailList = deduper.dedupeEmailList(originalEmailList);
        dedupeChecker.isOrderedAndDedupedCorrectly(originalEmailList, dedupedEmailList);
    }

    public static void main(String[] args){
        new DedupeTest().generateDupeEmailsListDedupeAndCheck();
    }

}

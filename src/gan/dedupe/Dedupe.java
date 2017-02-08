package gan.dedupe;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Ganon on 1/31/2017.
 */
public class Dedupe {
    String[] originalEmailList;
    String[] dedupedEmailList;
    HashSet<String> occurred;


    public String[] dedupeEmailList(String[] originalEmailList){
        this.originalEmailList = originalEmailList;
        dedupeEmailList();
        return dedupedEmailList;
    }

    public String[] dedupeEmailList(){
        occurred = new HashSet<>();
        ArrayList<String> deduped = new ArrayList<>();
        for(int i = 0; i < originalEmailList.length; i++){
            if(!occurred.contains(originalEmailList[i])){
                deduped.add(originalEmailList[i]);
                occurred.add(originalEmailList[i]);
            }
        }
         deduped.trimToSize();
        dedupedEmailList = new String[deduped.size()];
        dedupedEmailList = deduped.toArray(dedupedEmailList);
        return dedupedEmailList;

    }

}

package gan.test;
import java.util.HashMap;

/**
 * Created by Ganon on 1/31/2017.
 */
public class EmailListOrderComparator {
    String[] originalEmailList;
    String[] dedupdEmailList;
    HashMap<String,Integer> originalEmailListFirstIndex = new HashMap<>();

    public boolean isOrderedAndDedupedCorrectly(String[] originalEmailList, String[] dedupdEmailList){
        this.originalEmailList = originalEmailList;
        this. dedupdEmailList = dedupdEmailList;
        return isOrderedAndDedupedCorrectly();
    }

    public boolean isOrderedAndDedupedCorrectly(){
        int dedupeInd = 0;
        for(int originalInd = 0; originalInd < originalEmailList.length; originalInd++){
            if(!originalEmailListFirstIndex.containsKey(originalEmailList[originalInd])){
                originalEmailListFirstIndex.put(originalEmailList[originalInd],originalInd);
            }
            if(originalEmailList[originalInd].equals(dedupdEmailList[dedupeInd])){
                System.out.println("Original[" + originalInd + "]: " + originalEmailList[originalInd] + "         Dedupe[" + dedupeInd + "]: " + dedupdEmailList[dedupeInd]);
                dedupeInd++;
                if(dedupeInd >= dedupdEmailList.length){
                    return true;
                }
            }else{
                if(originalEmailListFirstIndex.containsKey(originalEmailList[originalInd])){
                    System.out.println("Original[" + originalInd + "]: " + originalEmailList[originalInd] + " duped from Original[" + originalEmailListFirstIndex.get(originalEmailList[originalInd]) + "]");

                    if(originalEmailListFirstIndex.get(originalEmailList[originalInd]) >= originalInd){
                        System.out.println("Original[" + originalInd + "]: " + originalEmailList[originalInd] + " Incorrect dupe kept from Original[" + originalEmailListFirstIndex.get(originalEmailList[originalInd]) + "]");

                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        if(dedupeInd < dedupdEmailList.length){
            System.out.println("something is wrong");
            return false;
        }
        else{
            return true;
        }
    }



}

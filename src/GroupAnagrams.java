import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public static void main(String[] args){
        try{
            GroupAnagrams obj = new GroupAnagrams();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> indexesToAddWordsTo = new HashMap<>();
        int currentIndex = 0;
        List<List<String>> finalList = new ArrayList<>();
        for(int x=0;x<strs.length;x++){
            char[] currentStringArray = strs[x].toCharArray();
            int[] signatureArray = new int[26];
            for(int y=0;y<currentStringArray.length;y++){
                int currentCharacter = Character.getNumericValue(currentStringArray[y]) - 10;
                signatureArray[currentCharacter]++;
            }
            String finalSignature = Arrays.toString(signatureArray);
            if(indexesToAddWordsTo.containsKey(finalSignature)){
                finalList.get(indexesToAddWordsTo.get(finalSignature)).add(strs[x]);
            }else{
                indexesToAddWordsTo.put(finalSignature,currentIndex);
                List<String> newList = new ArrayList<>();
                finalList.add(newList);
                currentIndex++;
                finalList.get(indexesToAddWordsTo.get(finalSignature)).add(strs[x]);
            }
        }
        return finalList;
    }
}
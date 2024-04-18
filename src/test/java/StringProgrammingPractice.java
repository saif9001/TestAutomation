import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringProgrammingPractice {

    int a = 5;
    String s = "Saif";


    public void findDuplicatesInString(String sampleString) {

        Character duplicates = null;
        int duplicatesCount = 0;
        boolean duplicateCharexist = false;

        if (sampleString.equals(null) || sampleString.equals("")) {
            System.out.print("String is empty or Null");
            return;
        }
        for (int i = 0; i < sampleString.length(); i++) {
            for (int j = i + 1; j < sampleString.length(); j++) {
                if (sampleString.charAt(j) == sampleString.charAt(i)) {
                    duplicateCharexist = true;
                    duplicatesCount++;
                    duplicates = sampleString.charAt(j);

                }
            }

            if (duplicateCharexist == true & duplicatesCount > 0) {

                System.out.println("Duplicates characters are " + duplicates + ":" + duplicatesCount);
            }
            duplicatesCount = 0;

        }
        if (duplicateCharexist == false) {
            System.out.println("Duplicate doesn't exist");
        }
    }


    public char findMaximumOccuringChar(String sampleString) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

        int maxCount = 0;
        char maxchar = 0;

        for (int i = 0; i < sampleString.length(); i++) {
            if (!chars.containsKey(sampleString.charAt(i))) {
                chars.put(sampleString.charAt(i), 1);
            } else {
                //int value=chars.get(sampleString.charAt(i));
                chars.put(sampleString.charAt(i), chars.get(sampleString.charAt(i)) + 1);

            }

        }
        for (Map.Entry<Character, Integer> ch : chars.entrySet()) {
            if (ch.getValue() > maxCount) {
                maxCount = ch.getValue();
                maxchar = ch.getKey();
            }

        }

        return maxchar;
    }

    public String reversedString(String sampleString) {


        String reversed = "";

        for (int i = sampleString.length() - 1; i >= 0; i--) {
            reversed = reversed + sampleString.charAt(i);
        }
        return reversed;

    }

    public String reverseStringWord(String sampleString) {
        String rev = "";
        String[] reversed = sampleString.split(" ");
        for (int i = reversed.length - 1; i >= 0; i--) {
            rev = rev + reversed[i] + " ";
        }
        return rev;
    }
    
    public int findNumberOfWords(String sampleString){
        
        String[] s=sampleString.split("[ /n/t]+");
        
        return s.length;
    }
    
    public String removeSpecifiedChar(String sampleString, char inputchar){
        String removedchar="";
        for(int i=0;i<sampleString.length();i++){
            if(sampleString.charAt(i)!=inputchar){
                removedchar=removedchar+sampleString.charAt(i);
            }
        }
        return removedchar;
    }
    
    public boolean checkIfStringsAreAnagram(String a, String b){
         int charCount=0;
        boolean isAnagram=false;
        if(a.length()!=b.length()){
            isAnagram= false;
        }
        else{
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    if (b.charAt(j) == a.charAt(i)) {
                        charCount++;
                    }
                }
                if (charCount!= 1 || charCount>1) {
                    isAnagram=false;
                    break;
                    
                } else {
                    charCount = 0;
                    isAnagram=true;
                }
            }
        }
        return isAnagram;
        
    }


    public static void main(String[] args) {
        String inputString = "Saifs";
        StringProgrammingPractice stringProgrammingPractice = new StringProgrammingPractice();
        boolean s=stringProgrammingPractice.checkIfStringsAreAnagram("rat", "tar");
        System.out.println(s);
    }

    public static String generateRandomString(int length) {
        final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHA_NUMERIC_STRING.length());
            stringBuilder.append(ALPHA_NUMERIC_STRING.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }
}

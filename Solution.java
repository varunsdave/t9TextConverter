import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader; 

public class Solution {
    private static HashMap<Character, String> digitToLettersMap;
    private static Set<String> dict;
    public static ArrayList<String> letterCombinations(String digits) {
        setupHasMap();
       
        ArrayList<String> listOfWords
            = new ArrayList<String>();
         if (digits.charAt(0)=='1'){
            return new ArrayList<String>(); 
        }
        findWords(digits, 0, new String(), listOfWords);
        return listOfWords;
    }
     
    private static void findWords(String digits, int start, 
        String sol, ArrayList<String> solutions) {
        if(sol.length() > digits.length()) {
            return;  
        } else if(sol.length() == digits.length()) {
            if (dict.contains(sol)){
                solutions.add(sol);
            }
            return;
        } else {
           
            for(int i = start; i < digits.length(); i++) {
                String letters = digitToLettersMap.get(digits.charAt(i));
                for(int j = 0; j < letters.length(); j++) {
                    findWords(digits, i + 1, sol + letters.charAt(j), solutions);
                }
            }
        }
    }
     
    private static void setupHasMap() {
        digitToLettersMap = new HashMap<Character, String>();
        digitToLettersMap.put('1', "");
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
        digitToLettersMap.put('0', " ");
    }
    
    public static void main(String [] args){
        if (args.length != 1){
            System.out.println("Please supply file a .txt file name");
            return;
        }
        try{
            File file =new File(args[0]);
            dict = new HashSet<String>();
            FileReader dictionaryReader = new FileReader(file);
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String line;
           
            while ((line = br.readLine()) != null) {
                dict.add(line);
           }
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }
     
        
        ArrayList<String> answer = letterCombinations("228");
        for(String s: answer){
            System.out.println(s);
        }
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;


/**
 *
 * @author iTEC
 */
public class CountConditions {
    private String code;
    private String split;
    private int increment;
    
    public CountConditions(String code, String split, int increment) {
        
        this.code = code; //variable to get the code
        this.split = split; //variable to get split word
        this.increment = increment; //variable to get increment value
    }
    
    public int getCount() {
        
        int count = 0; //variable to store complexity value
        
        String[] words = code.split(split); //split words using given word
        
        //get rest words one by one
        for (int i = 0; i < words.length; i++) {
            
            words[i] = words[i] + "zz"; //add dummy value to get rid from IndexOutOfBounds exception

            //get given statements which only have brackets next to it
            if (words[i].charAt(0) == '(' || words[i].charAt(1) == '(') {
                
                count = count + increment; //increment count using given value
                
                //get content inside brackets using a stack
                InsideBrackets brackets = new InsideBrackets(words[i]);
                String get = brackets.getRound();
            
                //read content inside brackets one by one
                for (int j = 0; j < get.length() - 1; j++) {

                    //read bitwise operators
                    if ((get.charAt(j) == '&' && get.charAt(j+1) != '&') || (get.charAt(j) == '|' && get.charAt(j+1) != '|')) {

                        count = count + increment;
                    }
                    //read logical operators
                    if ((get.charAt(j) == '&' && get.charAt(j+1) == '&') || (get.charAt(j) == '|' && get.charAt(j+1) == '|')) {

                        count = count + increment;
                    }
                    //prevent counting second character from logical operators
                    if ((get.charAt(j) == '&' && get.charAt(j+1) == '&') || (get.charAt(j) == '|' && get.charAt(j+1) == '|')) {

                        j++; //increase index by 1
                    }
                }
            }
        }
        return count; //return counted value
    }
    
    public int getCountForCatch() {
        
        int count = 0; //variable to store complexity value
        
        String[] words = code.split(split); //split words using given word
        
        //get rest words one by one
        for (int i = 0; i < words.length; i++) {
            
            words[i] = words[i] + "zz"; //add dummy value to get rid from IndexOutOfBounds exception
            
            //get for words which only have brackets next to it
            if (words[i].charAt(0) == '(' || words[i].charAt(1) == '(') {
                
                count = count + increment; //increment count
            }
        }
        
        return count;
    }
}

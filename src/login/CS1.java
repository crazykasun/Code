/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kasun
 */
public class CS1 {
    
    String fileContent;
    
    public CS1(String code) {
        
        this.fileContent = code;
    }
    
    public int getCs() {
        
        fileContent = fileContent.replaceAll("\".*\"", ""); //remove double quotes
        fileContent = fileContent.replaceAll("\\'.*?\\'", ""); //remove single quotes
        fileContent = fileContent.replaceAll("//.*?\n", ""); //remove single line comments
        fileContent = fileContent.replaceAll("/\\*(.|\n)*?\\*/", ""); //remove multi-line comments
        
            int count = 0;
            int count1 = 0;
                 
            //Checking for Numerical values
            Pattern pattern = Pattern.compile("\\d+");
            Matcher m = pattern.matcher(fileContent);
                
            while (m.find()) {//Numerical values found
                ++count;
            }
             
            //Checking for Strings between double quotes
            Pattern p3 = Pattern.compile("\"([^\"]*)\"");
            Matcher m3 = p3.matcher(fileContent);
                
            while (m3.find()) {//String between double quotes found
                ++count;
            }
        
            //Checking for Array Names
            String[] checkBrackets = fileContent.split("]");
        
            for (int i = 0; i < checkBrackets.length; i++) {//Array Name found
                ++count1;
            }
        
            count1 = count1 - 1;
            count = count + count1;
             
            //Checking for keyword and Manipulators                
            String[] keywordArray = new String[] {"abstract", "break", "byte", "case", "catch", "assert", "char", "class", "continue", "default", "do", "do while", "double", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "long", "native", "package", "String", "short", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "asm", "auto", "bool", "const", "const_cast", "delete", "dynamic_cast", "explicit", "export", "extern", "false", "friend", "goto", "inline", "mutable", "namespace", "operator", "register", "reinterpret_cast", "signed", "sizeof", "static_cast", "struct", "template", "true", "typedef", "typeid", "typename", "union", "unsigned", "using", "virtual", "wchar", "System", "out", "int", "string"};
            for (int i = 0; i < keywordArray.length; i++) { //Iterate through the keyword array, while checking

                String keywordToSearch = keywordArray[i];
                int countWord = 0;
                String tempStr = new String(fileContent); //Create a new string out of "fileContent" because "TempStr" will be split

                while (tempStr.indexOf(keywordToSearch) >= 0) {//Keyword or Manipulator found
                    countWord++;

                    //Split the tempStr to avoid searching again on the already searched section
                    tempStr = tempStr.substring(tempStr.indexOf(keywordToSearch) + keywordToSearch.length());
                }
                count = count + countWord;
            }
            
            //Checking for method
            Pattern p5 = Pattern.compile("(public)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(private)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(protected)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(static)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(final)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(abstract)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(synchronized)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]|(volatile)\\s*(\\w+)\\s*(\\w+)\\s*(\\w*)\\s*[(]]");
            Matcher m5 = p5.matcher(fileContent);
            
            while(m5.find()){
                count++;
            }

            //Checking for object
            Pattern p7 = Pattern.compile("new ");
            Matcher m7 = p7.matcher(fileContent);
            
            while(m7.find()){
                count++;
            }
            
            //Checking for Collection name
            Pattern p15 = Pattern.compile("(<)\\s*(\\w+)\\s*(>)\\s*(\\w)");
            Matcher m15 = p15.matcher(fileContent);
            
            while(m15.find()){
                count++;
            }
            
            //Checking for variable Java / C++
            Pattern p6 = Pattern.compile("(int)\\s+(\\w+)|(float)\\s+(\\w+)|(double)\\s+(\\w+)|(String)\\s+(\\w+)|(string)\\s+(\\w+)|(boolean)\\s+(\\w+)|(bool)\\s+(\\w+)|(byte)\\s+(\\w+)|(char)\\s+(\\w+)|(long)\\s+(\\w+)|(short)\\s+(\\w+)");
            Matcher m6 = p6.matcher(fileContent);
            
            while(m6.find()){
                count++;
            }
            
            return count;
    }
}

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
public class Inheritence {
    
    String fileContent;
    
    public Inheritence(String code) {
        
        this.fileContent = code;
    }

    public int getInheritence() {

            int total = 2;//Any Parent class has a complexity of 2 due to Inheritance from the Object, Because (Inheritance = number of ancestors + 1)

            //Complexity due to Inheritance of a C++ code
            Pattern p1 = Pattern.compile(" : public");
            Matcher m1 = p1.matcher(fileContent);
            
            Pattern p8 = Pattern.compile(" : protected");
            Matcher m8 = p8.matcher(fileContent);
            
            Pattern p9 = Pattern.compile(" : private");
            Matcher m9 = p9.matcher(fileContent);
            
            Pattern p10 = Pattern.compile(" : abstract");
            Matcher m10 = p10.matcher(fileContent);
            
            Pattern p11 = Pattern.compile(" : static");
            Matcher m11 = p11.matcher(fileContent);
            
            Pattern p12 = Pattern.compile(" : final");
            Matcher m12 = p12.matcher(fileContent);
            
            Pattern p13 = Pattern.compile(" : synchronized");
            Matcher m13 = p13.matcher(fileContent);
            
            Pattern p14 = Pattern.compile(" : volatile");
            Matcher m14 = p14.matcher(fileContent);
        
            while(m1.find()|m8.find()|m9.find()|m10.find()|m11.find()|m12.find()|m13.find()|m14.find()){//C++ child found
                total = total + 1;
            }
        
            //Complexity due to Inheritance of a Java code
            Pattern p2 = Pattern.compile(" extends ");
            Matcher m2 = p2.matcher(fileContent);        
            
            while(m2.find()){//Java child found
                total = total + 1;
            }

            return total;
    }
    
}


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
public class CodeRefactor {
    
    private String sourceCode;
    
    public CodeRefactor(){
        
    }
    
    public String commentOmmitter(String sourceCode){
        this.sourceCode = sourceCode;
        return sourceCode.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
    }
    
    public String bracketInsideOmmitter(String sourceCode){
        String appender = "";
        boolean indicator = true;
        LevelRetriever quoteScope = new LevelRetriever();
        
        for(int i = 0; i < sourceCode.length(); i++){
            //get the character
            char position = sourceCode.charAt(i);
            
            if(indicator){
                //adding character to appender
                appender = appender + position;
                //check for string literals
                if(position == '('){
                    quoteScope.insertFirst(i, position);
                    indicator = false;
                }
            }else{
                if(position=='('){
                    quoteScope.insertFirst(i, position);
                }
                if(position == ')'){
                    quoteScope.deleteFirst();
                    if(quoteScope.isEmpty()){
                        indicator = true;
                        appender = appender+position;
                    }
                }
            }
        }
        return appender;
    }
    
    //to get rid of this - '}' and this - '{'
    public String singleQuotesOmmitter(String sourceCode){
        String appender = "";
        boolean indicator = true;
        
        for(int i = 0; i < sourceCode.length(); i++){
            //get the character
            char position = sourceCode.charAt(i);
            
            if(indicator){
                //adding character to appender
                appender = appender + position;
                //check for string literals
                if(position == '\''){
                    indicator = false;
                }
            }else{
                if(position == '\''){
                    indicator = true;
                    appender = appender+position;
                }
            }
        }
        return appender;
    }
    
    public String stringOmmitter(String sourceCode){
        this.sourceCode = sourceCode;
        String appender = "";
        
        //indicater indicate to append or not
        boolean indicator = true;
        
        for(int i = 0; i < sourceCode.length(); i++){
            //get the character
            char position = sourceCode.charAt(i);
            
            if(indicator){
                //adding character to appender
                appender = appender + position;
                //check for string literals
                if(position == '"'){
                    indicator = false;
                }
            }else{
                if(sourceCode.charAt(i-1)!='\\'){
                    if(position == '"'){
                        indicator = true;
                        appender = appender+position;
                    }
                }
            }
            
        }
        
        return appender;
    }
    
    public String tryCatchOmitter(String sourceCode){
        //will return string without try catch
        String refacteredCode = "";
        int i = 0;
        //when try or catch is found this will look for related }
        boolean checkForClose = false;
        
        //level retriever for catch scop
        LevelRetriever scope = new LevelRetriever();
        boolean start = false;
        //looping through the content
        for(;i<sourceCode.length();i++){
            //get the position
            char pos = sourceCode.charAt(i);
            //String checking for try catch statement
            String tryCatchChecker = functionChecker(sourceCode, i);
            
            //if try or catch is found 
            if(tryCatchChecker.contains("try") || tryCatchChecker.contains("catch")){
                //need to find where the closest {
                i = skipUnWanted(sourceCode, i);
                //now variable became true
                //now need attention to skip the scope of try or catch
                checkForClose = true;
            }else{
                //when this is true only
                if(checkForClose){
                    if(start){
                        if(pos == '{'){
                            scope.insertFirst(i, pos);
                        }
                    }
                    //need to skip }
                    if(pos == '}'){
                        String checkCatch = functionChecker(sourceCode, i);
                        if(start && !scope.isEmpty()){
                            scope.deleteFirst();
                        }
                        if(!checkCatch.contains("catc")){
                            if(!start){
                                refacteredCode = refacteredCode+pos;
                            }else{
                                if(!scope.isEmpty()){
                                    refacteredCode+=pos;
                                }
                                
                                if(scope.isEmpty()){
                                    start = false;
                                }
                                
                            }
                        }else if(checkCatch.contains("catc")){
                            start = true;
                            i=skipUnWanted(sourceCode, i);
                            System.err.println("char at : " + sourceCode.charAt(i));
                        }
                    }else{
                        //if not the character == }
                        refacteredCode = refacteredCode+pos;
                    }
                }else{
                    //all the other time code has to append without considering }
                    refacteredCode = refacteredCode+pos;
                }
            }
        }
        
        return refacteredCode;
    }
    
    //used to get closest {
    private int skipUnWanted(String sourceCode, int i) {
        
        while(sourceCode.charAt(i) != '{'){
            i++;
        }
        
        return i;
    }
    
    //returns String with maximum 5 letters
    public String functionChecker(String sourceCode, int i){
        String appender="";
        if((i+5) > sourceCode.length()){
            for(int j=i; j < sourceCode.length();j++){
                char pos = sourceCode.charAt(j);
                appender = appender+pos;
            }  
        }else{
            for(int j=i; j < i+5;j++){
                char pos = sourceCode.charAt(j);
                appender = appender+pos;
            }
        }
        
        return appender;
    }
}

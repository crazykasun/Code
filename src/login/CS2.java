/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

/**
 *
 * @author kasun
 */
public class CS2 {
    
    String code;
    
    public CS2(String code) {
        
        this.code = code;
    }
    
    public int getCs() {
        
        code = code.replaceAll("\".*\"", ""); //remove double quotes
        code = code.replaceAll("\\'.*?\\'", ""); //remove single quotes
        code = code.replaceAll("//.*?\n", ""); //remove single line comments
        code = code.replaceAll("/\\*(.|\n)*?\\*/", ""); //remove multi-line comments
               
        //Convert the code from String to char array
        char[] chars = code.toCharArray();
        
        //initialize cs value
        int cs = 0;

        //Take three values to check nearby three indexes
        int first;
        int match = 1;
        int next = 2;
        
        //Go through the array by index to index
        for (first = 0; first < chars.length; first++) {
            if (match <= chars.length-1){
                //Check ~ , .
                if(chars[first] == '~' || chars[first] == ',' || chars[first] == '.') {
                    cs++;
                }
                             
                //Check ::
                if(chars[first] == ':' && chars[match] == ':') {
                    cs++;
                }
                
                //Check ^
                if(chars[first] == '^' && chars[match] != '=') {
                    cs++;
                }
                
                //Check ^=
                if (chars[first] == '^' && chars[match] == '='){
                    cs++;
                    //replace ^=  to take as =
                    chars[match] = '6';
                }
                
                //Check &&
                if(chars[first] == '&' && chars[match] == '&') {
                    cs++;
                }
              
                //Check &=
                if(chars[first] == '&' && chars[match] == '=') {
                    cs++;
                    chars[match] = 'a';

                }

                //Check Reference
                if(chars[first] == '&' && Character.isLetter(chars[match])) {
                    cs = cs + 2;
                } 
                
                //Check Dereference
                if(chars[first] == '*' && Character.isLetter(chars[match])) {
                    cs = cs + 2;
                }
                //Check !
                if(chars[first] == '!' && chars[match] != '=') {
                    cs++;
                }
              
                //Check !=
                if (chars[first] == '!' && chars[match] == '='){
                    cs++;
                    chars[match] = 'a';
                }
                 
                //Check /
                if(chars[first] == '/' && chars[match] != '=') {
                    cs++;
                }
              
                //Check /=
                if(chars[first] == '/' && chars[match] == '=') {
                    cs++;
                    chars[match] = 'a';
                }
                
                //Check %
                if(chars[first] == '%' && chars[match] != '=') {
                    cs++;
                }
              
                //Check %=
                if(chars[first] == '%' && chars[match] == '=') {
                    cs++;
                    chars[match] = 'a';
                }
                
                //Check *
                if((chars[first] == '*' && chars[match] == ' ') ) {
                    cs++;
                }
              
                //Check *=
                if (chars[first] == '*' && chars[match] == '='){
                    cs++;
                    chars[match] = 'a';

                }
                
                //Check +
                if(chars[first] == '+' && chars[match] != '+' && chars[match] != ' ') {
                    cs++;
                }
                
                //Check ++
                else if (chars[first] == '+' && chars[match] == '+'){
                    cs++;
                    //pass the index to avoid ++ as +
                    first++;
                    match++;
                }
              
                //Check +=
                else if (chars[first] == '+' && chars[match] == '='){
                    cs++;
                   
                    //pass the index to avoid += as +
                    chars[match] = 'a';
                }
                
                //Check |
                if(chars[first] == '|' && chars[match] != '|' && chars[match] == ' ') {
                    cs++;
                }
                
                //Check ||
                else if (chars[first] == '|' && chars[match] == '|'){
                    cs++;
                    first++;
                    match++;
                }
              
                //Check |=
                else if (chars[first] == '|' && chars[match] == '='){
                    cs++;
                    chars[match] = 'a';
                }
                
                //Check -
                if(chars[first] == '-' && chars[match] != '-' && chars[match] == ' ') {
                    cs++;
                }
                
                //Check --
                else if (chars[first] == '-' && chars[match] == '-'){
                    cs++;
                    first++;
                    match++;
                }
              
                //Check -=
                else if (chars[first] == '-' && chars[match] == '='){
                    cs++;
                    chars[match] = 'a';

                }
                
                //Check ->
                else if (chars[first] == '-' && chars[match] == '>'){
                    cs++;
                    chars[match] = 'a';

                }
                
                  //Check =
                if(chars[first] == '=' && chars[match] != '=') {
                    cs++;
                }
                
                //Check ==
                else if(chars[first] == '=' && chars[match] == '=') {
                    cs++;
                    first++;
                    match++;
                }
                
              
                
                //checkin for three indexes
                //Check >
                if(chars[first] == '>' && chars[match] != '>') {
                    cs++;
                }
              
                //Check >=
                else if (chars[first] == '>' && chars[match] == '='){
                    cs++;
                    first++;
                    match++;
                }
                
                //Check >>
                else if (chars[first] == '>' && chars[match] == '>' && chars[next] != '>'){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
              
                //Check >>>
                else if (chars[first] == '>' && chars[match] == '>' && chars[next] == '>'){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
                
                //Check >>=
                else if (chars[first] == '>' && chars[match] == '>' && chars[next] == '='){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
                
                //Check <
                if(chars[first] == '<' && chars[match] != '<') {
                    cs++;
                }
              
                //Check <=
                else if (chars[first] == '<' && chars[match] == '='){
                    cs++;
                    first++;
                    match++;
                }
                
                //Check <<
                else if (chars[first] == '<' && chars[match] == '<' && chars[next] != '<'){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
              
                //Check <<<
                else if (chars[first] == '<' && chars[match] == '<' && chars[next] == '<'){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
                
                //Check <<=
                else if (chars[first] == '<' && chars[match] == '<' && chars[next] == '='){
                    cs++;
                    first = first + 2;
                    match = match + 2;
                }
                
                //increment indexes for the next iteration
                match++;
                next++;
            }
        }

	 //Get total cs value to textfield
        return cs;
    }
}

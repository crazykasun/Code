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
public class Link {
    int increment;
    char value;
    Link next;
    
    public Link(int increment, char value){
        this.increment = increment;
        this.value = value;
        
        this.next = null;
    }
    
    public void displayLink(){
        System.out.println("Increment : " + increment + ", Value : " + value);
    }
}

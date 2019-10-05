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
public class LevelRetriever {
    private Link firstLink;
    
    public LevelRetriever(){
        firstLink = null;
    }
    
    public void insertFirst(int increment, char value){
        Link nLink = new Link(increment, value);
        nLink.next = firstLink;
        firstLink = nLink;
    }
    
    public Link deleteFirst(){
        Link temp = firstLink;
        firstLink = temp.next;
        return temp;
    }
    
    public Link getLevelPeek(){
        return firstLink;
    }
    
    public boolean isEmpty(){
        return (firstLink == null);
    }
    
    public Link getFirst(){
        return firstLink;
    }
}

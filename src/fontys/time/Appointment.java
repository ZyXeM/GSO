/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Niels
 */
public class Appointment {
    
    private String subject;
    private ITimeSpan timeSpan;
    private ArrayList<Contact> contacts;
    /**
     * Get the value of subject
     *
     * @return the value of subject
     */
    public String getSubject() {
        return subject;
    }


    /**
     *
     * @param subject
     * @param timeSpan
     */
    public Appointment(String subject, ITimeSpan timeSpan){
        this.contacts = new ArrayList<Contact>();
        this.subject = subject;
        this.timeSpan = timeSpan;
                
        
    }

    /**
     *
     * @return
     */
    public ITimeSpan getTimeSpan(){
        
        return timeSpan;
    }

    /**
     *
     * @return
     */
    public Iterator<Contact> invitees(){
        return contacts.iterator();
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean addContact(Contact c){
        if(contacts.contains(c)){
            return false;
        }
        else{
            if(!c.addAppointment(this)){
                return false;
            }
            contacts.add(c);
            return true;                           
        }
    }

    /**
     *
     * @param c
     */
    public void removeContact(Contact c){
        c.removeAppointment(this);
        contacts.remove(c);
    }
}

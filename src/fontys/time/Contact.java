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
public class Contact {
    
    private String name;
    private ArrayList<Appointment> agenda;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    public Contact(String name){
        this.name = name;
        agenda = new ArrayList<>();
    }
    protected boolean addAppointment(Appointment a){
        for(Appointment tempApp : agenda){
            if(tempApp.getTimeSpan().intersectionWith(a.getTimeSpan()) != null){
                return false;
            }
        }
        agenda.add(a);
        return true;
    }
    protected void removeAppointment(Appointment a){
        agenda.remove(a);
    }

    /**
     *
     * @return
     */
    public Iterator<Appointment> appointments(){
     return agenda.iterator();   
    }
}

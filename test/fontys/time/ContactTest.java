/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Niels Molmans
 */
public class ContactTest {
    private Contact instance;
    public ContactTest(){
    }
    @BeforeClass
    public static void setUpClass(){
    }
    @AfterClass
    public static void tearDownClass(){
    }
    @Before
    public void setUp(){
        instance = new Contact("Niels");
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testConstructor(){
        assertEquals(instance.getName(), "Niels");
    }     
     @Test
     public void testAddAppointment(){

        Contact contact = new Contact("TestContact");
        System.out.println("Add Appointment Test");
        Appointment a = new Appointment("Test", new TimeSpan(new Time(2016, 9, 20, 10, 20), new Time(2016, 9, 30, 13, 20)));
        Appointment b = new Appointment("Test2", new TimeSpan(new Time(2016, 9, 20, 10, 20), new Time(2016, 9, 30, 13, 20)));
        Appointment c = new Appointment("Test3", new TimeSpan(new Time(2016, 9, 30, 14, 30), new Time(2016, 9, 30, 16, 30)));
        assertTrue(contact.addAppointment(a));
        assertFalse(contact.addAppointment(b));
        assertTrue(contact.addAppointment(c));
     }

     
     @Test
     public void testRemoveAppointment(){
        System.out.println("Remove Appointments Test");
      Appointment appointment1 = new Appointment("Sick", new TimeSpan(new Time(2016, 9, 20, 10, 20), new Time(2016, 9, 30, 13, 20))); 
      instance.addAppointment(appointment1);
      instance.removeAppointment(appointment1);      
     }
     
     @Test
     public void testAppointments(){
        System.out.println("Appointments Test");
        Appointment Appointment1 = new Appointment("Appointment1", new TimeSpan(new Time(2016, 9, 30, 10, 30), new Time(2016, 9, 30, 13, 30)));
        Appointment Appointment2 = new Appointment("Appointment2", new TimeSpan(new Time(2016, 9, 30, 10, 30), new Time(2016, 9, 30, 13, 30)));
        instance.addAppointment(Appointment1);
        instance.addAppointment(Appointment2);
        Iterator<Appointment> appointments = instance.appointments();
        assertTrue(appointments.hasNext());
     }
     
}

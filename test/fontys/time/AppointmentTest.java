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
public class AppointmentTest {
    private Appointment instance;
    
    public AppointmentTest(){
    }
    
    @BeforeClass
    public static void setUpClass(){
    }
    @AfterClass
    public static void tearDownClass(){
    }
    @Before
    public void setUp(){
     instance = new Appointment("Sick", new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)));   
    }
    @After
    public void tearDown(){
    }
    @Test
    (expected=IllegalArgumentException.class)
    public void testConstructorException(){
        System.out.println("Constructor Test With Illegal Argument Exception");
      ITimeSpan aTest = new TimeSpan(new Time(2016,9,20,10,20),new Time(2016,8,10,5,10));
      instance = new Appointment("Sick", aTest);   
  
    }
    @Test
    public void testGetSubject(){
        System.out.println("Get Subject Test");
        assertEquals(instance.getSubject(), "Sick");
        
    }
    @Test
    public void testGetTimeSpan(){
        System.out.println("Get TimeSpan Test");
       assertEquals(instance.getTimeSpan(), new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)));
    }
    @Test
    public void testAddContact(){
        System.out.println("Add Contact Test");
        Contact contact = new Contact("Niels");
        Contact contact2 = new Contact("Mitch");
        
        Appointment appointment1 = new Appointment("Test1", new TimeSpan(new Time(2016, 9, 20, 10, 20), new Time(2016, 9, 30, 13, 20)));
        Appointment appointment2 = new Appointment("Test2", new TimeSpan(new Time(2016, 9, 20, 10, 20), new Time(2016, 9, 30, 13, 20)));
        
        assertTrue(instance.addContact(contact));
        assertFalse(instance.addContact(contact));
        assertTrue(appointment1.addContact(contact2));
        assertFalse(appointment2.addContact(contact2));
    }
    @Test
    public void testRemoveContact(){
        System.out.println("Remove Contact Test");
        Contact contact = new Contact("Niels");
        instance.addContact(contact);
        instance.removeContact(contact);
    }
    
    @Test
    public void testInvitees(){
        System.out.println("Invitees Test");
        Contact contact1 = new Contact("Contact1");
        Contact contact2 = new Contact("Contact2");
        instance.addContact(contact1);
        instance.addContact(contact2);
        Iterator<Contact> contacts = instance.invitees();
        assertTrue(contacts.hasNext());
    }
}

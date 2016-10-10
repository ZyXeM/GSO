/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mitch Kuijpers
 */
public class TimeSpanTest {
    private TimeSpan instance;
    
    public TimeSpanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)); 
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testContructorException()
    {
        instance = new TimeSpan(new Time(2016,9,20,10,20),new Time(2016,8,10,5,10));
    }
    

    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
       
        ITime expResult = new Time(2016,8,10,5,10);
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
       
        ITime expResult = new Time(2016,9,20,10,20);
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);

    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
      
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);

    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        ITime beginTime =new Time(2016,7,10,5,10);
      
        instance.setBeginTime(beginTime);
        assertEquals(instance.getBeginTime(),beginTime);

    }
    
    @Test
    (expected=IllegalArgumentException.class)
        public void testSetBeginTimeException() {
        System.out.println("setBeginTimeException");
        ITime beginTime =new Time(2016,12,10,5,10);
      
        instance.setBeginTime(beginTime);
       fail();

    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime =  new Time(2016,11,10,5,10);
       
        instance.setEndTime(endTime);
        assertEquals(instance.getEndTime(),endTime);

    }
    
    
     @Test
     (expected=IllegalArgumentException.class)
    public void testSetEndTimeException() {
        System.out.println("setEndTimeExeption");
        ITime endTime =  new Time(2016,1,10,5,10);
       
        instance.setEndTime(endTime);
        fail();

    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        TimeSpan moved = new TimeSpan(new Time(2016,8,10,5,15),new Time(2016,9,20,10,25));
        int minutes = 5;
       
        instance.move(minutes);
        assertEquals(moved,instance);

    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 5;
        
       
        instance.changeLengthWith(minutes);
        assertEquals(instance.getEndTime(),new Time(2016,9,20,10,25));

    }
 
    @Test
    (expected=IllegalArgumentException.class)
    public void testChangeLengthWithException() {
        System.out.println("changeLengthWith");
        int minutes = -50000000;
        
       
        instance.changeLengthWith(minutes);
        assertEquals(instance.getEndTime(),new Time(2016,9,20,10,25));

    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,11),new Time(2016,9,20,10,19));
       
        boolean expResult = true;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);

    }
        @Test
    public void testIsPartOf2() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,9),new Time(2016,9,20,10,19));
       
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);

    }
        public void testIsPartOf3() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,19),new Time(2016,9,20,10,21));
       
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);

    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,9),new Time(2016,9,20,10,19));
     
        ITimeSpan expResult = new TimeSpan(new Time(2016,8,10,5,11),new Time(2016,9,20,10,19));
        ITimeSpan result = instance.unionWith(timeSpan);
       
        assertTrue(result.getBeginTime() == expResult.getBeginTime() && result.getEndTime() == expResult.getEndTime());
        
       

    }
     @Test
    public void testUnionWith2() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,11),new Time(2016,9,20,10,21));
     
        ITimeSpan expResult = new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20));
        ITimeSpan result = instance.unionWith(timeSpan);
       
        assertTrue(result.getBeginTime() == expResult.getBeginTime() && result.getEndTime() == expResult.getEndTime());
        
       

    }


    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,9),new Time(2016,8,20,10,19)); 
        
        ITimeSpan expResult = new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)); ;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);

    }
       @Test
    public void testIntersectionWith2() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,8,10,5,11),new Time(2016,9,20,10,21)); 
        
        ITimeSpan expResult = new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)); ;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);

    }
           @Test
    public void testIntersectionWith3() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016,12,10,5,11),new Time(2016,12,20,10,21)); 
        
        ITimeSpan expResult = new TimeSpan(new Time(2016,8,10,5,10),new Time(2016,9,20,10,20)); ;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);

    }
    

    
}

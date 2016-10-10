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
public class TimeTest {
    private Time instance;
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         instance = new Time(2016,9,26,7,52);
    }
    
    @After
    public void tearDown() {
    }
@Test
(expected=IllegalArgumentException.class)
public void testConstructDagException()
{
     instance = new Time(2016,9,32,7,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructMaandException()
{
     instance = new Time(2016,15,26,7,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructUurException()
{
     instance = new Time(2016,9,26,30,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructMinuutException()
{
     instance = new Time(2016,9,26,7,70);
     fail();
}


@Test
(expected=IllegalArgumentException.class)
public void testConstructDagExceptionmin()
{
     instance = new Time(2016,9,-1,7,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructMaandExceptionmin()
{
     instance = new Time(2016,-1,1,7,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructUurExceptionmin()
{
     instance = new Time(2016,9,26,-1,52);
     fail();
}
@Test
(expected=IllegalArgumentException.class)
public void testConstructMinuutExceptionmin()
{
     instance = new Time(2016,9,26,7,-1);
     fail();
}
    /**
     * Test of getDayInWeek method, of class Time.
     */
  
    
    @Test
    public void testMonday()
    {
         System.out.println("getDayInWeek");        
        DayInWeek expResult = DayInWeek.MON;
        DayInWeek result = instance.getDayInWeek();       
        assertEquals("Maandag",expResult, result);
    }
     @Test
    public void testTuesday()
    {
         instance = new Time(2016,9,27,7,52);
        DayInWeek expResult2 = DayInWeek.TUE;
        DayInWeek result2 = instance.getDayInWeek();       
        assertEquals("Dinsdag",expResult2, result2);
    }
     @Test
    public void testWensday()
    {
         instance = new Time(2016,9,28,7,52);
      
                DayInWeek expResult3 = DayInWeek.WED;
        DayInWeek result3 = instance.getDayInWeek();       
        assertEquals("woensdag",expResult3, result3);
    }
     @Test
    public void testThursday()
    {
          instance = new Time(2016,9,29,7,52);
                DayInWeek expResult4 = DayInWeek.THU;
        DayInWeek result4 = instance.getDayInWeek();       
        assertEquals("Donderdag",expResult4, result4);
    }
     @Test
    public void testFriday()
    {
         instance = new Time(2016,9,30,7,52);
                DayInWeek expResult5 = DayInWeek.FRI;
        DayInWeek result5 = instance.getDayInWeek();       
        assertEquals("Vrijdag",expResult5, result5);
    }
     @Test
    public void testSaturday()
    {
         instance = new Time(2016,9,31,7,52);
                DayInWeek expResult6 = DayInWeek.SAT;
        DayInWeek result6 = instance.getDayInWeek();       
        assertEquals("Zaterdag",expResult6, result6);
    }
    @Test
     public void testSunday()
    {
          instance = new Time(2016,10,1,7,52);
                DayInWeek expResult7 = DayInWeek.SUN;
        DayInWeek result7 = instance.getDayInWeek();       
        assertEquals("Zondag",expResult7, result7);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
       
        int expResult = 2016;
        int result = instance.getYear();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
       
        int expResult = 9;
        int result = instance.getMonth();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
     
        int expResult = 26;
        int result = instance.getDay();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
      
        int expResult = 7;
        int result = instance.getHours();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
       
        int expResult = 52;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 5;
       
        ITime expResult = new Time(2016,9,26,7,57);
        ITime result = instance.plus(minutes);
        assertEquals(expResult.getMinutes(), result.getMinutes());
      
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = new Time(2016,9,26,7,52);
       
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);

    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ITime time = new Time(2016,9,26,7,57);
       
        int expResult = 5000;
        int result = instance.difference(time);
        assertEquals(expResult, result);

    }
    
}

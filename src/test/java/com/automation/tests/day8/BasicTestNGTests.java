package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // Runs only once in the class before @beforeMethod and before any test
    // regardless on number of tests, it runs only once at the beginning.
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before CLASS"); // something that should be done only once in the class before all tests
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After CLASS"); // something that should be done only once in the class after all tests
    }

    // runs before every test automatically
    // works as a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("Before METHOD");
    }

    // runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("After METHOD");
    }

    @Test
    public void test1(){
        System.out.println(" TEST 1 " );
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void test2(){
        System.out.println(" TEST 2 ");
        int num1 = 5;
        int num2 = 10;
        //it calls hard assertion
        //if assertion fails, it stops the execution (due to exception).
        Assert.assertTrue(num1<num2);

    }
}

// we create the beforeMethod and after method once in every class


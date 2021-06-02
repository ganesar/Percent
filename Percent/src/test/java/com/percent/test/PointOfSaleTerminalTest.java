package com.percent.test;

import java.math.BigDecimal;

import com.percent.api.PointOfSaleTerminal;
import com.percent.impl.DefaultPosTerminalImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PointOfSaleTerminalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PointOfSaleTerminalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PointOfSaleTerminalTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testABCDABA() {
    
    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
    
    	try {
    		terminal.setPrice("A",1.25,3,3.00);
    		terminal.setPrice("B",4.25);
    		terminal.setPrice("C",1.00,6,5.00);
    		terminal.setPrice("D",0.75);
    		terminal.scan("A");
    		terminal.scan("B");
    		terminal.scan("C");
    		terminal.scan("D");
    		terminal.scan("A");
    		terminal.scan("B");
    		terminal.scan("A");
    		assertTrue(terminal.calculateTotal().equals(new BigDecimal(13.25)));
    		
    	}catch (Exception e) {
    		assertTrue("Exception",false);
    	}
    }

    public void testCCCCCCC() {
        
    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
    
    	try {
    		terminal.setPrice("A",1.25,3,3.00);
    		terminal.setPrice("B",4.25);
    		terminal.setPrice("C",1.00,6,5.00);
    		terminal.setPrice("D",0.75);
    		terminal.scan("C");
    		terminal.scan("C");
    		terminal.scan("C");
    		terminal.scan("C");
    		terminal.scan("C");
    		terminal.scan("C");
    		terminal.scan("C");
    		assertTrue(terminal.calculateTotal().equals(new BigDecimal(6.0)));
    		
    	}catch (Exception e) {
    		assertTrue("Exception",false);
    	}
    }
    
    public void testABCD() {
        
    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
    
    	try {
    		terminal.setPrice("A",1.25,3,3.00);
    		terminal.setPrice("B",4.25);
    		terminal.setPrice("C",1.00,6,5.00);
    		terminal.setPrice("D",0.75);
    		terminal.scan("A");
    		terminal.scan("B");
    		terminal.scan("C");
    		terminal.scan("D");
    		assertTrue(terminal.calculateTotal().equals(new BigDecimal(7.25)));
    		
    	}catch (Exception e) {
    		assertTrue("Exception",false);
    	}
    }
}

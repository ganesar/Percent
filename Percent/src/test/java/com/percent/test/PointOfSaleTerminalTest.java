package com.percent.test;

import java.math.BigDecimal;

import com.percent.api.InvalidPriceException;
import com.percent.api.InvalidVolumeException;
import com.percent.api.PointOfSaleTerminal;
import com.percent.api.ProductNotFoundException;
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
     * Test ABCDABA. 
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
    		fail();
    	}
    }

    /**
     * test CCCCCCC
     */
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
    		fail();
    	}
    }
    
    /**
     * test ABCD
     */
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
    		fail();
    	}
    }

    /**
     * Zero Purchase total
     */
    
    public void testZeroPurchase () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",1.25,3,3.00);
    		terminal.setPrice("B",4.25);
    		terminal.setPrice("C",1.00,6,5.00);
    		terminal.setPrice("D",0.75);
    		assertTrue(terminal.calculateTotal().equals(new BigDecimal(0.0)));
    	}catch (InvalidVolumeException e) {
    		fail();
    	}catch (InvalidPriceException e) {
    		fail();
    	}
    }

    /**
     * test product not found
     */
    
    public void testProductNotFound () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",3.0);
    		terminal.scan("B");
    		fail();
    	}catch (ProductNotFoundException e) {
    		assertTrue(true);
    	}catch (InvalidPriceException e) {
    		fail();
    	}
    }

    /**
     * test invalid unit price = 0.0
     */
    
    public void testInvalidUnitPriceZero () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",0.0);
    		fail();
    		
    	}catch (InvalidPriceException e) {
    		assertTrue(true);
    	}
    }
    
    /**
     * test invalid unit price -ve
     */
    
    public void testInvalidUnitPriceNeg () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",-2.0);
    		fail();
    		
    	}catch (Exception e) {
    		assertTrue(true);
    	}
    }
    
    /**
     * test invalid volume = 0
     */
    
    public void testInvalidVolumeZero () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, 0, 3.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		assertTrue(true);
    	}catch (InvalidPriceException e) {
    		fail();
    	}
    }
    
    /**
     * test invalid volume = 1
     */
    
    public void testInvalidVolumeOne () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, 1, 3.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		assertTrue(true);
    	}catch (InvalidPriceException e) {
    		fail();
    	}
    }
    
    /**
     * test invalid volume -ve
     */
    
    public void testInvalidVolumeNeg () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, -1, 3.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		assertTrue(true);
    	}catch (InvalidPriceException e) {
    		fail();
    	}
    }    	
    
    /**
     * test invalid volume Price zero
     */
    
    public void testInvalidVolumePriceZero () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, 3, 0.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		fail();
    	}catch (InvalidPriceException e) {
    		assertTrue(true);
    	}
    }    	    
    
    /**
     * test invalid volume Price -ve
     */
    
    public void testInvalidVolumePriceNeg () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, 3, -6.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		fail();
    	}catch (InvalidPriceException e) {
    		assertTrue(true);
    	}
    }    	        
    
    /**
     * test invalid volume Price less than unit price
     */
    
    public void testInvalidVolumePriceLessUnit () {

    	PointOfSaleTerminal terminal = new DefaultPosTerminalImpl();
        
    	try {
    		terminal.setPrice("A",2.0, 3, 1.0);
    		fail();
    		
    	}catch (InvalidVolumeException e) {
    		fail();
    	}catch (InvalidPriceException e) {
    		assertTrue(true);
    	}
    }    	            
  	                
}

package demo;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CalculatorTest {
	 @Test		
	   public void testAdd() {		 
	         Calculator cal=new Calculator();
	     String distCost= cal.costofTrip("QEW", "Highway 400");
	     List<String> items = Arrays.asList(distCost.split("-"));
	     assertEquals(items.get(0),"67.748" );
	     assertEquals(items.get(1),"16.937" );
	 }   
	 @Test		
	   public void testAdd1() {		 
		 Calculator cal=new Calculator();
	     String distCost= cal.costofTrip("Highway 400", "QEW");
	     List<String> items = Arrays.asList(distCost.split("-"));
	     assertEquals(items.get(0),"67.748" );
	     assertEquals(items.get(1),"16.937" );
	 }  	 
	 @Test		
	   public void testAdd2() {		 
		 Calculator cal=new Calculator();
	     String distCost= cal.costofTrip("York Durham Line", "QEW");
	     List<String> items = Arrays.asList(distCost.split("-"));
	     assertEquals(items.get(0),"100.11" );
	     assertEquals(items.get(1),"25.0275" );
	 }  
	 @Test		
	   public void testAdd3() {		 
		 Calculator cal=new Calculator();
	     String distCost= cal.costofTrip("QEW", "York Durham Line");
	     List<String> items = Arrays.asList(distCost.split("-"));
	     assertEquals(items.get(0),"100.11" );
	     assertEquals(items.get(1),"25.0275" );
	 } 
	 @Test		
	   public void testAdd4() {		 
		 Calculator cal=new Calculator();
	     String distCost= cal.costofTrip("QEW", "Derry Road");
	     List<String> items = Arrays.asList(distCost.split("-"));
	     assertEquals(items.get(0),"32.505" );
	     assertEquals(items.get(1),"8.12625" );
	 } 
}

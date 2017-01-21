package com.example.other;
import javax.servlet.http.*;

// You dont need specify this listener on web.xml!!!:
public class Person implements HttpSessionBindingListener{
	// fields:
	 private String name;
	 private int age;

   // Constructor:
	 public Person(String string, int n) {
	        this.name = string;
	        this.age = n;
	}
	// we dont provide Getters and Setters, because we only use field variable on this class
	 
	// This interface has different from other listeners and has different two methods, that 
	// you should implement:
	public void valueBound(HttpSessionBindingEvent event){
		System.out.println("\n###################################\n");
	    System.out.println("valueBound method has been called in " + this.getClass().getName());
	    System.out.println("Newly bound attribute name = " + event.getName() + 
	    		", value = " + event.getValue());
	    // also you can use this class methods and fields easly by:
	    System.out.println(" !!! name = " + name + ", age = " + age + " !!! ");
	    // and one more extra method to get a session object,only BindingEvent has from event class
	    HttpSession httpSession = event.getSession();
	    System.out.println("Getting session object which is : " + httpSession + 
	    	", only from HttpSessionBindingEvent");
	    System.out.println("\n###################################\n");
	}
	public void valueUnbound(HttpSessionBindingEvent event){
		 System.out.println("\n###################################\n");
	     System.out.println("valueUnbound method has been called in " + this.getClass().getName());
	     System.out.println("Last bound attribute WAS name = " + event.getName() 
	     + ", value = " + event.getValue());
	     System.out.println(" !!! name = " + this.name + ", age = " + this.age + " !!! ");
	     HttpSession httpSession = event.getSession();
	     System.out.println("Getting session object which is : " +httpSession + 
	    		 ", only from HttpSessionBindingEvent");
	     System.out.println("\n###################################\n");	
	}
}

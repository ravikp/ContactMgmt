package com.test;

import com.contactmgmt.domain.Contact;
public class Sample {

	public void helloWorld(){
		System.out.println("Hello World");
	}
	
	public void saveContact(Contact contact){
		System.out.println("Entered First Name is: " + contact.getFirstName());
		System.out.println("Entered Email Id is: " + contact.getEmail());
		contact.setAge(10);
	}
}

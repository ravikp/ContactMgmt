package com.test;


import junit.framework.TestCase;

import org.junit.Test;

import com.contactmgmt.domain.Contact;

public class TestSample extends TestCase {
	Sample sample = null;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		sample = new Sample();
	}

	public void testHelloWorld() {
		sample.helloWorld();
	}

	@Test
	public void testSaveContact(){
		Contact contact = new Contact();
		contact.setFirstName("Srikanth");
		contact.setEmail("kadiri.srikanth@gmail.com");
		sample.saveContact(contact);
		assertEquals(10,contact.getAge());
//		System.out.println(contact.getAge());
	}
}

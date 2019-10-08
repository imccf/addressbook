package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.AddressBookDAOImpl;
import model.ContactEntry;

public class AddressBookTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("******start test******");
	}

	@Test
	public void testAddContactEntry() {
		// Create plumber address book
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		ContactEntry contactJack = new ContactEntry();
		contactJack.setName("Jack");
		contactJack.setPhoneNum("041234567");
		contactJack.setCompany("AAA");
		contactJack.setID("1234");
		contactJack.setOccupation("Plumber");
		plumberAddress.addContactEntry(contactJack);
		if (plumberAddress.getContactEntry(0).getName().equals("Jack")
				&& plumberAddress.getContactEntry(0).getPhoneNum().equals("041234567")
				&& plumberAddress.getContactEntry(0).getCompany().equals("AAA")
				&& plumberAddress.getContactEntry(0).getOccupation().equals("Plumber")
				&& plumberAddress.getContactEntry(0).getID().equals("1234")) {
			System.out.println("AddContactEntryMethod pass");
			System.out.println("Name is " + plumberAddress.getContactEntry(0).getName());
			System.out.println("Phone number is " + plumberAddress.getContactEntry(0).getPhoneNum());
			System.out.println("Company is " + plumberAddress.getContactEntry(0).getCompany());
			System.out.println("Occapution is " + plumberAddress.getContactEntry(0).getOccupation());
			System.out.println("ID is " + plumberAddress.getContactEntry(0).getID());
		} else {
			fail("AddContactEntryMethod failed");
		}
		// Create the builder address book
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderPeter = new ContactEntry();
		builderPeter.setName("Peter");
		builderPeter.setPhoneNum("047654321");
		builderPeter.setCompany("BBB");
		builderPeter.setID("1234");
		builderPeter.setOccupation("Builder");
		builderAddress.addContactEntry(builderPeter);
		// Check the output
		if (builderAddress.getContactEntry(0).getName().equals("Peter")
				&& builderAddress.getContactEntry(0).getPhoneNum().equals("047654321")
				&& builderAddress.getContactEntry(0).getCompany().equals("BBB")
				&& builderAddress.getContactEntry(0).getOccupation().equals("Builder")
				&& builderAddress.getContactEntry(0).getID().equals("1234")) {
			System.out.println("AddContactEntryMethod pass");
			System.out.println("Name is " + builderAddress.getContactEntry(0).getName());
			System.out.println("Phone number is " + builderAddress.getContactEntry(0).getPhoneNum());
			System.out.println("Company is " + builderAddress.getContactEntry(0).getCompany());
			System.out.println("Occapution is " + builderAddress.getContactEntry(0).getOccupation());
			System.out.println("ID is " + builderAddress.getContactEntry(0).getID());
		} else {
			fail("AddContactEntryMethod failed");
		}
	}

	@Test
	public void testRemoveContactEntry() {
		// case 1
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderPeter = new ContactEntry();
		builderPeter.setName("Peter");
		builderPeter.setPhoneNum("047654321");
		builderPeter.setCompany("AAA");
		builderPeter.setID("1234");
		builderPeter.setOccupation("Builder");
		// Add it to address book
		builderAddress.addContactEntry(builderPeter);
		// Remove it
		builderAddress.removeContactEntry(builderPeter);
		// Valid it
		List<ContactEntry> contactEntryList = builderAddress.getAddressBook();
		for (ContactEntry contactEntry : contactEntryList) {
			if (contactEntry.equals(builderPeter)) {
				fail("removeContactEntryMethod failed");
				return;
			}
		}
		System.out.println("removeContactEntryMethod pass ");
	}

	@Test
	public void testPrintAllContacts() {
		// address book 1
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry contactJack = new ContactEntry();
		contactJack.setName("Jack");
		contactJack.setPhoneNum("041111111");
		contactJack.setCompany("AAA");
		contactJack.setOccupation("Plumber");
		contactJack.setID("1234");
		plumberAddress.addContactEntry(contactJack);
		// contact 2
		ContactEntry contactEdison = new ContactEntry();
		contactEdison.setName("Edison");
		contactEdison.setPhoneNum("042222222");
		contactEdison.setCompany("BBB");
		contactEdison.setOccupation("Plumber");
		contactEdison.setID("1234");
		plumberAddress.addContactEntry(contactEdison);
		// contact 3
		ContactEntry contactAndrew = new ContactEntry();
		contactAndrew.setName("Andrew");
		contactAndrew.setPhoneNum("04333333");
		contactAndrew.setCompany("BBB");
		contactAndrew.setOccupation("Plumber");
		contactAndrew.setID("1234");
		plumberAddress.addContactEntry(contactAndrew);
		// Print them to check the output
		plumberAddress.printAllContacts(plumberAddress.getAddressBook());
	}

	@Test
	public void testAll() {
		// address book 1
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry contactJack = new ContactEntry();
		contactJack.setName("Jack");
		contactJack.setPhoneNum("041111111");
		contactJack.setCompany("AAA");
		contactJack.setOccupation("Plumber");
		contactJack.setID("1234");
		plumberAddress.addContactEntry(contactJack);
		// contact 2
		ContactEntry contactEdison = new ContactEntry();
		contactEdison.setName("Edison");
		contactEdison.setPhoneNum("042222222");
		contactEdison.setCompany("BBB");
		contactEdison.setOccupation("Plumber");
		contactEdison.setID("1234");
		plumberAddress.addContactEntry(contactEdison);
		// contact 3
		ContactEntry contactAndrew = new ContactEntry();
		contactAndrew.setName("Andrew");
		contactAndrew.setPhoneNum("04333333");
		contactAndrew.setCompany("BBB");
		contactAndrew.setID("4321");
		contactAndrew.setOccupation("Plumber");
		plumberAddress.addContactEntry(contactAndrew);
		// Print them to check the output before remove a contact
		plumberAddress.printAllContacts(plumberAddress.getAddressBook());
		// Remove a contact
		plumberAddress.removeContactEntry(contactEdison);
		// Print them to check the output after remove a contact
		plumberAddress.printAllContacts(plumberAddress.getAddressBook());
	}

}

package Test;

import static org.junit.Assert.fail;

import java.util.List;

import dao.AddressBookDAOImpl;
import dao.AddressBookListDAOImpl;
import model.ContactEntry;

public class Test {

	public static void main(String arg[]) {

		testAddContactEntryMethod();
		testRemoveContactEntryMethod();
		testPrintAllContactsMethod();
		testIsMultipleAddressBook();
		testPrintUniqueAllContacts();
		testPrintUniqueAllContactsByID();
	}

	static void testAddContactEntryMethod() {

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
			System.out.println("AddContactEntryMethod failed");
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
			System.out.println("AddContactEntryMethod failed");
		}
	}

	static void testRemoveContactEntryMethod() {
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
				System.out.println("removeContactEntryMethod failed");
				return;
			}
		}
		System.out.println("removeContactEntryMethod pass ");
	}

	static void testPrintAllContactsMethod() {
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

	static void testIsMultipleAddressBook() {
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		// plumber Address
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		ContactEntry plumberJack = new ContactEntry();
		plumberJack.setName("Plumber Jack");
		plumberJack.setPhoneNum("041111111");
		plumberJack.setCompany("AAA");
		plumberJack.setOccupation("Plumber");
		plumberJack.setID("1234");
		plumberAddress.addContactEntry(plumberJack);
		addressBookList.addAddressBook(plumberAddress);
		// builder address
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderJack = new ContactEntry();
		builderJack.setName("Builder Jack");
		builderJack.setCompany("AAA");
		builderJack.setOccupation("Builder");
		builderJack.setPhoneNum("041111111");
		builderJack.setID("1234");
		builderAddress.addContactEntry(builderJack);
		addressBookList.addAddressBook(builderAddress);
		if (addressBookList.isMultipleAddressBook(addressBookList)) {
			System.out.println("testIsMultipleAddressBook pass");
		} else {
			System.out.println("user maintain address book failed");
		}
	}

	public static void testPrintUniqueAllContacts() {
		// plumber Address
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry plumberJack = new ContactEntry();
		plumberJack.setName("Plumber Jack");
		plumberJack.setPhoneNum("041111111");
		plumberJack.setCompany("AAA");
		plumberJack.setOccupation("Plumber");
		plumberJack.setID("1234");
		plumberAddress.addContactEntry(plumberJack);
		// contact 2
		ContactEntry plumberEdison = new ContactEntry();
		plumberEdison.setName("Plumber Edison");
		plumberEdison.setPhoneNum("042222222");
		plumberEdison.setCompany("BBB");
		plumberEdison.setID("1234");
		plumberEdison.setOccupation("Plumber");
		plumberAddress.addContactEntry(plumberEdison);

		// builder Address
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry builderJack = new ContactEntry();
		builderJack.setName("Builder Jack");
		builderJack.setPhoneNum("04333333");
		builderJack.setOccupation("Builder");
		builderJack.setCompany("AAA");
		builderJack.setID("4321");
		builderAddress.addContactEntry(builderJack);
		// contact 2
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("04444444");
		builderEdison.setCompany("CCC");
		builderEdison.setID("4321");
		builderAddress.addContactEntry(builderEdison);
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		// Print unique contacts with same ID index in different address book
		addressBookList.printUniqueAllContacts(1);
		addressBookList.printUniqueAllContacts(6);

	}

	public static void testPrintUniqueAllContactsByID() {
		// plumber Address
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry plumberJack = new ContactEntry();
		plumberJack.setName("Plumber Jack");
		plumberJack.setPhoneNum("041111111");
		plumberJack.setCompany("AAA");
		plumberJack.setID("1234");
		plumberJack.setOccupation("Plumber");
		plumberAddress.addContactEntry(plumberJack);
		// contact 2
		ContactEntry plumberEdison = new ContactEntry();
		plumberEdison.setName("Plumber Edison");
		plumberEdison.setPhoneNum("042222222");
		plumberEdison.setCompany("BBB");
		plumberEdison.setID("1234");
		plumberEdison.setOccupation("Plumber");
		plumberAddress.addContactEntry(plumberEdison);

		// builder Address
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry builderJack = new ContactEntry();
		builderJack.setName("Builder Jack");
		builderJack.setPhoneNum("04333333");
		builderJack.setOccupation("Builder");
		builderJack.setCompany("AAA");
		builderJack.setID("4321");
		builderAddress.addContactEntry(builderJack);
		// contact 2
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("04444444");
		builderEdison.setCompany("CCC");
		builderEdison.setID("4321");
		builderAddress.addContactEntry(builderEdison);
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		// Print unique contacts with same index in different address book
		addressBookList.printUniqueAllContacts(1);
		addressBookList.printUniqueAllContacts(6);
		// Print unique contacts with same ID in different address book
		addressBookList.printUniqueAllContactsByID("1234");
		addressBookList.printUniqueAllContactsByID("4321");

	}
}

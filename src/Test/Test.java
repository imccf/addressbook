package Test;

import java.util.List;

import dao.AddressBookDAOImpl;
import dao.AddressBookListDAOImpl;
import model.ContactEntry;

public class Test {

	public static void main(String arg[]) {

		testAddContactEntryMethod();
		testRemoveContactEntryMethod();
		testPrintAllContactsMethod();
		testPrintSpecificContactFromBooksListMethod();
		testPrintSpecificContactsByCompany();
		testIsMultipleAddressBook();
	}

	static void testAddContactEntryMethod() {
		// Create plumber address book
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		ContactEntry contactEntry = new ContactEntry();
		contactEntry.setName("Jack");
		contactEntry.setPhoneNum("041234567");
		plumberAddress.addContactEntry(contactEntry);
		if (plumberAddress.getContactEntry(0).getName().equals("Jack")
				&& plumberAddress.getContactEntry(0).getPhoneNum().equals("041234567")) {
			System.out.println("AddContactEntryMethod pass");
			System.out.println("Name is " + plumberAddress.getContactEntry(0).getName());
			System.out.println("Phone number is " + plumberAddress.getContactEntry(0).getPhoneNum());
		} else {
			System.out.println("AddContactEntryMethod failed");
		}
		// Create the builder address book
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderEntry = new ContactEntry();
		builderEntry.setName("Peter");
		builderEntry.setPhoneNum("047654321");
		builderAddress.addContactEntry(builderEntry);
		// check the output
		if (builderAddress.getContactEntry(0).getName().equals("Peter")
				&& builderAddress.getContactEntry(0).getPhoneNum().equals("047654321")) {
			System.out.println("AddContactEntryMethod pass");
			System.out.println("Name is " + builderAddress.getContactEntry(0).getName());
			System.out.println("Phone number is " + builderAddress.getContactEntry(0).getPhoneNum());
		} else {
			System.out.println("AddContactEntryMethod failed");
		}
	}

	static void testRemoveContactEntryMethod() {
		// case 1
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderEntry = new ContactEntry();
		builderEntry.setName("Peter");
		builderEntry.setPhoneNum("047654321");
		// add it to address book
		builderAddress.addContactEntry(builderEntry);
		// remove it
		builderAddress.removeContactEntry(builderEntry);
		// Valid it
		List<ContactEntry> contactEntryList = builderAddress.getAddressBook();
		for (ContactEntry contactEntry : contactEntryList) {
			if (contactEntry.equals(builderEntry)) {
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
		ContactEntry contactEntry1 = new ContactEntry();
		contactEntry1.setName("Jack");
		contactEntry1.setPhoneNum("041111111");
		contactEntry1.setCompany("AAA");
		contactEntry1.setOccupation("plumber");
		plumberAddress.addContactEntry(contactEntry1);
		// contact 2
		ContactEntry contactEntry2 = new ContactEntry();
		contactEntry2.setName("Edison");
		contactEntry2.setPhoneNum("042222222");
		contactEntry2.setCompany("BBB");
		contactEntry2.setOccupation("plumber");
		plumberAddress.addContactEntry(contactEntry2);
		// contact 3
		ContactEntry contactEntry3 = new ContactEntry();
		contactEntry3.setName("Andrew");
		contactEntry3.setPhoneNum("04333333");
		contactEntry3.setCompany("CCC");
		contactEntry3.setOccupation("plumber");
		plumberAddress.addContactEntry(contactEntry3);
		// print them to check the output
		plumberAddress.printAllContacts(plumberAddress.getAddressBook());

	}

	static void testPrintSpecificContactFromBooksListMethod() {
		// plumber address
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry plumberJack = new ContactEntry();
		plumberJack.setName("Plumber Jack");
		plumberJack.setPhoneNum("041111111");
		plumberJack.setCompany("AAA");
		plumberJack.setOccupation("Plumber");
		plumberAddress.addContactEntry(plumberJack);
		// contact 2
		ContactEntry plumberEdison = new ContactEntry();
		plumberEdison.setName("Plumber Edison");
		plumberEdison.setCompany("BBB");
		plumberEdison.setOccupation("Plumber");
		plumberEdison.setPhoneNum("042222222");
		plumberAddress.addContactEntry(plumberEdison);
		// builder address
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry builderJack = new ContactEntry();
		builderJack.setName("Builder Jack");
		builderJack.setCompany("AAA");
		builderJack.setOccupation("Builder");
		builderJack.setPhoneNum("041111111");
		builderAddress.addContactEntry(builderJack);
		// contact 2
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setCompany("BBB");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("042222222");
		builderAddress.addContactEntry(builderEdison);
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		// print them to check the output
		addressBookList.printSpecificContactsByContact(plumberJack);
		addressBookList.printSpecificContactsByContact(plumberEdison);
		addressBookList.printSpecificContactsByCompany("AAA");
		addressBookList.printSpecificContactsByOccupation("Plumber");

	}

	static void testPrintSpecificContactsByCompany() {
		// plumber Address
		AddressBookDAOImpl plumberAddress = new AddressBookDAOImpl();
		// contact 1
		ContactEntry plumberJack = new ContactEntry();
		plumberJack.setName("Plumber Jack");
		plumberJack.setPhoneNum("041111111");
		plumberJack.setCompany("AAA");
		plumberJack.setOccupation("Plumber");
		plumberAddress.addContactEntry(plumberJack);
		// contact 2
		ContactEntry plumberEdison = new ContactEntry();
		plumberEdison.setName("Plumber Edison");
		plumberEdison.setPhoneNum("042222222");
		plumberEdison.setCompany("BBB");
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
		builderAddress.addContactEntry(builderJack);
		// contact 2
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("04444444");
		builderEdison.setCompany("CCC");
		builderAddress.addContactEntry(builderEdison);
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		addressBookList.printSpecificContactsByCompany("AAA");

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
		plumberAddress.addContactEntry(plumberJack);
		addressBookList.addAddressBook(plumberAddress);
		// builder address
		AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
		ContactEntry builderJack = new ContactEntry();
		builderJack.setName("Builder Jack");
		builderJack.setCompany("AAA");
		builderJack.setOccupation("Builder");
		builderJack.setPhoneNum("041111111");
		builderAddress.addContactEntry(builderJack);
		addressBookList.addAddressBook(builderAddress);
		if (addressBookList.isMultipleAddressBook(addressBookList)) {
			System.out.println("testIsMultipleAddressBook pass");
		} else {
			System.out.println("user maintain address book failed");
		}
	}
}

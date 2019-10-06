package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.AddressBookDAOImpl;
import dao.AddressBookListDAOImpl;
import model.ContactEntry;

public class AddressBookListDAOImplTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("*****start test******");
	}

	@Test
	public void testAddAddressBook() {
		try {
			AddressBookDAOImpl builderAddress = new AddressBookDAOImpl();
			ContactEntry builderJack = new ContactEntry();
			builderJack.setName("Builder Jack");
			builderJack.setCompany("AAA");
			builderJack.setOccupation("Builder");
			builderJack.setPhoneNum("041111111");
			builderAddress.addContactEntry(builderJack);
			AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
			addressBookList.addAddressBook(builderAddress);
			if (addressBookList.getAddressBook(0).equals(builderAddress)) {
				System.out.println("testAddAddressBook pass");
			}
		} catch (Exception e) {
			fail("testAddAddressBook failed");
		}
	}

	@Test
	public void testIsMultipleAddressBook() {
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
			fail("user maintain address book failed");
		}
	}

	@Test
	public void testPrintSpecificContactsByContact() {
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
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setCompany("BBB");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("043333333");
		builderAddress.addContactEntry(builderEdison);
		// create a address book list
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		// print them to check the output
		addressBookList.printSpecificContactsByContact(plumberJack);
		addressBookList.printSpecificContactsByContact(plumberEdison);
		addressBookList.printSpecificContactsByContact(builderEdison);
	}

	@Test
	public void testPrintSpecificContactsByOccupation() {
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
		builderJack.setOccupation("Plumber");
		builderJack.setCompany("AAA");
		builderAddress.addContactEntry(builderJack);
		// contact 2
		ContactEntry builderEdison = new ContactEntry();
		builderEdison.setName("Builder Edison");
		builderEdison.setOccupation("Builder");
		builderEdison.setPhoneNum("04444444");
		builderEdison.setCompany("CCC");
		builderAddress.addContactEntry(builderEdison);
		// Add these address book to address book list
		AddressBookListDAOImpl addressBookList = new AddressBookListDAOImpl();
		addressBookList.addAddressBook(plumberAddress);
		addressBookList.addAddressBook(builderAddress);
		addressBookList.printSpecificContactsByOccupation("Plumber");
	}

	@Test
	public void testPrintSpecificContactsByCompany() {
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

	@Test
	public void testAll() {
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
		builderJack.setCompany("BBB");
		builderJack.setOccupation("Builder");
		builderJack.setPhoneNum("041111111");
		builderAddress.addContactEntry(builderJack);
		addressBookList.addAddressBook(builderAddress);

		if (addressBookList.isMultipleAddressBook(addressBookList)) {
			addressBookList.printSpecificContactsByCompany("AAA");
			addressBookList.printSpecificContactsByCompany("BBB");
			addressBookList.printSpecificContactsByOccupation("Builder");
			addressBookList.printSpecificContactsByOccupation("Plumber");
		} else {
			fail("user maintain address book failed");
		}
	}

}

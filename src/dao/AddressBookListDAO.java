package dao;

import java.util.List;

import model.ContactEntry;

public interface AddressBookListDAO {
	public void addAddressBook(AddressBookDAOImpl addressBook);

	public boolean isMultipleAddressBook(AddressBookListDAOImpl addressBookList);

	public void printSpecificContactsByContact(ContactEntry entry);

	public void printSpecificContactsByOccupation(String occupation);

	public void printSpecificContactsByCompany(String company);
}

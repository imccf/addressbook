package dao;

import java.util.List;

import model.ContactEntry;

public interface AddressBookDAO {
	public void addContactEntry(ContactEntry contactEntry);

	public void removeContactEntry(ContactEntry contactEntry);

	public void printAllContacts(List<ContactEntry> addressBook);
}

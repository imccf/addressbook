package dao;

import java.util.ArrayList;
import java.util.List;

import model.ContactEntry;
import util.Util;

public class AddressBookDAOImpl implements AddressBookDAO {
	private List<ContactEntry> addressBook; // for address book

	public AddressBookDAOImpl() {
		addressBook = new ArrayList<ContactEntry>();
	}

	public List<ContactEntry> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List<ContactEntry> addressBook) {
		this.addressBook = addressBook;
	}

	public ContactEntry getContactEntry(int index) {
		return addressBook.get(index);
	}

	/**
	 * @Discretion ��Add one contact into the address book
	 * @Params ��@param ContactEntry
	 * @return ��void
	 **/
	@Override
	public void addContactEntry(ContactEntry contactEntry) {
		// TODO Auto-generated method stub
		addressBook.add(contactEntry);
	}

	/**
	 * @Discretion ��Remove one contact in the address book
	 * @Params ��@param ContactEntry
	 * @return ��void
	 **/
	@Override
	public void removeContactEntry(ContactEntry contactEntry) {
		// TODO Auto-generated method stub
		if (addressBook != null) {
			for (ContactEntry tempContactEntry : addressBook) {
				if (tempContactEntry.equals(contactEntry)) {
					addressBook.remove(tempContactEntry);
					return;
				}
			}
		}
	}

	/**
	 * @Discretion ��Print all contacts for the specified address book
	 * @Params ��@param List<ContactEntry>
	 * @return ��void
	 **/
	@Override
	public void printAllContacts(List<ContactEntry> addressBook) {
		// TODO Auto-generated method stub
		if (addressBook != null) {
			for (ContactEntry contactEntry : addressBook) {
				Util.printContactInfo(contactEntry);
			}
		}
	}

}

package dao;

import java.util.ArrayList;
import java.util.List;

import model.ContactEntry;
import util.Util;

public class AddressBookListDAOImpl implements AddressBookListDAO {

	private List<AddressBookDAOImpl> addressBookList;// for address book list

	public AddressBookListDAOImpl() {
		addressBookList = new ArrayList<AddressBookDAOImpl>();
	}

	public List<AddressBookDAOImpl> getAddressBookList() {
		return addressBookList;
	}

	public void setAddressBookList(List<AddressBookDAOImpl> addressBookList) {
		this.addressBookList = addressBookList;
	}

	public AddressBookDAOImpl getAddressBook(int index) {
		return addressBookList.get(index);
	}

	/**
	 * @Discretion £ºUsed to add a address book to a address book list
	 * @Params £º@param AddressBookDAOImpl addressBook
	 * @return £ºvoid
	 **/
	@Override
	public void addAddressBook(AddressBookDAOImpl addressBook) {
		this.addressBookList.add(addressBook);
	}

	/**
	 * @Discretion £ºUsed to print a specified contact information across multiple
	 *             address
	 * @Params £º@param ContactEntry entry
	 * @return £ºvoid
	 **/
	@Override
	public void printSpecificContactsByContact(ContactEntry entry) {
		// TODO Auto-generated method stub

		if (addressBookList != null) {
			for (AddressBookDAOImpl addressBook : addressBookList) {
				List<ContactEntry> ContactEntryList = addressBook.getAddressBook();
				for (ContactEntry contactEntry : ContactEntryList) {
					if (contactEntry.equals(entry)) {
						Util.printContactInfo(contactEntry);
					}
				}
			}
		}
	}

	/**
	 * @Discretion £ºUsed to print a unique set of all contacts across multiple
	 *             address books(by occupation)
	 * @Params £º@param String company
	 * @return £ºvoid
	 **/
	@Override
	public void printSpecificContactsByOccupation(String occupation) {
		// TODO Auto-generated method stub
		if (addressBookList != null) {
			for (AddressBookDAOImpl addressBook : addressBookList) {
				List<ContactEntry> ContactEntryList = addressBook.getAddressBook();
				for (ContactEntry contactEntry : ContactEntryList) {
					if (contactEntry.getOccupation().equals(occupation)) {
						Util.printContactInfo(contactEntry);
					}
				}
			}
		}
	}

	/**
	 * @Discretion £ºUsed to print a unique set of all contacts across multiple
	 *             address books(by company)
	 * @Params £º@param String company
	 * @return £ºvoid
	 **/
	@Override
	public void printSpecificContactsByCompany(String company) {
		// TODO Auto-generated method stub
		if (addressBookList != null) {
			for (AddressBookDAOImpl addressBook : addressBookList) {
				List<ContactEntry> ContactEntryList = addressBook.getAddressBook();
				for (ContactEntry contactEntry : ContactEntryList) {
					if (contactEntry.getCompany().equals(company)) {
						Util.printContactInfo(contactEntry);
					}
				}
			}
		}
	}

	/**
	 * @Discretion £ºUsed to judge whether user maintain multiple address book or
	 *             not, if yes, return true, or else return false
	 * @Params £º@param AddressBookListDAOImpl addressBookList
	 * @return £ºboolean
	 **/
	@Override
	public boolean isMultipleAddressBook(AddressBookListDAOImpl addressBookList) {
		// TODO Auto-generated method stub
		if (addressBookList != null && addressBookList.getAddressBookList().size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}

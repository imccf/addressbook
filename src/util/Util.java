package util;

import model.ContactEntry;

public class Util {

	public static void printContactInfo(ContactEntry contactEntry) {
		System.out.println("Name is " + contactEntry.getName() + "," + " PhoneNum is " + contactEntry.getPhoneNum()
				+ "," + " Company is " + contactEntry.getCompany() + "," + " Occupation is "
				+ contactEntry.getOccupation());
	}

}

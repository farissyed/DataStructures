import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Phone {
	
	public static void main(String[] args) {
		List<List<Contact>> test = new LinkedList<>();
		
		List<Contact> cl1 = new LinkedList<>();
		List<Contact> cl2 = new LinkedList<>();
		List<Contact> cl3 = new LinkedList<>();
		
		Contact c1 = new Contact("Zain ","1234");
		Contact c2 = new Contact("Mat     ","3272");
		Contact c3 = new Contact("Faris   Syed   ","5678");
		Contact c4 = new Contact("mat      ","3272");
		Contact c5 = new Contact("Bob       ","3245");
		Contact c6 = new Contact("bob        ","3245");
		Contact c7 = new Contact("Mat  ","3272");
		Contact c8 = new Contact("Aaron                 ","3272");
		Contact c9 = new Contact("Zain      ","1234");
		
		cl1.add(c1);
		cl1.add(c2);
		cl1.add(c3);
		cl2.add(c4);
		cl2.add(c5);
		cl2.add(c6);
		cl3.add(c7);
		cl3.add(c8);
		cl3.add(c9);
		
		test.add(cl1);
		test.add(cl2);
		test.add(cl3);
		
		System.out.println(mergeContacts(test));
	}
	
	/**
	 * Combines multiple contact lists into one single data structure with no
	 * duplicates. A duplicate is defined as a contact with both the same name and
	 * phone number. It is possible for different contacts to have the same phone
	 * number, but different names (they live in the same house). It is also
	 * possible for different contacts to have the same name but different phone
	 * numbers (different people).
	 * 
	 * @param contactLists Different lists of contacts collected from different
	 *                     software.
	 * @return Some data structure which has all of the original contacts combined
	 *         into a single structure with no duplicates.
	 */
	public static Set<Contact> mergeContacts(List<List<Contact>> contactLists) {
		
		Set<Contact> contacts = new TreeSet<Contact>();
		
		for (List<Contact> cList : contactLists) {
			for ( Contact c : cList ) {
				contacts.add(c);
			}
		}
		
		return contacts;
	}
}
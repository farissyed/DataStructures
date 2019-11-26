
public class Contact implements Comparable {

	private String name;
	private String phoneNum;

	public Contact(String name, String phoneNum) {
		this.name = getTitleCase(name);
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	
	private String getTitleCase(String str) {
		if ( str == null || str.isBlank() ) {
			return str; 
		}
		
		str = str.trim();
		
		String tail = str.substring(1);
		String head = str.substring(0,1).toUpperCase();
		
		return head + tail;
	}
	
	@Override
	public int hashCode() {
		return (name + phoneNum).hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if( o == this ) {
			return true;
		}
		if ( !(o instanceof Contact) ) {
			return false;
		}
		return name.equalsIgnoreCase(((Contact) o).name) 
				&& phoneNum.equals(((Contact) o).phoneNum);
	}
	
	@Override
	public String toString() {
		return "(" + name + ", " + phoneNum + ")";
	}

	@Override
	public int compareTo(Object o) {
		if( name.compareTo( ((Contact)o).name ) == 0) {
			return phoneNum.compareTo( ((Contact)o).phoneNum  );
		}
		else {
			return name.compareTo( ((Contact)o).name );
		}
	}
}

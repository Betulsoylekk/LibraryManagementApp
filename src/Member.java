
public class Member 
{
	private String id;
	private String name;
	private String email;
	
	
	private int issuedDay = 0;
	private int issuedBook = 0;
	
	public Member(String id,String name,String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIssuedDay() {
		return issuedDay;
	}

	public void setIssuedDay(int issuedDay) {
		this.issuedDay = issuedDay;
	}

	public int getIssuedBook() {
		return issuedBook;
	}

	public void setIssuedBook(int issuedBook) {
		this.issuedBook = issuedBook;
	}
}

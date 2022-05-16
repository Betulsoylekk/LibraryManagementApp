
public class Issue 
{
	private String id;
	private String memberId;
	private String bookId;
	private String issueDate;
	private String returningDate;
	
	
	private int dayDifference;
		
	
	
	public Issue(String id, String memberId, String bookId,String issueDate,String returningDate)
	{
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
		this.dayDifference = -1;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}

	public int getDayDifference() {
		return dayDifference;
	}

	public void setDayDifference(int dayDifference) {
		this.dayDifference = dayDifference;
	}

}

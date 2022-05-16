
public class LibraryManagement 
{
	public final int LIBRARY_1 = 0;
	public final int LIBRARY_2 = 1;
	public final int LIBRARY_3 = 2;
	
	private Issue[][] issueArray = new Issue[3][];
	private Member[] memberArray;
	
	public void addIssueArray(int WhichLibrary,Issue[] IssueArray)
	{
		issueArray[WhichLibrary] = IssueArray;
	}
	
	public void setMemberArray(Member[] MemberArray)
	{
		memberArray = MemberArray;
	}
	public Member[] getMemberArray()
	{
		return memberArray;
	}
	
	public Issue[][] getIssueArray()
	{
		return issueArray;
	}

}

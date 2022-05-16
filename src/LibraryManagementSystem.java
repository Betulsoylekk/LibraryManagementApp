
public class LibraryManagementSystem 
{
	public static void main(String[] args)
	{
		FileIO  io =  new FileIO();
		Library l1 =  new Library();
		Library l2 =  new Library();
		Library l3 =  new Library();
		LibraryManagement lm = new LibraryManagement();
		
		l1.setBookArray(io.readLibrary("src/L1_Books.csv"));
		l2.setBookArray(io.readLibrary("src/L2_Books.csv"));
		l3.setBookArray(io.readLibrary("src/L3_Books.csv"));
		
		lm.addIssueArray(lm.LIBRARY_1, io.readIssues("src/L1_Issues.csv"));
		lm.addIssueArray(lm.LIBRARY_2, io.readIssues("src/L2_Issues.csv"));
		lm.addIssueArray(lm.LIBRARY_3, io.readIssues("src/L3_Issues.csv"));
		
		lm.setMemberArray(io.readMember("src/Members.csv"));

		LibraryQuery lq = new LibraryQuery();

		String firstQuery = lq.firstQuery(lm.getIssueArray(), l1, l2, l3);
		String secondQuery = lq.secondQuery(lm.getIssueArray(), lm.getMemberArray());
		String thirdQuery = lq.thirdQuery(lm.getIssueArray());
		String forthQuery = lq.forthQuery(l1, l2, l3);
		String fifthQuery = lq.fifthQuery(lm.getIssueArray(), l1, l2, l3);
		String sixthQuery = lq.sixthQuery(lm.getIssueArray(), 3, lm.getMemberArray());
		
		System.out.println("1: " + firstQuery);
		System.out.println("2: " + secondQuery);
		System.out.println("3: " + thirdQuery);
		System.out.println("4: " + forthQuery);
		System.out.println("5: " + fifthQuery);
		System.out.println("6: " + sixthQuery);
		}
} 
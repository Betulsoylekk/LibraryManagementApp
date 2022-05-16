
public class LibraryQuery 
{
	public String firstQuery(Issue[][] issueArray,Library L1,Library L2,Library L3)
	{
		Book maxIssuedBook = null;
		for (int i = 0;i < issueArray.length; i++)
		{
			for (int k = 0;k < issueArray[i].length;k++)
			{
				Book currentBook = searchBookAtAllLibrary(issueArray[i][k].getBookId(),L1,L2,L3);
				currentBook.setIssuedNumber(currentBook.getIssuedNumber() + 1);	
				if ( maxIssuedBook == null)		{	maxIssuedBook = currentBook;}
				else if (currentBook.getIssuedNumber() > maxIssuedBook.getIssuedNumber())	{	maxIssuedBook = currentBook;}
			}
		}
		return  maxIssuedBook.getTitle();
	}
	
	public String secondQuery(Issue[][] issueArray,Member[] memberArray)
	{
		Member memberMostIssued = null;
		for (int i = 0;i < issueArray.length;i++)
		{
			for (int k =0; k<issueArray[i].length;k++)
			{
				Member m  = findMemberByMemberId(memberArray,issueArray[i][k].getMemberId());
				m.setIssuedDay(m.getIssuedDay() + issueArray[i][k].getDayDifference());
			}
		}
		
		for (Member i: memberArray)
		{
			if (memberMostIssued == null)	{	memberMostIssued = i;}
			else if (i.getIssuedDay() > memberMostIssued.getIssuedDay())	{	memberMostIssued = i;}
		}
		return memberMostIssued.getName();
	}
	
	public String thirdQuery(Issue[][] issueArray)
	{
		int dayDiff = -2;
		for (int i = 0;i < issueArray.length;i++)
		{
			for (int k =0; k<issueArray[i].length;k++)
			{
				if(issueArray[i][k].getDayDifference() > dayDiff)
				{
					dayDiff =issueArray[i][k].getDayDifference();
				}
			}
		}
		double penalty = ((dayDiff-14))*0.5; 
		return penalty + "TL";
	}
	
	public String forthQuery(Library L1,Library L2,Library L3)
	{
		Book mostCopyBookL1 = mostCopyAtLibrary(L1.getBookArray());
		Book mostCopyBookL2 = mostCopyAtLibrary(L2.getBookArray());
		Book mostCopyBookL3 = mostCopyAtLibrary(L3.getBookArray());
		
		if (mostCopyBookL1.getQuantity() > mostCopyBookL2.getQuantity()
				&& mostCopyBookL1.getQuantity() > mostCopyBookL3.getQuantity())
		{
			return mostCopyBookL1.getTitle();
		}
		else if (mostCopyBookL2.getQuantity() > mostCopyBookL1.getQuantity()
				&& mostCopyBookL2.getQuantity() > mostCopyBookL3.getQuantity())
		{
			return mostCopyBookL2.getTitle();
		}
		else	{	return mostCopyBookL3.getTitle();}	
	}
	
	public String fifthQuery(Issue[][] issueArray,Library L1,Library L2,Library L3)
	{
		Book fewestCopyBook = null;
		for (int i = 0; i < issueArray.length;i++)
		{
			for (int k = 0; k < issueArray[i].length;k++)
			{
				Book currentBook = searchBookAtAllLibrary(issueArray[i][k].getBookId(),L1,L2,L3);
				
				if (fewestCopyBook == null)	{	fewestCopyBook = currentBook;}
				else if (currentBook.getQuantity() < fewestCopyBook.getQuantity())	{	fewestCopyBook = currentBook;}
			}
		}
		return fewestCopyBook.getTitle();
	}
	
	public String sixthQuery(Issue[][] issueArray,int whichLibrary,Member[] memberArray)
	{
		Member mostIssuedMember = null;
		for (int i = 0; i < issueArray[whichLibrary - 1].length;i++)
		{
			Member currentMember = findMemberByMemberId(memberArray,issueArray[whichLibrary - 1][i].getMemberId());
			currentMember.setIssuedBook(currentMember.getIssuedBook()+1);
		}
		
		for (int i = 1; i < memberArray.length;i++)   // MemberArray[0] is admin
		{
			if (mostIssuedMember == null)	{	mostIssuedMember = memberArray[i];}
			else if (memberArray[i].getIssuedBook() < mostIssuedMember.getIssuedBook())	{	mostIssuedMember = memberArray[i];}
		}
		return mostIssuedMember.getName();
	}
	
	
	
	
	
	
	private Book mostCopyAtLibrary(Book[] bookArray)
	{
		Book mostCopyBook = null;
		for (int i = 0;i < bookArray.length;i++)
		{
			if (mostCopyBook == null)	{	mostCopyBook = bookArray[i];}
			else if (bookArray[i].getQuantity() > mostCopyBook.getQuantity())	{	mostCopyBook = bookArray[i];}
		}
		return mostCopyBook;
	}
	
	private Member findMemberByMemberId(Member[] memberArray,String Id)
	{
		for (int i = 0; i< memberArray.length;i++)
		{
			if (memberArray[i].getId().contains(Id))
			{
				return memberArray[i];
			}
		}
		return null;
	}
	
	private Book searchBookAtAllLibrary(String bookId, Library L1,Library L2,Library L3)
	{
		if (searchBookAtLibrary(bookId,L1) == null)
		{
			if (searchBookAtLibrary(bookId,L2) == null)
			{
				return searchBookAtLibrary(bookId,L3);	
			}
			else
			{
				return searchBookAtLibrary(bookId,L2);
			}
		}
		else
		{
			return searchBookAtLibrary(bookId,L1);
		}
	}

	private Book searchBookAtLibrary(String BookId, Library Library)
	{
		Book tempBook = null;
		for (int i = 0; i < Library.getBookArray().length;i++)
		{
			if (Library.getBookArray()[i].getId().contains(BookId))		{	tempBook = Library.getBookArray()[i];}
		}
		return tempBook;
	}
}

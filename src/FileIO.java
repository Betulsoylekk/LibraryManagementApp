import java.io.*;
import java.util.Scanner;

public class FileIO
{
	Scanner sc = null;	
	private int findNumberOfLines(String filePath) throws FileNotFoundException
	{
		sc = new Scanner(new File(filePath));
		int length = 0;
		while (sc.hasNextLine())
		{
			length++;
			sc.nextLine();
		}
		sc.close();
		return length;
	}

	public Issue[] readIssues(String IssuePath)
	{
		Issue[] tempIssueArray = null;
		int index = 0;
		try {
			tempIssueArray = new Issue[findNumberOfLines(IssuePath)];
			sc = new Scanner(new File(IssuePath));
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] splittedArray = line.split(",");
				tempIssueArray[index] = new Issue(splittedArray[0],
												  splittedArray[1], 
												  splittedArray[2], 
												  splittedArray[3], 
												  splittedArray[4]);
				
				Date issueDate = Date.makeDateType(tempIssueArray[index].getIssueDate());
				Date returningDate = Date.makeDateType(tempIssueArray[index].getReturningDate());
				tempIssueArray[index].setDayDifference(issueDate.dateDifference(returningDate));
				index++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not found file at location:" + IssuePath);
			System.exit(0);
		}
		sc.close();
		return tempIssueArray;
	}

	public Book[] readLibrary(String LibraryPath)
	{
		Book[] tempBookArray = null;
		int index = 0;
		try {
			tempBookArray = new Book[findNumberOfLines(LibraryPath)];
			sc = new Scanner(new File(LibraryPath));
			
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] splittedLine = line.split(",");
				int edition  = Integer.parseInt(splittedLine[4]);	// Book class only accepts "int" for "edition" and "quantity" value
				int quantity = Integer.parseInt(splittedLine[6]);	// So we changing from "string" to "int"
				tempBookArray[index] = new Book(splittedLine[0],
											 splittedLine[1],
											 splittedLine[2],
											 splittedLine[3],
											 edition,
											 splittedLine[5],
											 quantity);
				index++;
			}
		} catch (FileNotFoundException e) 
		{
			System.out.println("Could not found file at location: " + LibraryPath);
			System.exit(0);
		}
		sc.close();
		return tempBookArray;
	}
	public Member[] readMember(String MemberPath)
	{
		Member[] tempMemberArray = null;
		int index = 0;
		try {
			tempMemberArray = new Member[findNumberOfLines(MemberPath)-1];
			sc = new Scanner(new File(MemberPath));
			
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				if (!line.contains("ID"))
				{
					String[] splittedLine = line.split(",");
					tempMemberArray[index] = new Member(splittedLine[0],
														splittedLine[1],
														splittedLine[2]);
					index++;
				}
				
				
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not found file at location" + MemberPath);
			System.exit(0);
		}
		sc.close();
		return tempMemberArray;
	}
}
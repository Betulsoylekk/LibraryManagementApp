
public class Date 
{
	private int	day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year)
	{
		this.day  = day;
		this.month = month;
		this.year = year;
	}	
	
	
	
	public static Date makeDateType(String DateInStr)
	{
		int day = Integer.parseInt(DateInStr.split("-")[0]);
		int month = getPositionOfMonth(DateInStr.split("-")[1]);
		int year = Integer.parseInt(DateInStr.split("-")[2]);
		
		return new Date(day,month,year);
	}
	
	public static int getPositionOfMonth(String Month)
	{
		Month = Month.toLowerCase();
		switch(Month)
		{
			case "jan":	return 1;
			case "feb": return 2;
			case "mar":	return 3;
			case "apr": return 4;
			case "may": return 5;
			case "jun": return 6;
			case "jul": return 7;
			case "aug": return 8;
			case "sep": return 9;
			case "oct": return 10;
			case "nov": return 11;
			case "dec": return 12;
			default:	return -1;
		}
	}
	
	public int dateDifference(Date AnotherDate)
	{
		int dateDifference = AnotherDate.numberOfDays() - this.numberOfDays();
		if (dateDifference < 0)	{	return -dateDifference;}
		return dateDifference;
	}
	
	
	// this function calculates the day equivalence of date
	// formula found on internet!
	private int numberOfDays()
	{
		if (month <= 2)
		{
			year--;
			month = month + 13;
		}
		else	{	month++;}
		int numberOfDays = (1461*year)/4 + (153*month)/5 + day;
		return numberOfDays;
	}
}


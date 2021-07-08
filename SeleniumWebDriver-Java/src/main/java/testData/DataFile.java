package testData;

public class DataFile {
	
//	Data HomePage
	public static String homePageURL = "https://computer-database.herokuapp.com/computers";
	public static String headerBanner = "Play sample application - Computer database";
	
	
//	Data to Create
	public static String computerNameToCreate = "TI-99/4A";
	public static String introducedDateToCreate = "1981-06-01";
	public static String discontinuedDateToCreate = "1984-03-31";
	public static String companyToCreate = "Texas Instruments";
	public static String expectedMessageToCreate = "Done! Computer " + computerNameToCreate + " has been created";
	
//	Data to Read
	public static String expectedHeaderBanner = "Edit computer";
	public static String computerNameToRead = "Amiga";
	public static String introducedDateToRead = "1985-01-01";
	public static String discontinuedDateToRead = "";
	public static String companyToRead = "Amiga Corporation";
	public static String expectedMainMessage = "577 computers found";
	
//	Data to Update
	public static String computerNameToUpdate = "ThinkPad 340 CSE";
	public static String introducedDateToUpdate = "1994-05-01";
	public static String discontinuedDateToUpdate = "1996-06-30";
	public static String companyToUpdate = "Lenovo Group";
	public static String expectedMessageToUpdate = "Done! Computer " + computerNameToUpdate + " has been updated";
	
//	Data to Delete
	public static String computerNameToDelete = "TI-99/4A";
	public static String expectedMessageToDelete = "Done! Computer has been deleted";
	
}
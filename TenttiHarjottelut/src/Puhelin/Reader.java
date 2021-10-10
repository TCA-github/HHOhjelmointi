package Puhelin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reader {
 private Scanner input = new Scanner(System.in);
 private SimpleDateFormat dFormat = new SimpleDateFormat("yyyy.MM.dd");
 
 
 
 public Reader() {
	super();
}


//Integer reader
public int readInteger(String consoleTxt){
	int readInt=0;
	boolean readOk = false;		
	do {
		System.out.print(consoleTxt);
		try {
			readInt = Integer.parseInt(input.nextLine());
			readOk = true;
		} catch (Exception e) {
			System.out.println("Please write Integer!");
		}
	} while (!readOk);
	
	return readInt;
 }
 
//Double reader
 public double readDouble(String consoleTxt){
	 double readDouble = 0;
	 boolean readOk = false;
	 
	 do {
		System.out.print(consoleTxt);
		try {
			readDouble = Double.parseDouble(input.nextLine());
			readOk = true;
		} catch (Exception e) {
			System.out.println("Please write Double!");
		}
	} while (!readOk);
	 
	 return readDouble;
 }
 
 //String reader 
 public String readString(String consoleTxt){
	 String readString = "";
	 boolean readOk = false;
	 do {
		System.out.println(consoleTxt);
		try {
			readString = input.nextLine();
			readOk=true;
		} catch (Exception e) {
			System.out.println("Unknonwn error happened! gz...");
		}
	} while (!readOk);
	 
	 return readString;
 }
 
 //Date reader with custom date format
 public Date readDate(String consoleTxt,String dateFormat){ 
	 Date readDate = new Date();
	 boolean dateFormatOk = false;
	 boolean readOk = false;
	do {
		try {
			dFormat.applyPattern(dateFormat);
			dateFormatOk = true;
		} catch (Exception e) {
			dateFormat = readString("Please write Correct date format: ");
		}
	} while (!dateFormatOk);
	
	do {
		try {
			System.out.print(consoleTxt);
			readDate = dFormat.parse(input.nextLine());
			readOk =true;
		} catch (Exception e) {
			System.out.println("Write in format: " + dateFormat);
		}
	} while (!readOk); 
	 
	 return readDate;
 }

}

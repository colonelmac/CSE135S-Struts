package CSE135S;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;

public class Degree {

	public String title;
	public int major;
	public int specialization;
	public int university;
	public java.sql.Date graduationDate;
	public int gpa; 
	public File transcript;
	
	public Degree() {
		
		
	}
	
	public Degree(int major, int month, int year, String title, int university, int gpa) {
		
		this.title = title;
		this.major = major;
		this.university = university;
		this.graduationDate = new java.sql.Date(year-1900, month, 1);
		this.gpa = gpa;
	}
	 
	public String toHTMLString()
	{
		StringBuilder sb = new StringBuilder(); 
		
		sb.append("<li>" + title + " " + major);
		
		if( specialization == 0 ) {
			
			sb.append(" <em>with a specialization in</em> " + specialization + " ");
		}
		
		sb.append(" <em>from</em> " + university + " <em>class of</em> " + (graduationDate.getYear() + 1900) + "</li>");
	
		return sb.toString();
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder(); 
		
		return sb.toString();
	}
}

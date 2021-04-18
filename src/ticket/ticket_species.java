/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;


import Location.Address;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale; 
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Justin Tham
 */
public abstract class ticket_species{
   private String open_book ;
   private String close_book;
   private String ticket_name;
   Location.Address Address;
   protected double ticket_price;
   
 
    public enum ticketstatus{
       Available,
       NotAvailable
   }

    public ticket_species(String open_book, String close_book, String ticket_name, Address Address, double ticket_price) {
        this.open_book = open_book;
        this.close_book = close_book;
        this.ticket_name = ticket_name;
        this.Address = Address;
        this.ticket_price = ticket_price;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }

   
    public String getOpen_book() {
        return open_book;
    }

    public void setOpen_book(String open_book) {
        this.open_book = open_book;
    }

    public String getClose_book() {
        return close_book;
    }

    public void setClose_book(String close_book) {
        this.close_book = close_book;
    }


    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }


    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }


   public long date_different(String close_date){
    Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
    String strDate = formatter.format(date);  
        String dateBeforeString = strDate;
	String dateAfterString = close_date;
		
	//Parsing the date
	LocalDate dateBefore = LocalDate.parse(dateBeforeString);
	LocalDate dateAfter = LocalDate.parse(dateAfterString);
		
	//calculating number of days in between
	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
//        System.out.println("Date COUNTDOWN: " +noOfDaysBetween + " day left");
        return noOfDaysBetween;
}
   
   public abstract double total_ticket_price();
}

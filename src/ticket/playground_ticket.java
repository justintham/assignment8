/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.Date;

/**
 *
 * @author Justin Tham
 */
public class playground_ticket extends ticket_species{

    private double extra_park_price;
    private double locker_rental;

    public playground_ticket(double extra_park_price, double locker_rental, String open_book, String close_book, String ticket_name, Location.Address Address, double ticket_price) {
        super(open_book, close_book, ticket_name, Address, ticket_price);
        this.extra_park_price = extra_park_price;
        this.locker_rental = locker_rental;
    }

   

    public double getLocker_rental() {
        return locker_rental;
    }

    public void setLocker_rental(double locker_rental) {
        this.locker_rental = locker_rental;
    }
 
    

    public double getExtra_park_price() {
        return extra_park_price;
    }

    public void setExtra_park_price(double extra_park_price) {
        this.extra_park_price = extra_park_price;
    }

    
         public double total_ticket_price(){
      double totalplayground =  super.ticket_price + extra_park_price + locker_rental;
        return totalplayground;
    }
   



}

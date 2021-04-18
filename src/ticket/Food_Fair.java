/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

/**
 *
 * @author Justin Tham
 */
public class Food_Fair extends ticket_species{

    public Food_Fair(String open_book, String close_book, String ticket_name, Location.Address Address, double ticket_price) {
        super(open_book, close_book, ticket_name, Address, ticket_price);
    }

    
            public double total_ticket_price(){
        double totalplayground =  super.ticket_price ;
        return totalplayground;
    }

   
}

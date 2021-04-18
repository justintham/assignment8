/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import ticket.ticket_species;

/**
 *
 * @author Justin Tham
 */
public class water_travel_ticket extends ticket_species{
    private double watersport_insurance ;

    
    public water_travel_ticket(double watersport_insurance, String open_book, String close_book, String ticket_name, Location.Address Address, double ticket_price) {
        super(open_book, close_book, ticket_name, Address, ticket_price);
        this.watersport_insurance = watersport_insurance;
    }

    public double getWatersport_insurance() {
        return watersport_insurance;
    }

    public void setWatersport_insurance(double watersport_insurance) {
        this.watersport_insurance = watersport_insurance;
    }

            public double total_ticket_price(){
        double totalplayground =  super.ticket_price + this.watersport_insurance;
        return totalplayground;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
  
/**
 *
 * @author Justin Tham
 */
public class payment {

    private String payment_date ;
    private String detail;
    private double total_payment;

    public payment(){
        
    }

    public payment(String payment_date, String detail, double total_payment) {
        this.payment_date = payment_date;
        this.detail = detail;
        this.total_payment = total_payment;
    }

    public String getPayment_date() {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now2 = LocalDateTime.now();
        return payment_date = dtf2.format(now2);
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }



    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(double total_payment) {
        this.total_payment = total_payment;
    }

    @Override
    public String toString() {
        return "Payment Date: " + payment_date + "\n" + "Ticket Name: " + detail+ "\n" + "Total Amount: RM" 
                + total_payment;
    }
    
    public double total_amount(double total_ticket_price, double total_tourist_price){
        total_payment = total_ticket_price + total_tourist_price;
        return total_payment;
    }

    
}

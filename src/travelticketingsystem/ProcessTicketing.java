package travelticketingsystem;

import ticket.ticket_species;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class ProcessTicketing extends TravelTicketing{
    
    private static char choice2;
    private static char choice2_upper;
    private static boolean continueInput = true;
    
    static void topic(){
      System.out.println("\t\t\t\t=================================");
      System.out.println("\t\t\t\t==     Welcome to the RDS      ==");
      System.out.println("\t\t\t\t==  TraveL Ticketing System    ==");
      System.out.println("\t\t\t\t=================================\n\n");
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
      LocalDateTime now = LocalDateTime.now();  
      System.out.println("Current date and time :"+dtf.format(now)+"\n\n");
      System.out.println("Step1 : Please choose the ticket type!");
      System.out.println("  1.  Amusement Park ticket");
      System.out.println("  2.  Water sports travel ticket");
      System.out.println("  3.  Food fair ticket\n");
    }

         static void receipt(Object x) {
        System.out.println("");
        System.out.println("Receipt");
        System.out.println(x.toString());
        System.out.println("");
        System.out.println("Enjoy your day, BYE BYE!!");
    }
    
     static double display_total_ticket(ticket.ticket_species object){
        return object.total_ticket_price();
    }
    
     static void wrong_input(){
        System.out.println("");
        System.out.println("Incorrect input! Please try again!");
        System.out.println("");
        System.out.println("Step1 : Please choose the ticket type!");
        System.out.println("  1.  Playground ticket");
        System.out.println("  2.  Water sports travel ticket");
        System.out.println("  3.  Food fair ticket\n");
    }
    
    static void agree_choice(ticket.ticket_species object){
        System.out.println("");
        System.out.println("Before Price: RM" + object.getTicket_price());
        System.out.println("After price: RM" + display_total_ticket(object));
    }
    
     static void invalid_choice(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Invalid alphabet!! Only type Y or N");
     choice2 = scanner.next().charAt(0);
     choice2_upper = Character.toUpperCase(choice2);
    }
    
     static void details(ticket.ticket_species object){
         Scanner scanner = new Scanner(System.in);
                System.out.println("Details: \n");
                System.out.println(object.getAddress());
                System.out.println("Price     : RM" + object.getTicket_price());
                System.out.println("Date booking: "+object.getOpen_book()+" to " + object.getClose_book());
                object.date_different(object.getClose_book());
                if(object.date_different(object.getClose_book()) >0){
                   System.out.println("Days left: "+object.date_different(object.getClose_book()));
                   System.out.println("Ticket status: " + ticket.ticket_species.ticketstatus.Available);
                }
                else{
                    System.out.println("Ticket status: " + ticket.ticket_species.ticketstatus.NotAvailable);
                    System.out.println("");
                    System.out.println("The booking date is end!\n\nPlease choose another ticket!");
                    System.out.println("  1.  Amusement Park ticket");
                    System.out.println("  2.  Water sports travel ticket\n");
                }
    }
     
    public static void main(String[] args){
    topic();      
    Scanner scanner = new Scanner(System.in);
    int choice;
    char add1,add2;
    boolean addInput = true;
    payment.payment payment = new payment.payment();
    ticket.ticket_species.ticketstatus status1 = ticket.ticket_species.ticketstatus.Available;
    ticket.ticket_species.ticketstatus status2 = ticket.ticket_species.ticketstatus.NotAvailable;
       
    do{
        try{
        System.out.println("Your choice:");
        choice = scanner.nextInt();  
        System.out.println("");  
        
        switch(choice){
            case 1:System.out.println("");
               Location.Address playground_address = new Location.Address("Unit 4-1, Level 4 Avenue K Shopping Mall, 156,Jalan Ampang,","Kuala Lumpur,","50450,","Malaysia");
               ticket.playground_ticket playground_ticket = new ticket.playground_ticket(103.20, 20, "2021-03-12", "2021-08-23", "SuperPark Malaysia", playground_address, 302); 
               details(playground_ticket);
                 if(playground_ticket.date_different(playground_ticket.getClose_book())> 0){
                System.out.println("");
                System.out.println("Expense exclusion:\n1)Extreme Park Rides(RM" + playground_ticket.getExtra_park_price()+")" );
                System.out.println("2)Equipments: Locker rental(" +playground_ticket.getLocker_rental() + ")" );
                System.out.println("");
                System.out.println("Do you want to add Extreme Park Rides or locker?  [Y/N]");
                choice2 = scanner.next().charAt(0);
                choice2_upper = Character.toUpperCase(choice2);
                first2:{
                    while(choice2 != 'y' && choice2 != 'n'&&choice2_upper != 'Y' && choice2_upper != 'N'){
                    invalid_choice();
    }
                    second2:{
                        if(choice2 == 'y' || choice2_upper == 'Y' ){
//                          agree_choice(playground_ticket);
                            do{
                                System.out.println("");
                            System.out.println("1)Extreme Park Rides(RM" + playground_ticket.getExtra_park_price()+")");
                            System.out.println("2)Equipments: Locker rental(" +playground_ticket.getLocker_rental() + ")" );
                            System.out.println("Type 0 if you don't want to add.");
                            System.out.println("You want to add:");
                             add1 = scanner.next().charAt(0);
                            System.out.println("and");
                             add2 = scanner.next().charAt(0);
                            if((Character.getNumericValue(add1) == 1 && Character.getNumericValue(add2)== 0 )||(Character.getNumericValue(add1) == 0 && Character.getNumericValue(add2)== 1 )){
                                playground_ticket.getExtra_park_price();
                                 playground_ticket.setLocker_rental(0);
                                playground_ticket.total_ticket_price();
                                agree_choice(playground_ticket);
                                                            break first2;
                            }
                            else if((Character.getNumericValue(add1) == 2 && Character.getNumericValue(add2)== 0 )||(Character.getNumericValue(add1) == 0 && Character.getNumericValue(add2)== 2 )){
                                playground_ticket.setExtra_park_price(0);
                                playground_ticket.getLocker_rental();
                                playground_ticket.total_ticket_price();
                                agree_choice(playground_ticket);
                                                            break first2;
                            }
                            else if((Character.getNumericValue(add1) == 2 && Character.getNumericValue(add2)== 1 )||(Character.getNumericValue(add1) == 1 && Character.getNumericValue(add2)== 2 )){
                                playground_ticket.getExtra_park_price();
                                playground_ticket.getLocker_rental();
                                playground_ticket.total_ticket_price();
                                agree_choice(playground_ticket);
                                                            break first2;
                            }
                            else if((Character.getNumericValue(add1) == 0 && Character.getNumericValue(add2)== 0 )){
                                playground_ticket.setExtra_park_price(0);
                                playground_ticket.setLocker_rental(0);
                                playground_ticket.total_ticket_price();
                                agree_choice(playground_ticket);
                                                            break first2;
                            }
                            else {
                                System.out.println("\nWrong Input!!\nPlease try again!");
                            }
    }while((Character.getNumericValue(add1) != 1 && Character.getNumericValue(add2)!= 1 )||(Character.getNumericValue(add1) != 2 && Character.getNumericValue(add2)!= 2 ));
                             
                     break first2;
                        }
                        third2:{
                            if(choice2 == 'n'|| choice2_upper == 'N'){
                                System.out.println("");
                                playground_ticket.setExtra_park_price(0);
                                playground_ticket.setLocker_rental(0);
                                System.out.println("Ticket price: RM" + display_total_ticket(playground_ticket));
                                break first2;
                            }
                        }
                    }
                }     
                //QINGZHI
//    //QINGZHI
    double total_tourist;
                     tourist.adult ad1 = new tourist.adult("ad1","place1");
                 tourist.adult ad2 = new tourist.adult("ad2","place2");
                 tourist.child ch1 = new tourist.child("ch1","childplace1");
                  tourist.child ch2 = new tourist.child("ch2","childplace2");
                  tourist.child ch3 = new tourist.child("ch3","childplace3");
                    ad1.display();
                    System.out.println(ad1.toString());
                    ch1.display();
                    System.out.println(ch1.toString());
                    System.out.println("");
                    System.out.println(tourist.adult.getAdultCount() + " Adult with " + tourist.child.getChildCount()+" Children.");
                                        tourist.ticket ticket = new tourist.ticket();
                                        total_tourist = ticket.total_tourist((tourist.adult.getAdultCount()*tourist.adult.getPriceAdult()), (tourist.child.getChildCount()*tourist.child.getPriceChild()));
                    System.out.println("Total Price :" + total_tourist);
//PAYMENTS
                receipt(new payment.payment(payment.getPayment_date(),playground_ticket.getTicket_name(),payment.total_amount(playground_ticket.total_ticket_price(),total_tourist)));
                continueInput = false;
                } 
                 break;
                 
            case 2:
                    Location.Address water_sport_address = new Location.Address("Tioman Island,","Mersing,","86800,","Pahang");
                    System.out.println("");
                    ticket.water_travel_ticket water_travel = new ticket.water_travel_ticket(15.50, "2021-03-12", "2021-07-03", "Gordons Bay Snorkel", water_sport_address, 421);
                    details(water_travel);
                    if(water_travel.date_different(water_travel.getClose_book())> 0){
                System.out.println("");
                System.out.println("Insurance is RM"+water_travel.getWatersport_insurance());
                System.out.println("Do you want to add travel insurance?  [Y/N]");
                 choice2 = scanner.next().charAt(0);
                choice2_upper = Character.toUpperCase(choice2);
                first2:{
                    while(choice2 != 'y' && choice2 != 'n'&&choice2_upper != 'Y' && choice2_upper != 'N'){
                    invalid_choice();
    }
                    second2:{
                        if(choice2 == 'y' || choice2_upper == 'Y' ){
                            agree_choice(water_travel);
                            break first2;
                        }
                        third2:{
                            if(choice2 == 'n'|| choice2_upper == 'N'){
                                System.out.println("");
                                water_travel.setWatersport_insurance(0);
                               System.out.println("Ticket price: RM" + display_total_ticket(water_travel));
                                break first2;
                            }
                        }
                    }
                }    
               //    //QINGZHI
    double total_tourist;
                     tourist.adult ad1 = new tourist.adult("ad1","place1");
                 tourist.adult ad2 = new tourist.adult("ad2","place2");
                 tourist.child ch1 = new tourist.child("ch1","childplace1");
                  tourist.child ch2 = new tourist.child("ch2","childplace2");
                  tourist.child ch3 = new tourist.child("ch3","childplace3");
                    ad1.display();
                    System.out.println(ad1.toString());
                    ch1.display();
                    System.out.println(ch1.toString());
                    System.out.println("");
                    System.out.println(tourist.adult.getAdultCount() + " Adult with " + tourist.child.getChildCount()+" Children.");
                                        tourist.ticket ticket = new tourist.ticket();
                                        total_tourist = ticket.total_tourist((tourist.adult.getAdultCount()*tourist.adult.getPriceAdult()), (tourist.child.getChildCount()*tourist.child.getPriceChild()));
                    System.out.println("Total Price :" + total_tourist);
                 //PAYMENT
                receipt(new payment.payment(payment.getPayment_date(),water_travel.getTicket_name(),payment.total_amount(water_travel.total_ticket_price(),total_tourist)));
                continueInput = false;
                }             
                break;
            case 3:
                Location.Address food_fair_address = new Location.Address("Concourse Level, Lower Ground,", "Kuala Lumpur City Centre,", "50088,", "Malaysia Kula MY");
                ticket.Food_Fair food_fair = new ticket.Food_Fair("2021-03-12", "2021-04-03", "Malaysian International Food & Beverage Trade Fair", food_fair_address, 80);
                details(food_fair);
                break;
            default:
                wrong_input();
                continueInput = true;
                break;
        }
        }catch(Exception ex){
         wrong_input();
         scanner.nextLine();   
        }
    }while(continueInput);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

/**
 *
 * @author Developer (www.voidsofttech.com)
 */

import java.util.Scanner;
public class days_species {
    private static boolean continueInput = true;
    private int wday=0;
    private int wend=0;
     
     public days_species(){
    Scanner scanner = new Scanner(System.in);
    int choice;
    
    topic();
    
        do{
        try{
        System.out.println("Your choice:");
        choice = scanner.nextInt();  
        System.out.println("");  
        
        switch(choice){
            case 1:System.out.println("");
        
                System.out.println("Please enter number of week days: ");
                wday = scanner.nextInt();  
                System.out.println("");  
                while(wday>7){
                    wday=wday-7;
                    wend++;
                }
                 continueInput = false;
                 break;
                 
            case 2:
                System.out.println("");
        
                System.out.println("Please enter number of weekend: ");
                wend = scanner.nextInt();  
                System.out.println("");  
        
                continueInput = false;
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
          
    static void topic(){
      System.out.print("\n");
      System.out.println(" Please choose the discount type!");
      System.out.println("  1.  Weekday");
      System.out.println("  2.  Weekend\n");
    }

          
      static void wrong_input(){
        System.out.println("");
        System.out.println("Incorrect input! Please try again!");
        System.out.println("");
        System.out.println(" Please choose the discount type!");
        System.out.println("  1.  Weekday");
        System.out.println("  2.  Weekend\n");
    }
      
      public int getWeekdays() {
   
        return this.wday;
    }
      
      public void setWeekdays(int weekday) {
   
         this.wday=weekday;
    }
      public void setWeekends(int weekend) {
   
         this.wend=weekend;
    }
    
      public int getWeekends() {
   
        return this.wend;
    }
      
           public static void main(String[] args){
                days_species ss=new days_species();
                System.out.println(" weekdays:" );
                System.out.println(ss.wday);
                System.out.println(" weekends:" );
                System.out.println(ss.wend);
           }
    
}

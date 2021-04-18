package payment;

// Java program for Method overriding

import java.util.Scanner;
import static payment.days_species.topic;


class Parent {
 static boolean continueInput = true;
    int wday=0;
    int wend=0;
        
        
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
}

class Weekday extends Parent {

Scanner scanner = new Scanner(System.in);
	 public void setWeekdays(int weekend) {
        
        
         this.wday=weekend;
    }
    
      public int getWeekdays() {
   
        return this.wday;
    }

    
    
}

class Weekends extends Parent {
  Scanner scanner = new Scanner(System.in);
	 public void setWeekends(int weekend) {
        
        
         this.wend=weekend;
    }
    
      public int getWeekends() {
   
        return this.wend;
    }
}




class DaySpecies {
	
          static boolean continueInput = true;

      static void wrong_input(){
        System.out.println("");
        System.out.println("Incorrect input! Please try again!");
        System.out.println("");
        System.out.println(" Please choose the discount type!");
        System.out.println("  1.  Weekday");
        System.out.println("  2.  Weekend\n");
    }
    public DaySpecies()
	{
	Parent a;

		

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
        
		a = new Weekday();
                System.out.println("Please enter number of week days: ");
                a.setWeekdays(scanner.nextInt());  
                System.out.println("");  
                while(a.wday>7){
                    a.wday=a.wday-7;
                    a.wend++;
                }
                 continueInput = false;
                 break;
                 
            case 2:
                a = new Weekends();
                
                  System.out.println("");
                System.out.println("Please enter number of weekend: ");
                a.setWeekends(scanner.nextInt());

                a.continueInput = false;
                break;
            default:
                wrong_input();
                continueInput = true;
                break;
        }
        }catch(Exception ex){
        //new= Parent();
            wrong_input();
         scanner.nextLine();   
        }
    }while(continueInput);
    
            
            
            
            
            
            
		
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourist;

/**
 *
 * @author user10
 */
public class adult extends ticket  {
     //private String id;
     //private int orderId;
     //private String group;
     private static int adultCount;
     private String ticketadultType;
   
//     private String[]adultTest;
    // private int noOfAdult;
//     private static final int MAX=20;
     private static double priceAdult=19.90;
    
    public adult(){}
    
    public adult(String id,String ticketadultType) {
        super(id);
        //this.orderId=orderId;
        //this.noOfAdult=0;
        this.ticketadultType=ticketadultType;
//        this.adultTest=new String[MAX];
        adult.adultCount++;
       //something count++
    }

    public static int getAdultCount() {
        return adultCount;
    }

//    public static void setAdultCount(int adultCount) {
//        adult.adultCount = adultCount;
//    }
    
    
  
//    public int getNoOfAdult() {
//        return noOfAdult;
//    }
//
//    public void setNoOfAdult(int noOfAdult) {
//        this.noOfAdult = noOfAdult;
//    }


//    public String[] getAdultTest() {
//        return adultTest;
//    }

//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//    
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getTicketadultType() {
        return ticketadultType;
    }

//    public void setTicketadultType(String ticketadultType) {
//        this.ticketadultType = ticketadultType;
//    }

   
    

//    public void setAdultTest(String[] adultTest) {
//        this.adultTest = adultTest;
//    }

//    public static double getPriceAdult() {
//        return priceAdult;
//    }
//
//    public static void setPriceAdult(double priceAdult) {
//        adult.priceAdult = priceAdult;
//    }

    public static double getPriceAdult() {
        return priceAdult;
    }
    
    
//      public double calcFeesAdult(){
//        
//    return this.adultCount * this.priceAdult;
//    }
    
//    public static void totalAdultPrice(){}
//
//            public void cusAdult(String adultName){
//            method body
//            adultTest[noOfAdult]=adultName;
//            noOfAdult++;
//            }
           public void display(){
               System.out.println("\nTotal Adult :"+adult.getAdultCount()+"\nAdult per fees :"+ adult.getPriceAdult()+"\nTotal Adult Price :"+adult.getAdultCount()*adult.getPriceAdult());
           }

    @Override
    public String toString() {
        return super.toString()+  "ticketadultType=" + ticketadultType + '}';
        
    }

}
            
           

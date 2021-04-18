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
public class child extends ticket {
//      private String nameChild;
      private static int childCount;
//      private int noOfChild;
      private static double priceChild=9.90;
      private String ticketchildType;
       //private String[]ChildId;
      //     private static final int MAX=20;

    public child() {
    }

    public child( String id, String ticketchildType) {
        super(id);
//        this.nameChild = nameChild;    
        this.ticketchildType=ticketchildType;
//        this.noOfChild=0;
        child.childCount++;
    }
//       public child(String nameChild,int orderId) {
//           //super();
//        this.nameChild = nameChild;
//        this.noOfChild=0;
//       //something count++
//       child.childCount++;
//    }
      
     
    public static int getChildCount() {
        return childCount;
    }

//    public static void setChildCount(int childCount) {
//        child.childCount = childCount;
//    }

//    public int getNoOfChild() {
//        return noOfChild;
//    }
//
//    public void setNoOfChild(int noOfChild) {
//        this.noOfChild = noOfChild;
//    }

//    public String getNameChild() {
//        return nameChild;
//    }
//
//    public void setNameChild(String nameChild) {
//        this.nameChild = nameChild;
//    }

    public String getTicketchildType() {
        return ticketchildType;
    }

//    public void setTicketchildType(String ticketchildType) {
//        this.ticketchildType = ticketchildType;
//       public double calcFeesChild(){
//        
//    return this.noOfChild*this.priceChild;
//    }

    public static double getPriceChild() {
        return priceChild;
    }
      
    public void display(){
               System.out.println("\nTotal Child :"+child.getChildCount()+"\nChild per fees :"+ child.getPriceChild()+"\nTotal Child Price :"+child.getChildCount()*child.getPriceChild());
           }   

    @Override
    public String toString() {
        return super.toString()+  "ticketchildType=" + ticketchildType + '}';
    }

    
    
   
}
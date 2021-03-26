// Author: Andrew Cosgrove <(-.O)>
// Date: 25JAN2021
// Title: Book.java
// Description: Book class creates Book object, uses Inventory.java as data handler, TestBook.java as main method.

public class Book 
{
   final private int id;
   final private String title;
   final private double price;
   
   public Book(int id, String title, double price)
   {
      //validation handled in inventory class
      this.id = id;
      this.price = price;
      this.title = title;
   }
   
   //get methods
   public int getId()
   {
      return id;
   }
   
   public String getTitle()
   {
      return title;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   public String toString()
   {
      return String.format("- Book ID: %d, TITLE: %s, - PRICE: $ %.2f%n", getId(), getTitle(), getPrice());
   }

}
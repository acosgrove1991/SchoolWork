// Author: Andrew Cosgrove <(-.O)>
// Date: 05-FEB-2021
// Title: Gift.java
// Description: Superclass for FruitBasket.java and SweetBasket.java.

public class Gift 
{
   private String id;
   private char size;
   private double price;
   private boolean option;
   private int quantity;
   
   public Gift(String id, char size)
   {
      //validate 5 digigts of id
      if(!id.matches("[a-zA-Z0-9]{6}"))
         System.out.println("ERROR: ID must be 5 digits...");
      else
         this.id = id;
      
      //convert character to string forvalidation
      String sizeStr = String.valueOf(size);
      
      if (Character.isAlphabetic(size) && sizeStr.matches("[smlSML]{1}"))
         this.size = size;
      
      else
         System.out.println("ERROR: Invalid size...");
   }
   
   
   //Get methods
   public String getId()
   {
      return id;
   }
   
   public char getSize()
   {
      return size;
   }
   
   //this method will be overriden FruitBasket or SweetsBAsket
   public boolean getOption()
   {
      return option;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   public int getQuantity()
   {
      return quantity;
   }
   
   //set methods
   //set quantity and price based on size
   public void setPrice(char size)
   {
      switch (size)
      {
         case 'S':
            this.price = 19.99;
            this.quantity = 6;
            break;
         case 'M':
            this.price = 29.99;
            this.quantity = 9;
            break;
         case 'L':
            this.price = 39.99;
            this.quantity = 15;
            break;
         default:
            System.out.println("ERROR: Invalid size selection...");
            break;
      }
   }
    
   public void setSize(char size)
   {
      this.size = size;
      setPrice(size);
   }
   
   //this method will be overriden by either citrus or nuts
   public void setOption(boolean option)
   {
      this.option = option;
   }
   
   public String toString()
   {
      return String.format("%n - Gift %s: Gift Size: %s, Price: $%.2f, Option: %b", getId(), getSize(), getPrice(), getOption());
   }

}

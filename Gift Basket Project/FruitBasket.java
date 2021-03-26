// Author: Andrew Cosgrove <(-.O)>
// Date: 05-FEB-2021
// Title: FruitBasket.java
// Description: Child class of Gift.java.

public class FruitBasket extends Gift
{
   private boolean option;
   private int quantity;
   private double price;
   private char size;
   
   public FruitBasket(String id, char size, boolean option)
   {
      super(id, size);
      
      this.option = option;
   }
   
   
   
   //overrides Gift class to set price and quanity since the coincide with each other with boolean
   @Override
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
      
      if (option == true)
         this.price = price + 5.99;
   }
   
   @Override
   public void setSize(char size)
   {
      this.size = size;
      setPrice(size);
   }
   
   @Override
   public void setOption(boolean option)
   {
      this.option = option;
      setPrice(size);
   }
   
   //get methods
   
   @Override
   public boolean getOption()
   {
      return option;
   }
   
   @Override
   public double getPrice()
   {
      return price;
   }
   
   @Override
   public int getQuantity()
   {
      return quantity;
   }
   
   @Override
   public String toString()
   {
      return String.format("%n - Gift %s: Fruit Basket size: %s, Fruit: %d, Price: $%.2f, Citrus: %b", getId(), getSize(), getQuantity(), getPrice(), getOption());
   }

}

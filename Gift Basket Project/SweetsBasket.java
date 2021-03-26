// Author: Andrew Cosgrove <(-.O)>
// Date: 08-FEB-2021
// Title: SweetsBasket.java
// Description: Subclass to Gift. 

public class SweetsBasket extends Gift
{
   private boolean option;
   
   public SweetsBasket(String id, char size, boolean option)
   {
      super(id,size);
      
      this.option = option;
   }
   
   
   @Override
   public String toString()
   {
      return String.format("%n -Gift %s: Sweets Basket size : %s, Sweets: %d, Price: $%.2f, Nuts: %b",  getId(), getSize(), getQuantity(), getPrice(), getOption());
   }

}
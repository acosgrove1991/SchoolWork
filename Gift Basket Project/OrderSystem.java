// Author: Andrew Cosgrove <(-.O)>
// Date: 08-FEB-2021
// Title: OrderSystem.java
// Description: main for Gift.java and subclasses.
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem
{
   private static Gift gift;

   private static void menu()
   {
      System.out.printf("%n[SWEETS AND FRUITS STORE]"
              + "%n1) Order Gift Basket"
              + "%n2) Change Gift Basket"
              + "%n3) Display Gift Basket"
              + "%n9) Exit program%n");
   }

   private static void proccessOption(int option)
   {
      switch (option)
      {
         case 1:
            orderGift();
            break;
         case 2:
            changeGift();
            break;
         case 3:
            displayGift();
            break;
         case 9:
            System.out.printf("%nExiting... Thanks for Shopping!%n%n");
            break;
         default:
            System.out.println("Please select a valid option from menu.");
      }
   }

   private static void orderGift()
   {
      //variable lists
      Scanner stdin = new Scanner(System.in);
      String characters = "0123456789ABCDEFGHIJK0123456789LMNOPQRSTUVWXYZ0123456789"; //used to build ID
      StringBuilder idBuilder = new StringBuilder(6);//used to build id
      String id;
      int selection;
      char size;
      boolean option;
      String optionStr;
      
      //validate order does not already exists
      if (gift != null)
      {
         System.out.println("ERROR: Gift is already created...");
         return;
      }
 
      
      //Create id by creating a random string
      for (int i = 0; i < 6; i++)
      {
         int random = (int)(characters.length() * Math.random());
         
         idBuilder.append(characters.charAt(random));
      }
      //copy idBuilder to id
      id = String.valueOf(idBuilder);
      
      //Create order
      try
      {
         //Select fruit basket or sweets
         System.out.printf("%n[CREATE ORDER]%n");
         System.out.print("Select Fruit Basket(1) or Sweets Basket(2):  ");
         selection = stdin.nextInt();

         //validate option
         if (selection > 2 || selection < 1)
         {
            System.out.println("ERROR: Invalid selection...");
            return;
         }

         //-----------------------------------------------------
         //Select size
         System.out.print("Select size (L, M, S): ");
         char sizeLow = stdin.next().charAt(0);

         //change character to uppercase
         size = Character.toUpperCase(sizeLow);

         //validate character
         switch (size)
         {
            case 'S':
               break;
            case 'M':
               break;
            case 'L':
               break;
            default:
               System.out.println("ERROR: Invalid size selection...");
               return;
         }

         //specifier = nuts or citrus based on selection
         if (selection == 1)
         {
            optionStr = "Citrus Fruit";
         } 
         else
         {
            optionStr = "Nuts";
         }
         
         //use optionStr as string specifier
         System.out.printf("Add %s? (yes/no): ", optionStr);
         String optionSelect = stdin.next();

         //convert optionSelect to boolean
         if (optionSelect.equalsIgnoreCase("yes") || optionSelect.equalsIgnoreCase("y"))
         {
            option = true;
         } else if (optionSelect.equalsIgnoreCase("no") || optionSelect.equalsIgnoreCase("n"))
         {
            option = false;
         } else
         {
            System.out.println("ERROR: Invalid selection...");
            return;
         }

         //create instance based on selection
         if (selection == 1)
         {
            gift = new FruitBasket(id, size, option);
            gift.setPrice(size);
         } else
         {
            gift = new SweetsBasket(id, size, option);
            gift.setPrice(size);
         }
         System.out.printf("%nOrder Successfull! %s%n", gift.toString()); 
      } //end try
      catch (InputMismatchException inputMismatchException)
      {
         System.out.println("ERROR: Invalid option...");
         stdin.next();
      }
   }//end orderGift()

   private static void changeGift()
   {
      Scanner stdin = new Scanner(System.in);
      String optionStr;

      //verify list is not empty
      if (gift == null)
      {
         System.out.println("ERROR: Gift has not been created...");
         return;
      }

      //prompt
      System.out.printf("%n[CHANGE ORDER]");
      
      try
      {
         //ask user to change size
         System.out.print("Current size [" + gift.getSize() + "], change size(L, M, S): ");
         char sizeLow = stdin.next().charAt(0);

         //change character to uppercase
         char size = Character.toUpperCase(sizeLow);

         //validate character
         switch (size)
         {
            case 'S':
               break;
            case 'M':
               break;
            case 'L':
               break;
            default:
               System.out.println("ERROR: Invalid size selection...");
               return;
         }

         gift.setSize(size);

         //------------------------------------------------
         //if FruitBasket or SweetsBAsket
         if (gift instanceof FruitBasket)
            optionStr = "Citrus Fruit";
         else
            optionStr = "Nuts";
         
         System.out.printf("%s option [" + gift.getOption() + "], Add %s?(yes/no): ", optionStr, optionStr);
         String optionSelect = stdin.next();

         if (optionSelect.equalsIgnoreCase("yes") || optionSelect.equalsIgnoreCase("y"))
         {
            gift.setOption(true);
         } 
         else if (optionSelect.equalsIgnoreCase("no") || optionSelect.equalsIgnoreCase("n"))
         {
            gift.setOption(false);
         } 
         else
         {
            System.out.println("ERROR: Invalid selection...");
            return;
         }
         //display changes
         System.out.println("UPDATED: " + gift.toString());
         
      }// end try
      
      catch (InputMismatchException inputMismatchException)
      {
         System.out.println("ERROR: Invalid option...");
         stdin.next();
      }
   }//end changeGift()
   
   private static void displayGift()
   {
      //validate if gift is created...
      if (gift == null)
      {
         System.out.println("ERROR: Gift has not been created...");
      }
      else
      {
         System.out.printf("%n[DISPLAY] %s%n", gift.toString());
      }
   }
   
   public static void main(String[] args)
   {
      try (Scanner stdin = new Scanner(System.in))
      {
         int option = 0;
         
         do
         {
            menu();
            try
            {
               System.out.print("Enter option: ");
               option = stdin.nextInt();
            }
            catch (InputMismatchException inputMismatchException)
            {
               System.err.println("ERROR: Invalid option...");
               stdin.next();
            }
            proccessOption(option);
            
         }while(option != 9);
      }
   }
}
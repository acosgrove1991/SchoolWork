// Author: Andrew Cosgrove <(-.O)>
// Date: 26-JAN-2020
// Title: RunIventory.java
// Description: main method uses Inventory.java to manage objects, Book.java to create objects
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunInventory 
{
   public static void main(String[] args)
   {
      Inventory inventory = new Inventory();
      try (Scanner stdin = new Scanner(System.in))
      {
         int option = 0;
         
         do
         {
            inventory.mainMenu();
            try
            {
               System.out.print("Enter option: ");
               option = stdin.nextInt();
            }
            catch (InputMismatchException inputMismatchException)
            {
               System.err.println("ERROR: INVALID");
               stdin.next();
            }
            inventory.proccessOption(option);
            
         }while(option != 9);
      }
   }
}
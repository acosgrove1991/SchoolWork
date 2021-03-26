// Author: Andrew Cosgrove <(-.O)>
// Date: 25-JAN-2021
// Title: Iventory.java
// Description:
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory 
{
   ArrayList<Book> bookList;
   
   public Inventory()
   {
      //create list to add books
      bookList = new ArrayList<>();
   }
   
   //displays main menu options
   public void mainMenu()
   {
      System.out.printf("%n   [LIBRARY MENU]"
        + "%n1) Add Book"
        + "%n2) Remove Book"
        + "%n3) Find book"
        + "%n4) Display all books"
        + "%n9) Exit program%n");
   }
   
   //option from main method as arugment, argument used in switch case to execute methods.
   public void proccessOption(int option)
   {
      switch(option)
      {
         case 1: 
            addBook();
            break;
         case 2: 
            removeBook();
            break;
         case 3:
            findBook();
            break;
         case 4:
            displayBooks();
            break;
         case 9:
            System.out.println("Exiting program...");
         default:
            System.out.println("Please select a valid option from menu.");
      }
   }
   
   private void addBook()
   {
      Scanner stdin = new Scanner(System.in);
      
      //prompt user for data
         try
         {
            System.out.printf("%n[ADD BOOK]%n");
            System.out.print("What is the 5 digit book ID? ");
            int id = stdin.nextInt();
            
            //validate if there are 5 digits
            String stringId = String.valueOf(id); //used in validation
            if(!stringId.matches("[0-9]{5}"))
              {
                 System.out.println("ERROR: ID must contain 5 digits...");
                 return;
              }
            
            stdin.nextLine(); //consumes next line, in case title is 2 strings
            System.out.print("What is the book title? ");
            String title = stdin.nextLine();
            
            //validate that title is not empty.
            if (title.isEmpty() || title == "")
            {
               System.out.println("ERROR: Title cannot be blank...");
               return;
            }
            
            System.out.print("What is the book price? $");
            double price = stdin.nextDouble();
            if (price == 0)
            {
               System.out.println("ERROR: Field cannot be empty...");
               return;
            }
            
            //if book list is empty, add Book object, break loop
            if (bookList.isEmpty())
            {
               Book book = new Book(id, title, price); //create book object
               bookList.add(book); //add book to list
               System.out.printf("%n*Book %d: %s added to library*%n", id, title);
               return;
            }

            //validation if book id exists
            for(Book b : bookList)
            {
              if(b.getId() == id) //if object exists, break loop.
              {
                 System.out.println("ERROR: A book already exists with this ID...");
                 return;
              }
              else //if book ID does not exist, create Book object, add to list, break loop.
              {
                  Book book = new Book(id, title, price); //create book object
                  bookList.add(book); //add book to list
                  System.out.printf("%n*Book %d: %s added to library*%n", id, title);
                  return;
              }
            }
         }
         catch (InputMismatchException inputMismatchException)
         {
            System.out.println("ERROR: Invalid option...");
            stdin.next();
         }
         

   }
   
   private void removeBook()
   {
      Scanner stdin = new Scanner(System.in);
      
      //check if book list is empty
      if (bookList.isEmpty())
      {
         System.out.printf("%nERROR: Library is empty...%n");
         return;
      }
      
      try
      {
         //prompt user for data if list is not empty
         System.out.printf("%n[REMOVE BOOK]%n");
         System.out.print("What is the 5 digit book ID? ");
         int id = stdin.nextInt();
         
         //validate that there are 5 digits
         String stringId = String.valueOf(id); 
         if(!stringId.matches("[0-9]{5}"))
         {
            System.out.println("ERROR: ID must contain 5 digits...");
            return;
         }

         //extract list
         for(int i = 0; i < bookList.size(); i++)
         {
            Book b = bookList.get(i);
            if(b.getId() == id)
            {
               bookList.remove(b); 
               System.out.printf("*Book %d: %s removed*%n", b.getId(), b.getTitle());
               return;
            }
            else
               System.out.println("ERROR: Book ID does not exist...");
         } 
      }
      //catch for invalid input
      catch (InputMismatchException inputMismatchException)
      {
         System.out.println("ERROR: Invalid option...");
         stdin.next();
      } 
   } 
  
 
   
   private void findBook()
   {
      Scanner stdin = new Scanner(System.in);
      
      //prompt user for data
      try
      {
         System.out.print("What is the 5 digit book ID? ");
         int id = stdin.nextInt();
         String stringId = String.valueOf(id); //used in validation
         
         //checks if string is 5 digits
         if(!stringId.matches("[0-9]{5}"))
            System.out.println("ERROR: ID must contain 5 digits...");

         //checks if bookList is empty, if false, go through list
         if (bookList.isEmpty())
            System.out.println("Books list is empty...");
         else
         {
            for(int i = 0; i < bookList.size(); i++)
            {
              Book b = bookList.get(i); //extract instances of Book 
              if(b.getId() == id) //compare to IDS
              {
               System.out.println(b.toString());
              }

              else
                 System.out.println("ERROR: Book ID does not exist...");
            }  
         }
      }
      catch (InputMismatchException inputMismatchException)
      {
         System.out.print("ERROR: Invalid option...");
      }
       
   }
   
   public void displayBooks()
   {
      //check if listis empty, if false. print books
      if (bookList.isEmpty())
         System.out.printf("%nLibrary is empty...%n");
      else
      {
         for(Book b: bookList)
         {
           System.out.print(b.toString());
         }  
      }
      
   }
   
}//end class

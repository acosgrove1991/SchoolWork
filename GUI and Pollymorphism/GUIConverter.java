// Author: Andrew Cosgrove <(-.O)>
// Date: 23-FEB-2021
// Title: GUIConverter.java
// Description: Class creates GUI interfaces and is main method to 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIConverter
{

   private static class Handler implements ActionListener
   {

      private JFrame frame = null; // setup frame to be used in JOptionPane
      private boolean tempConvert; //used to create object

      public Handler(JFrame frame, boolean tempConvert)
      {
         this.frame = frame;
         this.tempConvert = tempConvert;
      }

      public void actionPerformed(ActionEvent e)
      {
         //variables used in method
         String inputStr;
         Converter convertObj;
         double inputDouble;
         boolean condition = false;
         
         // display input JOptionPane with input validation
         do
         {
            try
            {
               if (tempConvert == true)
               {
                  inputStr = JOptionPane.showInputDialog(
                          frame, "Input fahrenheit temperature to convert to Celius");
               } 
               else
               {
                  inputStr = JOptionPane.showInputDialog(
                          frame, "Input miles to convert to Kilo Meters");
               }

               // validation: check if inputStr is null(user has hit the x button, exit program)
               if (inputStr == null)
                  System.exit(0);

               // convert inputStr to double
               inputDouble = Double.parseDouble(inputStr);

               // check if double is null
               if (inputDouble == Double.NaN)
                  System.exit(0);

               // create object using inputDouble depending on boolean
               if (tempConvert == true)
                  convertObj = new TemperatureConverter(inputDouble);
               else
                  convertObj = new DistanceConverter(inputDouble);

               // display results
               JOptionPane.showMessageDialog(null, convertObj.toString());
               break;
            }//end try  
            
            //catches to catch if entry is null or if input is incorrect
            catch (InputMismatchException | NumberFormatException ime)
            {
               JOptionPane.showMessageDialog(frame, "Please enter a valid number...");
            } 
            
         } while (condition == false);//end while
      }//end actionPerformed
   }//end Handler

// exit event handler
   private static class ExitHandler implements ActionListener
   {

      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }

   public static void main(String[] args)
   {
      // create JButton instances
      JButton tempButton = new JButton("Temperature Converter");
      JButton distButton = new JButton("Distance Converter");
      JButton exitButton= new JButton("EXIT");
      
      // create frame
      JFrame frame = new JFrame("Convert Miles or Temperature");

      // add buttons to the panel
      JPanel content = new JPanel();
      content.setLayout(new BorderLayout());

      // create listeners and add to buttons
      Handler tempListener = new Handler(frame, true);
      tempButton.addActionListener(tempListener);

      ExitHandler exitListener = new ExitHandler();
      exitButton.addActionListener(exitListener);

      Handler distListener = new Handler(frame, false);
      distButton.addActionListener(distListener);

      // add buttons to panel
      content.add(tempButton, BorderLayout.EAST);
      content.add(distButton, BorderLayout.WEST);
      content.add(exitButton, BorderLayout.SOUTH);
      

      // adds content we created above
      frame.setContentPane(content);

      // setup size and location
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(325, 200);// sets size of the window
      frame.setLocation(800, 400);// sets x,y location where it should display
      frame.setVisible(true); // makes it visible
   }
}
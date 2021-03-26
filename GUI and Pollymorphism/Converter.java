// Author: Andrew Cosgrove <(-.O)>
// Date: 21-FEB-2021
// Title: Converter.java
// Description: Superclass to TemperatureCoverter and DistanceConverter

public class Converter 
{
   private double dataInput;
   private float dataOutput;
   
   //default constructor
   public Converter()
   {
      dataInput = 0.0;
      dataOutput = (float) 0.0;
   }
   
   //overloaded constructor
   public Converter(double dataInput)
   {
      this.dataInput = dataInput;
      convert(dataInput);
   }
   
   //set method
   public void setDataInput(double dataInput)
   {
      this.dataInput = dataInput;
   }
   
   //get method
   public double getDataInput()
   {
      return dataInput;
   }
   
   public float getDataOutput()
   {
      return dataOutput;
   }
   
   //covert method
   public void convert(double dataInput)
   {
      dataOutput = (float)dataInput + 0;
   }
   
}

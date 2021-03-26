// Author: Andrew Cosgrove <(-.O)>
// Date: 21-FEB-2021
// Title: TemperatureConverter
// Description: Subclass of Converter superclass, used to calculate and create temperature object.

public class TemperatureConverter extends Converter
{
   private float dataOutput;
   
   public TemperatureConverter(double dataInput)
   {
      super(dataInput);
  
      convert(dataInput);
   }
   
   @Override
   public void convert(double dataInput)
   {
      dataOutput = (float)(dataInput - 32) * 5  / 9;
   }
   
   @Override
   public float getDataOutput()
   {
      return dataOutput;
   }
   
   @Override
   public String toString()
   {
      return String.format("%.1fF\u00B0 equals %.2fC\u00B0", getDataInput(), getDataOutput());
   }
}
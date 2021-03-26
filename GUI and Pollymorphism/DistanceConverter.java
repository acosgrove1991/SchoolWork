// Author: Andrew Cosgrove <(-.O)>
// Date: 21-FEB-2021
// Title: DistanceConverter.java
// Description: Subclass of Converter superclass, used to calculate and create distance object.

public class DistanceConverter extends Converter
{
   private float dataOutput;
   
   public DistanceConverter(double dataInput)
   {
      super(dataInput);
  
      convert(dataInput);
   }
   
   @Override
   public void convert(double dataInput)
   {
      dataOutput =(float) (dataInput * 1.609);
   }
   
   @Override
   public float getDataOutput()
   {
      return dataOutput;
   }
   
   @Override
   public String toString()
   {
      return String.format("%.2f Miles equals %.2f Kilo Meters", getDataInput(), getDataOutput());
   }
}

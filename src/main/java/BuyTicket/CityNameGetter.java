package BuyTicket;

import java.util.Scanner;

public class CityNameGetter
{
   public static String cityName;
   
   /**
    * Receives city name from customer.
    */
   public void getCityName()
   { 
       try
       {
           Scanner MMscanner = new Scanner(System.in);
           cityName = MMscanner.nextLine().toUpperCase().trim();
       }
       
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
   }  
    /**
     * @param cityName
     * @return true if city name matches to pattern 
     */
    public boolean validateCityName(String cityName) 
    {
       return (!(cityName.isEmpty()) && cityName.matches("[A-Z]{3,}"));
    }
}


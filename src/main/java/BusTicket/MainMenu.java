package BusTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The object <code>MainMenu</code> creates the main menu with three options to choose from: 
 * BUY TICKET, MY TICKETS AND EXIT 
 */
public class MainMenu 
{
    Map createMainMenuMap()
    {
       Map mainMenuMap = new HashMap();
       mainMenuMap.put("1", "BUY TICKET");
       mainMenuMap.put("2", "MY TICKETS");
       mainMenuMap.put("3", "EXIT");
       
       return mainMenuMap;
    }
}
/**
 * Receives the decision from the customer. There is no need to create an object.
 * Customer can choose a number which is contained in the main menu map as a key.
 */
class MMNumberGetter
{
   static String number;
   static void getNumberFromMM()
   {
       System.out.println("");
       System.out.print("Hello! Choose the number: ");
     
       try
       {
           Scanner MMscanner = new Scanner(System.in);
           number = MMscanner.nextLine();
       }
       
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
   }  
}

/**
 * The object <code>MMNumberValidator</code> checks if the entered value is in the main menu map as a key.
 */
class MMNumberValidator
{
    public boolean validateMMNumber(String number, Map map) 
     {
       return (number.matches("[0-9]*") && !(number.isEmpty()) && map.containsKey(number));
     }
}

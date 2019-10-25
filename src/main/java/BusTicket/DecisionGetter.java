package BusTicket;

import java.util.Arrays;
import java.util.Scanner;

public class DecisionGetter 
{
    /**
     * Method asks the customer for a decision about ticket purchase.
     * @return customer decision
     */
    public static String getDecision()
    {
        String decision = "";
        Scanner scanner = new Scanner(System.in);
        try
        {
            do
            {
            System.out.println("Do you want to buy a ticket for this route?  1 -> yes   2 -> no  ");
            decision = scanner.nextLine();
            }
            while(!(decision.matches("[1-2]")));
        }
        catch(Exception ex)
        {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        return decision;
    }    
}

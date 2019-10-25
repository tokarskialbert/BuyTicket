package CustomerAndTicket;

import java.util.Scanner;

public class CustomerInfoGetter 
{
    Scanner scanner;
    
    public String getCustomerName()
    {
        String name = "";
        try
        {
            scanner = new Scanner(System.in);
            do
            {
                System.out.println("Enter here your name: ");
                name = scanner.nextLine().trim();
            }
            while(!(name.matches("[a-zA-Z]{3,}"))); 
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
        return name.toUpperCase();   
    }
    
    public String getCustomerSurname()
    {
        String surname = "";
        try
        {
            scanner = new Scanner(System.in);
            do
            {
                System.out.println("Enter here your surname: ");
                surname = scanner.nextLine().trim();
            }
            while(!(surname.matches("[a-zA-Z]{3,}"))); 
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
        return surname.toUpperCase().trim();   
    }
    
    public String getCustomerEmail()
    {
        String email = "";
        try
        {
            scanner = new Scanner(System.in);
            do
            {
                System.out.println("We will send you a purchase confirmation e-mail. Enter here your e-mail address: ");
                email = scanner.nextLine().trim();
            }
            while(!(email.matches("[a-z\\d]+[\\w\\d.-]*@(?:[a-z\\d]+[a-z\\d-]+\\.){1,5}[a-z]{2,6}$"))); 
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
        return email.toUpperCase();   
    }
    
}

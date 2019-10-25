package BusTicket;

import BuyTicket.CityNameGetter;
import BuyTicket.RouteFinder;
import BuyTicket.RouteInfoGetter;
import BuyTicket.RoutesCounter;
import BuyTicket.TicketPrice;
import CustomerAndTicket.Customer;
import CustomerAndTicket.CustomerInfoGetter;
import CustomerAndTicket.Ticket;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


public class MainClass 
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
    {           
        MainMenu mainMenu = new MainMenu();
        System.out.println(mainMenu.createMainMenuMap().entrySet());
        
        MMNumberValidator mmNumberValidator = new MMNumberValidator();
        
        do
        {
        MMNumberGetter.getNumberFromMM(); 
        }
        while(!(mmNumberValidator.validateMMNumber(MMNumberGetter.number, mainMenu.createMainMenuMap())));  
        
        if(mainMenu.createMainMenuMap().get(MMNumberGetter.number).equals("BUY TICKET") && mainMenu.createMainMenuMap().containsKey(MMNumberGetter.number))
        {   
            CityNameGetter cityNameGetter = new CityNameGetter();
            System.out.println("");
            System.out.println("Do not use polish letters. Thank you.");
            System.out.println("");
            
            do
            {
            System.out.print("Departure from: ");
            cityNameGetter.getCityName();
            }
            while(!(cityNameGetter.validateCityName(CityNameGetter.cityName)));
            
            TicketPrice.setCityStart(CityNameGetter.cityName);
            CityNameGetter.cityName = "";
            System.out.println("");
           
            do
            {
            System.out.print("To: ");
            cityNameGetter.getCityName();
            }
            while(!(cityNameGetter.validateCityName(CityNameGetter.cityName)));
            
            TicketPrice.setCityEnd(CityNameGetter.cityName);
            
            System.out.println("");
            System.out.println("LOOKING FOR ROUTE...");
            
            RoutesCounter routesCounter = new RoutesCounter();
            routesCounter.routesCounter();
            
            RouteFinder routeFinder = new RouteFinder();
            routeFinder.findRoute(TicketPrice.getCityStart(), TicketPrice.getCityEnd(), routesCounter.routesCounter()); 
            
            RouteInfoGetter routeInfoGetter = new RouteInfoGetter();
            routeInfoGetter.getInfoAboutTheRoute(RouteFinder.idOfCorrectRoutesList, TicketPrice.getCityStart(), TicketPrice.getCityEnd());
            System.out.println("");
            
            TicketPrice ticketPrice = new TicketPrice();
            ticketPrice.getDistanceFromID1(RouteFinder.idOfCorrectRoutesList, TicketPrice.getCityStart().toUpperCase(), TicketPrice.getCityEnd().toUpperCase());
            ticketPrice.calculateTicketPrice();   
            
            System.out.println("Ticket price: " + TicketPrice.getTicketPrice() + " pln.");    
            System.out.println("*****");    
            
            if(!(DecisionGetter.getDecision().equals("1")))
            {  
            System.exit(0);   
            }
                       
            CustomerInfoGetter customerInfoGetter = new CustomerInfoGetter();
            Customer customer = new Customer(customerInfoGetter.getCustomerName(), customerInfoGetter.getCustomerSurname(), customerInfoGetter.getCustomerEmail());
            Ticket ticket = new Ticket(RouteInfoGetter.routeID, TicketPrice.getCityStart(), TicketPrice.getCityEnd(), TicketPrice.getTicketPrice(), customer.getEmail());  
        } 
    }   
}
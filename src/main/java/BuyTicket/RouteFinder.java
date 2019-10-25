package BuyTicket;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RouteFinder 
{
    public static List citiesList = new ArrayList();
    public final static List<Integer> idOfCorrectRoutesList = new<Integer>ArrayList();
    
    public void findRoute(String cityA, String cityB, int numberOfRoutes)
    {
        int routesCounter = 0;
        for(int i = 1; i <= numberOfRoutes; i++)
        {
            try
            {
                String dir = System.getProperty("user.dir");
                File fXmlFile = new File(dir+"/src/main/resources/routes/"+i+".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                
                NodeList nList = doc.getElementsByTagName("station");
                
                for (int temp = 0; temp < nList.getLength(); temp++)
                {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        Element eElement = (Element) nNode;
                        citiesList.add(eElement.getElementsByTagName("city").item(0).getTextContent()); //dodaje do listy wszystkie nazwy miast z danej trasy
                    }
                }
                if(citiesList.contains(cityA.toUpperCase()) && citiesList.contains(cityB.toUpperCase()) && !(cityA.equalsIgnoreCase(cityB))) //jesli trasa zawiera wskazane dwa miasta..
                    {
                        routesCounter++; //dzieki powiekszeniu licznika program wie, ze znaleziono jakakolwiek trase
                        if(citiesList.indexOf(cityA.toUpperCase())<citiesList.indexOf(cityB.toUpperCase())) //szuka trasy w odpowiednim kierunku
                        {
                           idOfCorrectRoutesList.add(i);
                           System.out.println("");
                           System.out.println("We found the right route, more info below:");
                           System.out.println("");
                           System.out.println(citiesList);
                           
                        }
                    }
            }
            
            catch(IOException | ParserConfigurationException | DOMException | SAXException ex)
            {
                System.out.println(ex.getStackTrace());    
            }   
            
            citiesList.clear();    
        }
        if(cityA.equalsIgnoreCase(cityB))
            {
                System.out.println("Try again, you entered the same cities.");
                routesCounter++;
            }
        
        if(routesCounter == 0)
            {
                System.out.println("***");
                System.out.println("Sorry, we can't find any routes.");
                System.out.println("***");
                System.exit(0);
            }
    }
}
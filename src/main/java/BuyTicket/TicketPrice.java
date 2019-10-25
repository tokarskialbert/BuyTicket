package BuyTicket;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TicketPrice 
{
    private static String cityStart;
    private static String cityEnd;
    int distanceFromID1a;
    int distanceFromID1b;
    final double pricePerKilometer = 0.15;
    private static String ticketPrice;

    public static void setTicketPrice(String ticketPrice) 
    {
        TicketPrice.ticketPrice = ticketPrice;
    }

    public static String getTicketPrice() 
    {
        return ticketPrice;
    }
 
    public static void setCityStart(String cityStart) 
    {
        TicketPrice.cityStart = cityStart;
    }

    public static String getCityStart() 
    {
        return TicketPrice.cityStart;
    }

    public static void setCityEnd(String cityEnd) 
    {
        TicketPrice.cityEnd = cityEnd;
    }

    public static String getCityEnd() 
    {
        return cityEnd;
    }
    
    
    public void getDistanceFromID1(List<Integer> listWithID, String firstStation, String lastStation) throws IOException, SAXException, XPathExpressionException
    {
        try
        {
            String dir = System.getProperty("user.dir");    
            int routeID = listWithID.get(0);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(dir+ "/src/main/resources/routes/" + routeID + ".xml");
            
            
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPathExpression xPathExpression = xPathFactory.newXPath().compile("//station[city/text() = '"+firstStation+"']/distanceFromID1/text()");  
               
            NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int k = 0; k < nodeList.getLength(); k++) 
            {
                this.distanceFromID1a = Integer.parseInt(nodeList.item(k).getTextContent());     
            }
            
            
            XPathFactory xPathFactory2 = XPathFactory.newInstance();
            XPathExpression xPathExpression2 = xPathFactory2.newXPath().compile("//station[city/text() = '"+lastStation+"']/distanceFromID1/text()");  
                 
            NodeList nodeList2 = (NodeList) xPathExpression2.evaluate(doc, XPathConstants.NODESET);
            for (int j = 0; j < nodeList2.getLength(); j++) 
            {
                this.distanceFromID1b = Integer.parseInt(nodeList2.item(j).getTextContent());       
                        
            }
        } 
        
        catch (ParserConfigurationException ex) 
        {
            Logger.getLogger(TicketPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void calculateTicketPrice()
    {
        double price = (this.distanceFromID1b - this.distanceFromID1a) * pricePerKilometer;
        DecimalFormat dFormatter = new DecimalFormat("0.00");
        TicketPrice.ticketPrice = dFormatter.format(price);
    }
}

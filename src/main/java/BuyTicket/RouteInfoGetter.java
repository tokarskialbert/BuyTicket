package BuyTicket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class RouteInfoGetter 
{
    public static ArrayList departureHours;
    public static ArrayList citiesList;
    public static ArrayList stationAddressList;
    public static int routeID;
    
    public void getInfoAboutTheRoute(List<Integer> listWithID, String firstStation, String lastStation) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
    {
        try
        {
            String dir = System.getProperty("user.dir");    
            routeID = listWithID.get(0);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(dir+ "/src/main/resources/routes/" + routeID + ".xml");
            
            
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPathExpression xPathExpression = xPathFactory.newXPath().compile("//station[city/text() = '"+firstStation+"']/departureTime/text()");  
               
            NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int k = 0; k < nodeList.getLength(); k++) 
            {
                System.out.println("");      
                System.out.println("*****");        
                System.out.print("Departure time from "+ firstStation +": "+ nodeList.item(k).getTextContent());        
            }
            
            XPathFactory xPathFactory2 = XPathFactory.newInstance();
            XPathExpression xPathExpression2 = xPathFactory2.newXPath().compile("//station[city/text() = '"+lastStation+"']/departureTime/text()"); 
            NodeList nodeList2 = (NodeList) xPathExpression2.evaluate(doc, XPathConstants.NODESET);
            
            for (int k = 0; k < nodeList2.getLength(); k++) 
            {
                System.out.print(", estimated arrival time to "+ lastStation +": "+ nodeList2.item(k).getTextContent());        
            }
        }
                catch(Exception ex)
                {
                    System.out.println(Arrays.toString(ex.getStackTrace()));
                }
            }
        }


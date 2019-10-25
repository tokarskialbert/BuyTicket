package BuyTicket;

import java.io.File;

public class RoutesCounter 
{
    /** 
     * @return number of available routes 
     */
    public int routesCounter()
    {   
        String dir = System.getProperty("user.dir");
                
        File file = new File(dir + "/src/main/resources/routes/");
        
        int fileCounter = 0;
        String str[] = file.list();
        
        for(String s : str)
        {
            File fls = new File(file,s);
            if(fls.isFile() && fls.getName().contains(".xml"))
            {
                fileCounter++;
            }
        }
        return fileCounter;
    }   
}

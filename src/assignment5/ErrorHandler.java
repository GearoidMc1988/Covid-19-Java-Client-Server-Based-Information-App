
package assignment5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class ErrorHandler {
    
    public static boolean dateValidator(String strDate)
   {

	    SimpleDateFormat correctDate = new SimpleDateFormat("yyyy/mm/dd");
	    correctDate.setLenient(false);
          
	    /* Create Date object
	     * parse the string into date 
             */
	    try
	    {
	        Date javaDate = correctDate.parse(strDate); 
	    }
	    /* Date format is invalid */
	    catch (ParseException e)
	    {
	        System.out.println(strDate +" is an Invalid Date format \n Returning to Main Menu");
	        return false;
	    }
	    /* Return true if date format is valid */
	    return true;
	
   }

    
    
    public static boolean countryCodeValidator(String code){
        
    if(code.length() != 3)
    {
        System.out.println("Invalid Country Code");
        return false;
    }
        
    return true;    
    }
    

  
    
    
}


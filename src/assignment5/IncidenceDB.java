
package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;





 
public class IncidenceDB  {

 static Connection connection;
 static QueryRunner runner;
        
    ///////////////////////////////////////////////////////////////////////////////////
    public static void doConnection() {
        try {
            //connect to DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19_by_country", "root", "");
            //create runner
            runner = new QueryRunner();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//end doConnection
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static void closeConnection() {
        try {
            DbUtils.close(connection);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//end closeConnection
    
    
    
 
    
     public static List <Incidence> getIncidenceByDate(String countryCode, String date) throws SQLException {
        ResultSetHandler<List<Incidence>> handler = new BeanListHandler(Incidence.class);
        List<Incidence> list = runner.query(connection, "SELECT * FROM incidence WHERE country_code = ? AND date = ?  order by ref_num desc limit 1", handler, countryCode, date); 
       

        return list;
        
    }//end get county_name by ref_num
     
     
   
     
      public static List<Incidence> getIncidenceByStartAndEndDate(String countryCode, String startDate,String endDate) throws SQLException {
   //my handler will convert rows in the ResultSet to Incidence objects and place them in a list
        ResultSetHandler<List<Incidence>> handler = new BeanListHandler(Incidence.class);
        
        List<Incidence> list = runner.query(connection, "SELECT * FROM incidence WHERE country_code = ? AND date BETWEEN ? AND ? order by date desc", handler,countryCode, startDate,endDate);
        
        return list;
    }//end getAllAuthors
     
    public static List<Incidence> getAllIncidence(String countryCode, int limit) throws SQLException {
        ResultSetHandler<List<Incidence>> handler = new BeanListHandler(Incidence.class);
        
        //execute the query and populate the list
        List<Incidence> list = runner.query(connection, "SELECT * FROM incidence WHERE country_code = ? order by date desc limit ?", handler, countryCode, limit);
        
        return list;
    }//end 
    
    

}//end 
    
    

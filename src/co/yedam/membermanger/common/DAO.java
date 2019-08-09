package co.yedam.membermanger.common;


import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {         //super dao class
      
   public static DataSource ds =null;
   private static Context context;
   
   public DAO() {
      // TODO Auto-generated constructor stub
   }

   public static Connection Conn() {   
	   Connection conn = null;
      try {
         context = new InitialContext();
         ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
         conn = ds.getConnection();
      }catch (Exception e) {
         e.printStackTrace();
      }
	return conn;
   }
}
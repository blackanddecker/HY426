//package com.login;
package com.jwt.hibernate.dao;
//import java.sql.*;

import java.util.List; 
import java.util.Iterator; 

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.user;

public class UserDao {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() 
    {
        try {
            return new Configuration().configure().buildSessionFactory();
            
        } catch (Throwable ex) { 
            System.out.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
	//private static SessionFactory factory; 
    String url = "jdbc:mysql://localhost:3306/www?autoReconnect=true&useSSL=false";
	String user = "root";
	String pass = "root";
	
	
	public boolean check (String username, String password) {


		
      try {
		Session session = getSessionFactory().openSession();
        // 4. Starting Transaction
        Transaction transaction = session.beginTransaction();
          List users = session.createQuery("FROM user").list(); 
          for (Iterator iterator = users.iterator(); iterator.hasNext();){
             user user = (user) iterator.next();
             System.out.println("1."+ username+ "-"+user.getUsername()); 

             if ( user.getUsername().equals( username)) {
                 System.out.println("2."+ password+ "-"+user.getPassword()); 

            	 if ( user.getPassword().equals(password)) {
            		 return true;
            	 }
             }
          }
          System.out.println("Wrong Username "+ username); 
          transaction.commit();
       } 
      catch (HibernateException e) {
          e.printStackTrace(); 	
       }
		
		
		
		
		
		
//		String sql ="select * from user where username = ? and password =?";
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pass);
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setString(1, username);
//			st.setString(2, password);
//			ResultSet rs = st.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
		
		return false;
	}
	
	public boolean insert (String username, String password) {
//	      try {
//	          factory = new Configuration().configure().buildSessionFactory();
//	       } catch (Throwable ex) { 
//	          System.out.println("Failed to create sessionFactory object." + ex);
//	          throw new ExceptionInInitializerError(ex); 
//	       }
		
		try {
			Session session = getSessionFactory().openSession();
	        // 4. Starting Transaction
	        Transaction transaction = session.beginTransaction();

            user user = new user();
            user.setUsername(username);
            user.setPassword(password);
            session.save(user);
            transaction.commit();
            System.out.println("\n\n Details Added \n");    
	        
	    
//			String sql ="insert into user values( ? , ?)";
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pass);
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setString(1, username);
//			st.setString(2, password);
//			int rs = st.executeUpdate();
//			if(rs>0) {
//				return true;
//			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}
}

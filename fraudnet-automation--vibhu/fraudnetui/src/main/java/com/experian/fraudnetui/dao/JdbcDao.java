package com.experian.fraudnetui.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDao {

  private static Connection con = null;
  private Statement stmt = null;
  private static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
  private static String username = "username";
  private static String password = "password";

    public void connectDatabase()
    {
       //Class.forName("oracle.jdbc.driver.OracleDriver");

    }



}

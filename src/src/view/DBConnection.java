/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DilshanRajika
 */
public class DBConnection {
    private static DBConnection dbconnection;
    private final Connection connection;
    DBConnection() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicleparking","root","ijse");
    }
    public Connection getconnection(){
    return connection;
    }
    public static DBConnection getInstace() throws ClassNotFoundException, SQLException{
    
    if(dbconnection==null){
        dbconnection=new DBConnection();
    }
    return dbconnection;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author DilshanRajika
 */

abstract class Vehicleparking {
abstract boolean  parking(Vehicle vehicle);

}
class Busparking extends Vehicleparking{
  

    @Override
    public boolean  parking(Vehicle vehicle){
        
        try {
            Connection connection = DBConnection.getInstace().getconnection();
            PreparedStatement stm=connection.prepareStatement("insert into Vehicle values(?,?,?,?,?,?,?)");
            String id=vehicle.getVehicleID();
            String type=vehicle.getVehicleType();
            String name=vehicle.getCustomerName();
            String intime=vehicle.getIntime();
            String outtime=vehicle.getOuttime();
            String date=vehicle.getDate();
            double payment=vehicle.getPayments();
            stm.setObject(1, id);
            stm.setObject(2, type);
            stm.setObject(3, name);
            stm.setObject(4, intime);
            stm.setObject(5, outtime);
            stm.setObject(6, payment);
             stm.setObject(7, date);
           return stm.executeUpdate()>0;
           
        } catch (ClassNotFoundException | SQLException ex) {
            String message=ex.getMessage();
            JOptionPane.showMessageDialog(null, message,"",JOptionPane.WARNING_MESSAGE);
        }
            return false;
    }
   
}
class Vanparking extends Vehicleparking{
 
    @Override
    public boolean parking(Vehicle vehicle){
        try {
            Connection connection = DBConnection.getInstace().getconnection();
            PreparedStatement stm=connection.prepareStatement("insert into Vehicle values(?,?,?,?,?,?,?)");
            String id=vehicle.getVehicleID();
            String type=vehicle.getVehicleType();
            String name=vehicle.getCustomerName();
            String intime=vehicle.getIntime();
            String outtime=vehicle.getOuttime();
            double payment=vehicle.getPayments();
            String date=vehicle.getDate();
            stm.setObject(1, id);
            stm.setObject(2, type);
            stm.setObject(3, name);
            stm.setObject(4, intime);
            stm.setObject(5, outtime);
            stm.setObject(6, payment);
            stm.setObject(7, date);
           return stm.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException ex) {
            String message=ex.getMessage();
            JOptionPane.showMessageDialog(null, message,"",JOptionPane.WARNING_MESSAGE);
        }
            return false;
    }
        
    }

class Lorryparking extends Vehicleparking{
   
    @Override
    public boolean  parking(Vehicle vehicle){
   try {
            Connection connection = DBConnection.getInstace().getconnection();
            PreparedStatement stm=connection.prepareStatement("insert into vehicle values(?,?,?,?,?,?,?)");
            String id=vehicle.getVehicleID();
            String type=vehicle.getVehicleType();
            String name=vehicle.getCustomerName();
            String intime=vehicle.getIntime();
            String outtime=vehicle.getOuttime();
            double payment=vehicle.getPayments();
            String date=vehicle.getDate();
            stm.setObject(1, id);
            stm.setObject(2, type);
            stm.setObject(3, name);
            stm.setObject(4, intime);
            stm.setObject(5, outtime);
            stm.setObject(6, payment);
            stm.setObject(7, date);
           return stm.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException ex) {
            String message=ex.getMessage();
            JOptionPane.showMessageDialog(null, message,"",JOptionPane.WARNING_MESSAGE);
        }
            return false;
    }
    }

class Carparking extends Vehicleparking{
   
    @Override
    public boolean parking(Vehicle vehicle){
    try {
            Connection connection = DBConnection.getInstace().getconnection();
            PreparedStatement stm=connection.prepareStatement("insert into vehicle values(?,?,?,?,?,?,?)");
            String id=vehicle.getVehicleID();
            String type=vehicle.getVehicleType();
            String name=vehicle.getCustomerName();
            String intime=vehicle.getIntime();
            String outtime=vehicle.getOuttime();
            double payment=vehicle.getPayments();
            String date=vehicle.getDate();
            stm.setObject(1, id);
            stm.setObject(2, type);
            stm.setObject(3, name);
            stm.setObject(4, intime);
            stm.setObject(5, outtime);
            stm.setObject(6, payment);
            stm.setObject(7, date);
           return stm.executeUpdate()>0;
        } catch (ClassNotFoundException | SQLException ex) {
            String message=ex.getMessage();
            JOptionPane.showMessageDialog(null, message,"",JOptionPane.WARNING_MESSAGE);
        }
            return false;
    }
    }

public class VehicleController {
    private  static int c=0;
    private static int v=0;
     private static int b=0;
     private static int l=0;
    public static boolean RegisterVahicle(Vehicle vehicle,String type) throws ClassNotFoundException, SQLException{
           
      switch(type){
        case "Car":{
        Vehicleparking v1=new Carparking();
       boolean added=false;
        if(c<=40){added=v1.parking(vehicle);}else{
            JOptionPane.showMessageDialog(null,"Car Sloat is Full");}
        if(added){
           VehiclearraivalForm.car.setText(Integer.toString(++c)+"/40 Car Slots");
       }
       return added;
        }  
        case "Bus":{
         Vehicleparking v1=new Busparking();
         boolean added=false;
        if(b<=20){added=v1.parking(vehicle);}else{
            JOptionPane.showMessageDialog(null,"Bus Sloat is Full");}
        if(added){
           VehiclearraivalForm.bus.setText(Integer.toString(++b)+"/20 Bus Slots");
       }
        return added;
        }
        case "Van":{
        Vehicleparking v1=new Vanparking();
        boolean added=false;
        if(v<=30){added=v1.parking(vehicle);}else{
            JOptionPane.showMessageDialog(null,"Van Sloat is Full");}
        if(added){
           VehiclearraivalForm.van.setText(Integer.toString(++v)+"/30 Van Slots");
       }
        return added;
        }
        case "Lorry":{
        Vehicleparking v1=new Lorryparking();
         boolean added=false;
        if(l<=20){added=v1.parking(vehicle);}else{
            JOptionPane.showMessageDialog(null,"Lorry Sloat is Full");}
        if(added){
           VehiclearraivalForm.lorry.setText(Integer.toString(++l)+"/10 Lorry Slots");
       }
        return added;
        }
  
      }

     return false;
     }
        public static Vehicle SearchVehicle(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstace().getconnection();
            PreparedStatement  stm=connection.prepareStatement("Select * from Vehicle where VehicleID =?");
                 stm.setObject(1,id);
                 ResultSet rst=stm.executeQuery();
                 if(rst.next()){
                  Vehicle  v1=new Vehicle(rst.getString("VehicleID"),rst.getString("VehicleType"),rst.getString("CustomerName"),rst.getString("Intime"),rst.getString("Outtime"),rst.getDouble("Payments"),rst.getString("Date_Time"));
                   return v1;
                }
        
                   return null;

}
        public static boolean Updatecustomer(Vehicle vehicle) throws ClassNotFoundException, SQLException{
        
           PreparedStatement stm= DBConnection.getInstace().getconnection().prepareStatement("update vehicle set VehicleType=?, CustomerName=?, Intime=?, Outtime=?, payments=? where VehicleID =?");
           stm.setObject(6,vehicle.getVehicleID());
           stm.setObject(1,vehicle.getVehicleType());
           stm.setObject(2,vehicle.getCustomerName());
           stm.setObject(3,vehicle.getIntime());
           stm.setObject(4,vehicle.getOuttime());
           stm.setObject(5,vehicle.getPayments());
           return stm.executeUpdate()>0;
        }
      public static double CalculateCost(String intime,String outtime, String vehicletype) throws ParseException{
          double cost=0.0;
      switch(vehicletype){
        case "Car":{
         String time1 = intime;
         String time2 = outtime;
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
          Date date1 =format.parse(time1);
          Date date2 = format.parse(time2);
         double difference = date2.getTime() - date1.getTime();
          cost= Math.abs(difference);
          return (cost/1000/3600)*50;
          }
          case "Bus":{
         String time1 = intime;
         String time2 = outtime;
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
          Date date1 =format.parse(time1);
          Date date2 = format.parse(time2);
         double difference = date2.getTime() - date1.getTime();
          cost= Math.abs(difference);
          return (cost/1000/3600)*100;
          }
          case "Van":{
         String time1 = intime;
         String time2 = outtime;
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
          Date date1 =format.parse(time1);
          Date date2 = format.parse(time2);
         double difference = date2.getTime() - date1.getTime();
          cost= Math.abs(difference);
          return (cost/1000/3600)*75;
          }
          case "Lorry":{
         String time1 = intime;
         String time2 = outtime;
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
          Date date1 =format.parse(time1);
          Date date2 = format.parse(time2);
         double difference = date2.getTime() - date1.getTime();
          cost= Math.abs(difference);
          return (cost/1000/3600)*150;
          }
      
      }
      
      return cost;
      }  

    private static class Resultset {

        public Resultset() {
        }
    }
  
    
    }


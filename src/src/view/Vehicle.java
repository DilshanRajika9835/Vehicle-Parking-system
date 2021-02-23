/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author DilshanRajika
 */
public class Vehicle {
 private String VehicleID;
private String VehicleType ;
private String CustomerName;
private String Intime;  
private String Outtime="No";
private double payments; 
private String Date;

    public Vehicle() {
    }

    public Vehicle(String VehicleID, String VehicleType, String CustomerName, String Intime, double payments, String Date) {
        this.VehicleID = VehicleID;
        this.VehicleType = VehicleType;
        this.CustomerName = CustomerName;
        this.Intime = Intime;
        this.payments = payments;
        this.Date = Date;
    }
       public Vehicle(String VehicleID, String VehicleType, String CustomerName, String Intime,String Outtime, double payments) {
        this.VehicleID = VehicleID;
        this.VehicleType = VehicleType;
        this.CustomerName = CustomerName;
        this.Intime = Intime;
        this.payments = payments;
        this.Outtime = Outtime;
    }
     public Vehicle(String VehicleID, String VehicleType, String CustomerName, String Intime,String Outtime,double payments, String Date) {
        this.VehicleID = VehicleID;
        this.VehicleType = VehicleType;
        this.CustomerName = CustomerName;
        this.Intime = Intime;
        this.Outtime = Outtime;
        this.payments = payments;
        this.Date = Date;
    }
    
     public Vehicle(String VehicleID, String VehicleType, String CustomerName, String Intime, String Date) {
        this.VehicleID = VehicleID;
        this.VehicleType = VehicleType;
        this.CustomerName = CustomerName;
        this.Intime = Intime;
        this.Date = Date;
    }

    /**
     * @return the VehicleID
     */
    public String getVehicleID() {
        return VehicleID;
    }

    /**
     * @param VehicleID the VehicleID to set
     */
    public void setVehicleID(String VehicleID) {
        this.VehicleID = VehicleID;
    }

    /**
     * @return the VehicleType
     */
    public String getVehicleType() {
        return VehicleType;
    }

    /**
     * @param VehicleType the VehicleType to set
     */
    public void setVehicleType(String VehicleType) {
        this.VehicleType = VehicleType;
    }

    /**
     * @return the CustomerName
     */
    public String getCustomerName() {
        return CustomerName;
    }

    /**
     * @param CustomerName the CustomerName to set
     */
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    /**
     * @return the Intime
     */
    public String getIntime() {
        return Intime;
    }

    /**
     * @param Intime the Intime to set
     */
    public void setIntime(String Intime) {
        this.Intime = Intime;
    }

    /**
     * @return the Outtime
     */
    public String getOuttime() {
        return Outtime;
    }

    /**
     * @param Outtime the Outtime to set
     */
    public void setOuttime(String Outtime) {
        this.Outtime = Outtime;
    }

    /**
     * @return the payments
     */
    public double getPayments() {
        return payments;
    }

    /**
     * @param payments the payments to set
     */
    public void setPayments(double payments) {
        this.payments = payments;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }
    
}

    
public class Flight {
    //Declaring attributes
    private String flightNo;
    private String depature;
    private String destination;
    private double fare;
    
    //----------------------------------------------------------
    public Flight(String flightNo, String depature, String destination, double fare) {
        this.flightNo = flightNo;
        this.depature = depature;
        this.destination = destination;
        this.fare = fare;
    }
    //----------------------------------------------------------
    public String getFlightNo() {
        return flightNo;
    }
    //----------------------------------------------------------
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
    //----------------------------------------------------------
    public String getDepature() {
        return depature;
    }
    //----------------------------------------------------------
    public void setDepature(String depature) {
        this.depature = depature;
    }
    //----------------------------------------------------------
    public String getDestination() {
        return destination;
    }
    //----------------------------------------------------------
    public void setDestination(String destination) {
        this.destination = destination;
    }
    //----------------------------------------------------------
    public double getFare() {
        return fare;
    }
    //----------------------------------------------------------
    public void setFare(double fare) {
        this.fare = fare;
    }
    //----------------------------------------------------------
    @Override
    public String toString() {
        return String.format("%-11s%-6s%-11s%-6s%-13s%-9s%-10s%s"
                ,"Flight No:",getFlightNo()
                ,"Departure:",getDepature()
                ,"Destination:",getDestination()
                ,"Fare: SAR",getFare());
    }
}
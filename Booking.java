import java.util.*;

public class Booking {
    //Declaring attributes
    private long bookingNo;
    private Flight flight;
    private Airline airline;
    private Airport airport;
    Date flightDate;
    private String name;
    private Date dob;
    boolean isBusinessClass;
    private int baggageWeight;
    
    //----------------------------------------------------------
    public Booking(long bookingNo, Flight flight, Airline airline, Airport airport,
            Date flightDate, String name,Date dob, boolean isBusinessClass, int baggageWeight) {
        this.bookingNo = bookingNo;
        this.flight =flight;
        this.airline = airline;
        this.airport = airport;
        this.flightDate = flightDate;
        this.name = name;
        this.dob = dob;
        this.isBusinessClass = isBusinessClass;
        this.baggageWeight = baggageWeight;
    }
    //----------------------------------------------------------
    public long getBookingNo() {
        return bookingNo;
    }
    //----------------------------------------------------------
    public void setBookingNo(long bookingNo) {
        this.bookingNo = bookingNo;
    }
    //---------------------------------------------------------- 
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    //----------------------------------------------------------
    public Airline getAirline() {
        return airline;
    }
    //----------------------------------------------------------
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    //----------------------------------------------------------
    public Airport getAirport() {
        return airport;
    }
    //----------------------------------------------------------
    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    //----------------------------------------------------------
    public Date getFlightDate() {
        return flightDate;
    }
    //----------------------------------------------------------
    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
    //----------------------------------------------------------
    public String getName() {
        return name;
    } 
    //----------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    //----------------------------------------------------------
    public Date getDob() {
        return dob;
    }
    //----------------------------------------------------------
    public void setDob(Date dob) {
        this.dob = dob;
    }
    //----------------------------------------------------------
    public Boolean getlsBusinessClass() {
        return isBusinessClass;
    }
    //----------------------------------------------------------
    public void setlsBusinessClass(Boolean isBusinessClass) {
        this.isBusinessClass = isBusinessClass;
    }
    //----------------------------------------------------------
    public int getBaggageWeight() {
        return baggageWeight;
    }
    //----------------------------------------------------------
    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }
    //----------------------------------------------------------
    public double CalculateFare() {
        //calculate age
        Date current = new Date();
        double age = (current.getYear()+1900) - (dob.getYear()+1900);
        double fare = flight.getFare();
        
        // calculate fare based on age
        if (age <= 2) {
            fare *= 0.1;
        } else if (age <= 12) {
            fare *= 0.7;
        }
        // calculate baggage allowance
        if (isBusinessClass) {
            fare *= 1.4;
            if (baggageWeight > 50) {
                baggageWeight -= 50;
                baggageWeight *= 30;
                return fare + baggageWeight;
            } 
            else {
                return fare;
            }
        }
        else {
            if (baggageWeight > 30) {
                baggageWeight -= 30;
                baggageWeight *= 30;
            return fare + baggageWeight;
            } 
            else {
                return fare;
            }
        }
    }
}

import java.util.*;
import java.io.*;
import java.text.*;

public class BookingDemo {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        // Storing data from inputDB file
        File inputDB = new File("inputDB.txt");
        if (!inputDB.exists()) {
            System.out.println("File " + inputDB.getName() + " doesn't exist");
            System.exit(0);
        }
        Scanner readerDB = new Scanner(inputDB);

        Airline[] airline = new Airline[readerDB.nextInt()];
        Airport[] airport = new Airport[readerDB.nextInt()];
        Flight[] flight = new Flight[readerDB.nextInt()];

        String command;
        int i = 0, j = 0, k = 0;
        do {
            command = readerDB.next();
            switch (command) {
                case "ADD_Airline":
                    airline[i] = getAirline(readerDB);
                    i++;
                    break;
                case "ADD_Airport":
                    airport[j] = getAirport(readerDB);
                    j++;
                    break;
                case "ADD_Flight":
                    flight[k] = getFlight(readerDB);
                    k++;
                    break;
            }
        } while (!command.equals("Quit"));
        readerDB.close();

        // Print log of all added airline, airport, and flight records
        PrintWriter printLog = new PrintWriter("printLog.txt");

        printLog.println("--------------- Air Ticket Reservation System Log ---------------\n\n");
        for (i = 0; i < airline.length; i++) {
            printLog.println("(New Airline Added)\t" + airline[i].toString() + "\n-------------------\n");
        }
        for (i = 0; i < flight.length; i++) {
            printLog.println("(New Flight Added)\t" + flight[i].toString() + "\n-------------------\n");
        }
        for (i = 0; i < airport.length; i++) {
            printLog.println("(New Airport Added)\t" + airport[i].toString() + "\n-------------------\n");
        }
        printLog.flush();
        printLog.close();

        // Storing data from inputBookings file
        File inputBookings = new File("inputBookings.txt");
        if (!inputBookings.exists()) {
            System.out.println("File " + inputDB.getName() + " doesn't exist");
            System.exit(0);
        }
        Scanner readerBookings = new Scanner(inputBookings);
        Booking[] booking = new Booking[readerBookings.nextInt()];

        int b = 0;
        do {
            command = readerBookings.next();
            if (command.equals("NewBooking")) {
                booking[b] = GenerateBooking(readerBookings, flight, airline, airport);
                b++;
            }
        } while (command.equals("NewBooking"));
        readerBookings.close();

        PrintWriter printBookings = new PrintWriter("printBookings.txt");

        // invoke print booking method
        PrintBooking(booking, printBookings);

        printBookings.flush();
        printBookings.close();
    }

    // add airline method
    private static Airline getAirline(Scanner reader) {
        return new Airline(reader.next(), reader.next(), reader.next(), reader.next());
    }

    // add airline method
    private static Airport getAirport(Scanner reader) {
        return new Airport(reader.next(), reader.next(), reader.next());
    }

    // add flight method
    private static Flight getFlight(Scanner reader) {
        return new Flight(reader.next(), reader.next(), reader.next(), reader.nextDouble());
    }

    // add bookings method
    private static Booking GenerateBooking(Scanner reader, Flight[] flight, Airline[] airline, Airport[] airport) throws ParseException {
        // associaiting flight number, airline 2-letter code, airport 3-letter code to their appropriate objects
        Flight flight1 = searchFlight(reader.next(), flight);
        Airline airline1 = searchAirline(reader.next(), airline);
        Airport airport1 = searchAirport(reader.next(), airport);

        String date = reader.next() + "-" + reader.next() + "-" + reader.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date flightDate = sdf.parse(date);
        String name = reader.next();
        date = reader.next() + "-" + reader.next() + "-" + reader.next();
        Date dob = sdf.parse(date);
        long bookingnumber = System.currentTimeMillis();

        return new Booking(bookingnumber, flight1, airline1, airport1, flightDate, name, dob, reader.nextBoolean(), reader.nextInt());
    }

    // print bookings method
    public static void PrintBooking(Booking booking[], PrintWriter writer) {
        double rFare, tFare;
        String flightDate, dob;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");

        writer.println("--------------- Welcome to Air Ticket Reservation System ---------------\n");

        for (Booking booking1 : booking) {
            
            flightDate = sdf.format(booking1.getFlightDate());
            dob = sdf.format(booking1.getDob());
            
            writer.println("\nBooking No. " + booking1.getBookingNo()
                    + "\n\nPassenger Details	Passenger Name: " + booking1.getName()
                    + "\t\tDate of Birth: " + dob
                    + "\n\nFlight Details    Flight Code: " + booking1.getAirline().getTwoDigitCode() + "-" + booking1.getFlight().getFlightNo()
                    + "\t\t\t" + flightDate + "\n\t\t  Departure: " + booking1.getFlight().getDepature()
                    + "\t\tDestination: " + booking1.getFlight().getDestination()
                    + "\n\nAirport Details	tAirport Name: " + booking1.getAirport().getName() + " (" + booking1.getAirport().getThreeDigitCode() + "), " + booking1.getAirport().getCity()
                    + "\n\nAirline Details	Name: " + booking1.getAirline().getName() + " based in " + booking1.getAirline().getWebsite());

            // calculate & print regular/total fare
            rFare = booking1.getFlight().getFare();
            tFare = booking1.CalculateFare();
            writer.println("\nFare Details	Regular Fare: SAR " + rFare
                    + "\n		Total Fare: SAR " + (double) Math.round(tFare));
            writer.print("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");
        }
    }
    
    public static void NumOfFlightsPerAirport(Airport[] airports, Booking[] alltiickets, PrintWriter writer) {
        
    }

    // search flight method
    public static Flight searchFlight(String flight_number, Flight[] flight) {
        for (Flight flight1 : flight) {
            if (flight_number.equals(flight1.getFlightNo())) {
                return flight1;
            }
        }
        return null;
    }

    // search airline code method
    public static Airline searchAirline(String code, Airline[] airline) {
        for (Airline airline1 : airline) {
            if (code.equals(airline1.getTwoDigitCode())) {
                return airline1;
            }
        }
        return null;
    }

    // search airport code method
    public static Airport searchAirport(String code, Airport[] airport) {
        for (Airport airport1 : airport) {
            if (code.equals(airport1.getThreeDigitCode())) {
                return airport1;
            }
        }
        return null;
    }
}

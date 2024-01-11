package kdu.backend3;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logging logger = new Logging();
        TicketReservation mmt = new TicketReservation();
        String ticketBooked = "Ticket booked: ";
        String ticketCancelled = "Ticket cancelled: ";
        String businessClass = "business";
        String economyClass = "economy";
        logger.logInfo(ticketBooked + mmt.bookFlight("Kashita","Wadhwa",20,"female",businessClass,"A1"));
        logger.logInfo(ticketBooked + mmt.bookFlight("Manya","Wadhwa",21,"female",businessClass,"A2"));
        logger.logInfo(ticketBooked + mmt.bookFlight("Aarnav","Taneja",18,"male",businessClass,"A3"));
        logger.logInfo(ticketBooked + mmt.bookFlight("Aahan","Taneja",15,"male",businessClass,"A4"));
        logger.logInfo(ticketBooked + mmt.bookFlight("Malvika","Wadhwa",9,"female",businessClass,"A5"));
        logger.logInfo(ticketBooked + mmt.bookFlight("Harsh","Wadhwa",10,"male",businessClass,"A6"));

        List<Passenger> cnf = mmt.getConfirmedList();
        logger.logInfo(ticketCancelled + mmt.cancel("A3"));
        logger.logInfo(ticketCancelled + mmt.cancel("A6"));

        logger.logInfo("Confirmation List:- ");
        for(Passenger p: cnf){
            logger.logInfo(p.getConfirmationNumber());
        }
    }
}
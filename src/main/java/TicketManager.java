import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] searchByAirport(String from, String to) {
        Ticket[] result = new Ticket[0];
        TicketRepository tmp = new TicketRepository();
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                tmp.save(ticket);
                result = tmp.findAll();
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from)) {
            return ticket.getArrivalAirport().contains(to);
//            return true;
        } else {
            return false;
        }
//         return ticket.matches(from, to);
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        TicketRepository tmp = new TicketRepository();
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                tmp.save(ticket);

                TicketByTravelTimeAscComparator travelTimeAscComparator = new TicketByTravelTimeAscComparator();
                result = tmp.findAll();
                Arrays.sort(result, travelTimeAscComparator);
            }
        }
        return result;
    }
}

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) { //searchByAirport
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
        } else {
            return false;
        }
//         return ticket.matches(from, to);
    }
}

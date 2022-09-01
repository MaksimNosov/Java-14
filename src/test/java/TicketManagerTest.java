
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TicketManagerTest {

    TicketRepository repo = Mockito.mock(TicketRepository.class);
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1_299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2_199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1_899, "SVO", "KZN", 85);
    Ticket ticket4 = new Ticket(4, 1_099, "SVO", "KZN", 105);
    Ticket ticket5 = new Ticket(5, 1_799, "SVO", "KZN", 105);
    Ticket ticket6 = new Ticket(5, 1_899, "SVO", "KZN", 120);


    @Test
    public void shouldSearchByAirport() {       //находит несколько билетов и сортирует их по цене от меньшей к большей
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        doReturn(tickets).when(repo).findAll();

        Ticket[] expected = {ticket4, ticket1, ticket5, ticket3, ticket6};
        Ticket[] actual = manager.searchByAirport("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAirport2() {      //находит один билет
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        doReturn(tickets).when(repo).findAll();

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchByAirport("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAirport3() {      //не находит ни один билет
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        doReturn(tickets).when(repo).findAll();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchByAirport("LED", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }
}



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);

    TicketRepository repo = new TicketRepository();

    @BeforeEach
    public void setUp() {
        repo.save(ticket1);
        repo.save(ticket2);
    }

    @Test
    public void saveTicket() {

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTicketById() {

        repo.removeById(ticket1.getId());

        Ticket[] expected = {ticket2};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

import java.util.Arrays;

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


}
////        Ticket[] result = new Ticket[0]; //было
//
//        for (Ticket ticket : repo.findAll()) {
//            Ticket[] tmp = new Ticket[0];
//            int copyToIndex = 0;
//            if (ticket.getDepartureAirport() == from) {
//                tmp[copyToIndex] = ticket;
//                copyToIndex++;
//            } else {
//                return tmp;
//            }
//
//            if (ticket.getArrivalAirport() == to) {
//                tmp[copyToIndex - 1] = ticket;
//                copyToIndex++;
//                    return tmp;
////                    return tmp;
//            } else {
////                tmp[copyToIndex] = null;
//                copyToIndex--;
//            }
//
////            result = tmp;
////        return null;
//        }
////        return Ticket[];
//    }


//    public void searchByAirport(String from, String to) {
//
//        if (findByAirport(from, to) != null) {
//            Ticket[] result = new Ticket[1];
//            int copyToIndex = 0;
//            for (Ticket ticket : repo.findAll()) {
//                result[copyToIndex] = ticket;
//                copyToIndex++;
//            }
////             return result;
//        }
////        return result;


//    public Ticket[] searchByAirport(String from, String to) {
//        Ticket[] result = new Ticket[0];
//
//
//        for (Ticket ticket : repo.findAll()) {
//            if (from == ticket.departureAirport) {
//                result[result.length + 1] = ticket;
//            }
//            if (to == ticket.arrivalAirport) {
//                result[result.length + 1] = ticket;
//            }
//        }
//        return result;
//    }


//        public Ticket[] searchByDepartureAirport(){
//            Ticket[] result = new Ticket[];
//            for (Ticket ticket : repo.findAll()) {
//                if (matches(ticket, text)) {
//
//                    result[result.length - 1] = ticket;
//                }
//            }
//            return result[];
//        }
//
//        public boolean matches (String , String){
//            if (ticket.matches()) {
//                return true;
//            } else {
//                return false;
//            }
//        }


//    public Ticket[] searchByArrivalAirport(String text){
//        Ticket[] result = new Ticket[1];
//        for (Ticket ticket : repo.findAll()) {
//            if (matches(ticket, text)) {
//
//                result[result.length - 1] = ticket;
//            }
//        }
//        return result;
//    }
//
//    public boolean matches (Ticket ticket, String search){
//        if (ticket.matches(search)) {
//            return true;
//        } else {
//            return false;
//        }
//    }


//    public Product[] searchBy(String text) {
//        Product[] result = new Product[1]; // тут будем хранить подошедшие запросу продукты
//        for (Product product: repo.findAll()) {
//            if (matches(product, text)) {
//
//                result[result.length - 1] = product;
//            }
//        }
//        return result;
//    }
//
//    public boolean matches(Product product, String search) {
//        if (product.matches(search)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
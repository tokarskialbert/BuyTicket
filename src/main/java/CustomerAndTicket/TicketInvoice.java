package CustomerAndTicket;

public class TicketInvoice extends Ticket
{
    private final String address;
    
    public TicketInvoice(int routeId, String start, String end, String price, String email, String address) {
        super(routeId, start, end, price, email);
        this.address = address;
    }
    
}

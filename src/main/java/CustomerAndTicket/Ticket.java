package CustomerAndTicket;

import java.util.Objects;

public class Ticket 
{
    private final int routeId; 
    private final String start;
    private final String end;
    private final String price;
    private final String email;

    public Ticket(int routeId, String start, String end, String price, String email) 
    {
        this.routeId = routeId;
        this.start = start;
        this.end = end;
        this.price = price;
        this.email = email;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getPrice() {
        return price;
    }

    public String getEmail() {
        return email;
    }    
    
    @Override
    public boolean equals(Object otherObject)
    {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Ticket other = (Ticket) otherObject;
        return 
                Objects.equals(start, other.start) && 
                (routeId == other.routeId) && 
                Objects.equals(start, other.start) && 
                Objects.equals(end, other.end) && 
                Objects.equals(price, other.price) && 
                Objects.equals(email, other.email);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(routeId, start, end, price, email);
    }
    
    @Override
    public String toString()
    {
        return getClass().getName() + 
                ", route ID: " + routeId + 
                ", first station: " + start + 
                ", last station: " + end + 
                ", ticket price: " + price + 
                ", customer e-mail: " + email;
    }
}

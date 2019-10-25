package CustomerAndTicket;

import java.util.Objects;

public final class Customer 
{
    private final String name;
    private final String surname;
    private final String email;

    public Customer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    
    public String getName() 
    {
        return name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public String getEmail() 
    {
        return email;
    }   
    
    @Override
    public boolean equals(Object otherObject)
    {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Customer other = (Customer) otherObject;
        
        return  Objects.equals(name, other.name) && 
                Objects.equals(surname, other.surname) && 
                Objects.equals(email, other.email);   
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(name, surname, email);
    }
    
    @Override
    public String toString()
    {
        return (getClass().getName() + " name: " + name + ", surname: " + surname + ", e-mail: " + email);
    }
}


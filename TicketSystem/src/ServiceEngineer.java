import java.util.*;
//Service Engineer user name will contain the type of engineer he is
public class ServiceEngineer extends User{
	public Set<Ticket> TicketsOfServiceEngineer = new HashSet<Ticket>();
	private Boolean Availabilty;
	private String ServiceEngineerType;
	public String getServiceEngineerType() {
		return ServiceEngineerType;
	}
	public void setServiceEngineerType(String serviceEngineerType) {
		ServiceEngineerType = serviceEngineerType;
	}
	public Boolean getAvailabilty() {
		return Availabilty;
	}
	public void setAvailabilty(Boolean availabilty) {
		Availabilty = availabilty;
	}
	public boolean login(String Username, String Password, String UserType,UserData UD, String serviceEngType)
	{
		System.out.println("Service Engineer Type:");
		String s = serviceEngType;
		if(UD.ServiceEngineerData.containsKey(s))
		{
			if(UD.ServiceEngineerData.get(s).containsKey(Username))
			{
				if(UD.ServiceEngineerData.get(s).get(Username).getPassword().equals(Password))
				{
					if(UD.ServiceEngineerData.get(s).get(Username).getUserStatus()==false)
					{
						UD.ServiceEngineerData.get(s).get(Username).setUserStatus(true);
						System.out.println("Logged in!");
						return true;
					}
					else
					{
						System.out.println("Already Logged in!");
						return true;
					}
				}
				else
				{
					System.out.println("Wrong password");
					return false;
				}
			}
			else
			{
				System.out.println("User does not exist!");
				return false;
			}
		}
		else
		{
			System.out.println("User does not exist!");
			return false;
		}
	}
	public void viewTickets(String serviceEngType,String Username,UserData UD)
	{
		Iterator<Ticket> it = UD.ServiceEngineerData.get(serviceEngType).get(Username).TicketsOfServiceEngineer.iterator();
		System.out.println("Tickets assigned to "+Username+" Service Engineer are:");
		while(it.hasNext())
		{
			Ticket t = it.next();
			System.out.println(t.getTicketName()+" "+t.getTicketStatus());
		}
	}
	public void changeStatus(String Username, String TicketName, String TicketType,String ChangeStatusTo, UserData UD)
	{
		Ticket t = new Ticket();
		t.changeTicketStatus(Username,TicketName, TicketType, ChangeStatusTo, UD);
	}
	public void closeTicket(String Username, String TicketName, String TicketType, UserData UD)
	{
		Ticket t = new Ticket();
		t.changeTicketStatus(Username,TicketName, TicketType,"Close", UD);
	}
	
}
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EndUser extends User{
	public Set<Ticket> TicketsOfEndUser = new HashSet<Ticket>();
	public void viewTickets(String Username,UserData UD)
	{
		Iterator<Ticket> it = UD.EndUserData.get(Username).TicketsOfEndUser.iterator();
		System.out.println("Tickets raised are:");
		while(it.hasNext())
		{
			Ticket t = it.next();
			System.out.println(t.getTicketName()+" "+t.getTicketStatus());
		}
	}
	public void closeTicket(String Username, String TicketName, String TicketType, UserData UD)
	{
		Ticket t = new Ticket();
		t.changeTicketStatus(UD.TicketData.get(TicketName).getServiceEng(),TicketName, TicketType,"Close", UD);
	}
	public void raiseTicket(String Username,String TicketName, String TicketType, UserData UD)
	{
		if(!UD.TicketData.containsKey(TicketName))
		{
			Ticket t = new Ticket();
			t.setTicketName(TicketName);
			t.setTicketType(TicketType);
			t.setTicketStatus("open");
			boolean ticketAssignStatus=false;
			if(UD.ServiceEngineerData.containsKey(TicketType))
			{
					for(Map.Entry<String,ServiceEngineer> j: UD.ServiceEngineerData.get(TicketType).entrySet())
					{
						if(j.getValue().getAvailability()==true)
						{
							System.out.println("Ticket is raised and Engineer is assigned");
							UD.TicketData.put(TicketName, t);
							UD.ServiceEngineerData.get(TicketType).get(j.getKey()).setAvailability(false);
							UD.ServiceEngineerData.get(TicketType).get(j.getKey()).TicketsOfServiceEngineer.add(t);
							UD.EndUserData.get(Username).TicketsOfEndUser.add(t);
							t.setServiceEng(j.getKey());
							ticketAssignStatus=true;
							break;
						}
					}
					if(!ticketAssignStatus)
					{
						System.out.println("Ticket put in Assign later");
						UD.ticketAssignLater.put(TicketName, t);
						UD.TicketData.put(TicketName, t);
						UD.EndUserData.get(Username).TicketsOfEndUser.add(t);
					}
			}
			else
			{
				UD.ticketAssignLater.put(TicketName, t);
				System.out.println("Ticket put in Assign later");
			}
		}
		else
		{
			System.out.println("Ticket Name already exists try a different one!");
		}
	}

}


import java.util.Map;

public class Ticket {
	private String TicketName;
	private String TicketType;
	private String TicketStatus;
	private String serviceEng;
	public String getServiceEng() {
		return serviceEng;
	}
	public void setServiceEng(String serviceEng) {
		this.serviceEng = serviceEng;
	}
	public String getTicketName() {
		return TicketName;
	}
	public void setTicketName(String ticketName) {
		TicketName = ticketName;
	}
	public String getTicketType() {
		return TicketType;
	}
	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	public String getTicketStatus() {
		return TicketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		TicketStatus = ticketStatus;
	}
	public void changeTicketStatus(String serviceEng, String TicketName, String TicketType,String ChangeStatusTo, UserData UD)
	{
		if(ChangeStatusTo.equalsIgnoreCase("Close"))
		{
			if(UD.TicketData.containsKey(TicketName))
			{
				UD.TicketData.get(TicketName).setTicketStatus(ChangeStatusTo);
				System.out.println("Ticket closed!");
				for(Map.Entry<String,ServiceEngineer> j: UD.ServiceEngineerData.get(TicketType).entrySet())
				{
					if(j.getValue().TicketsOfServiceEngineer.contains(UD.TicketData.get(TicketName)))
					{
						j.getValue().setAvailabilty(true);
					}
				}
			}
			else
			{
				if(UD.ticketAssignLater.containsKey(TicketName))
				{
					System.out.println("Ticket wasn't assigned to any Service Engineer so we are closing it.");
					UD.TicketData.put(TicketName, UD.ticketAssignLater.get(TicketName));
					UD.TicketData.get(TicketName).setTicketStatus(ChangeStatusTo);
					UD.ticketAssignLater.remove(TicketName);
				}
				else
				{
					System.out.println("Ticket does not exist!");
				}
				
			}
		}
		else
		{
			if(UD.TicketData.containsKey(TicketName))
			{
				UD.TicketData.get(TicketName).setTicketStatus(ChangeStatusTo);
				System.out.println("Status is changed!");
				if(ChangeStatusTo.equalsIgnoreCase("hold"))
				{
					UD.ServiceEngineerData.get(TicketType).get(serviceEng).setAvailability(true);
				}
			}
			else
			{
				System.out.println("Ticket does not exsist!");
			}
		}
	}
	
}

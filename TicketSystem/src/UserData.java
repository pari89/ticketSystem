import java.util.*;
public class UserData {
	public Map<String,String> LoginData = new HashMap<String,String>();
	public Map<String,Admin> AdminData = new HashMap<String,Admin>(); 
	public Map<String,EndUser> EndUserData = new HashMap<String,EndUser>(); 
	public Map<String,Map<String,ServiceEngineer>> ServiceEngineerData = new HashMap<String,Map<String,ServiceEngineer>>(); 
	public Map<String,Ticket> TicketData = new HashMap<String,Ticket>();
	public Map<String,Ticket> ticketAssignLater = new HashMap<String,Ticket>();
}

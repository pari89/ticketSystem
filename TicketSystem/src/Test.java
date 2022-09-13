import java.util.*;
public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		UserData UD = new UserData();
		Admin Ad1 = new Admin();
		String c;
		String s;
		do
		{
			System.out.println("Select Role:\nAdmin\tServiceEngineer\tEndUser");
			s = sc.next();
			if(s.equalsIgnoreCase("Admin"))
			{
				System.out.println("Login/Register");
				String fuc = sc.next();
				if(fuc.equalsIgnoreCase("Register"))
				{
					System.out.println("Name\tPassword\tUserType");
					String name, password, role;
					name = sc.next(); password = sc.next(); role = sc.next();
					Ad1.register(name, password, role, UD);
					System.out.println("If you want to login type login");
					fuc = sc.next();
				}
				if(fuc.equalsIgnoreCase("login"))
				{
					System.out.println("Name\tPassword");
					String name, password;
					name = sc.next(); password = sc.next();
					boolean login = false;
					if(UD.LoginData.containsKey(name))
					{
						login = Ad1.login(name, password, UD.LoginData.get(name), UD);
					}
					else
					{
						System.out.println("User does not exist!");
					}
					if(login && UD.AdminData.containsKey(name))
					{
						Admin aD = UD.AdminData.get(name);
						String func;
						do
						{
							System.out.println("Choose a Function\naddAdmin\taddServiceEngineer\taddEndUser\tviewUsers\tlogout");
							func = sc.next();
							if(func.equalsIgnoreCase("addAdmin"))
							{
								System.out.println("Name\tPassword");
								String name1, password1;
								name1 = sc.next(); password1 = sc.next();
								aD.addAdmin(name1, password1,UD);
							}
							else if(func.equalsIgnoreCase("addServiceEngineer"))
							{
								System.out.println("Name\tPassword");
								String name1, password1;
								name1 = sc.next(); password1 = sc.next();
								aD.addServiceEngineer(name1, password1,UD);
							}
							else if(func.equalsIgnoreCase("addEndUser"))
							{
								System.out.println("Name\tPassword");
								String name1, password1;
								name1 = sc.next(); password1 = sc.next();
								aD.addEndUser(name1, password1,UD);
							}
							else if(func.equalsIgnoreCase("viewUsers"))
							{
								aD.viewUsers(UD);
							}
							else if(func.equalsIgnoreCase("logout"))
							{
								aD.logout(aD);
							}
						}while(!func.equalsIgnoreCase("logout"));
					}
				}
			}
			else if(s.equalsIgnoreCase("ServiceEngineer"))
			{
				System.out.println("Login");
				System.out.println("Name\tPassword");
				String name, password, role;
				name = sc.next(); password = sc.next(); 
				boolean login = false;
				ServiceEngineer se = new ServiceEngineer();
				System.out.println("Service Engineer Type");
				role = sc.next();
				if(UD.LoginData.containsKey(name))
				{
					login = se.login(name, password,UD.LoginData.get(name), UD,role);
				}
				else
				{
					System.out.println("User does not exist!");
				}
				if(login && UD.ServiceEngineerData.containsKey(role))
				{
					if(UD.ServiceEngineerData.get(role).containsKey(name))
					{
						ServiceEngineer sE = UD.ServiceEngineerData.get(role).get(name);
						String func;
						do
						{
							System.out.println("Choose a Function\nviewTickets\tchangeStatus\tcloseTicket\tlogout");
							func = sc.next();
							if(func.equalsIgnoreCase("viewTickets"))
							{
								sE.viewTickets(role,name, UD);
							}
							else if(func.equalsIgnoreCase("changeStatus"))
							{
								System.out.println("Ticket name\tTicket Type\tChange Status to");
								String ticketName,ticketType, statusChange;
								ticketName = sc.next(); ticketType = sc.next(); statusChange = sc.next();
								sE.changeStatus(name, ticketName, ticketType, statusChange, UD);
							}
							else if(func.equalsIgnoreCase("closeTicket"))
							{
								System.out.println("Ticket name\tTicket Type\tChange Status to");
								String ticketName,ticketType;
								ticketName = sc.next(); ticketType = sc.next(); 
								sE.closeTicket(name, ticketName, ticketType, UD);
							}
							else if(func.equalsIgnoreCase("logout"))
							{
								sE.logout(sE);
							}
						}while(!func.equalsIgnoreCase("logout"));
					}
				}			
			}
			else if(s.equalsIgnoreCase("EndUser"))
			{
				System.out.println("Login");
				System.out.println("Name\tPassword\t");
				String name, password;
				name = sc.next(); password = sc.next();
				boolean login = false;
				if(UD.LoginData.containsKey(name))
				{
					login = Ad1.login(name, password, UD.LoginData.get(name), UD);
				}
				else
				{
					System.out.println("User does not exist!");
				}
				if(login && UD.EndUserData.containsKey(name))
				{
					EndUser eD = UD.EndUserData.get(name);
					String func;
					do
					{
						System.out.println("Choose a Function\nviewTickets\traiseTicket\tcloseTicket\tlogout");
						func = sc.next();
						if(func.equalsIgnoreCase("viewTickets"))
						{
							eD.viewTickets(name, UD);
						}
						else if(func.equalsIgnoreCase("raiseTicket"))
						{
							System.out.println("Ticket name\tTicket Type");
							String ticketName,ticketType;
							ticketName = sc.next(); ticketType = sc.next(); 
							eD.raiseTicket(name, ticketName, ticketType,UD);
						}
						else if(func.equalsIgnoreCase("closeTicket"))
						{
							System.out.println("Ticket name\tTicket Type");
							String ticketName,ticketType;
							ticketName = sc.next(); ticketType = sc.next(); 
							eD.closeTicket(name, ticketName, ticketType, UD);
						}
						else if(func.equalsIgnoreCase("logout"))
						{
							eD.logout(eD);
						}
					}while(!func.equalsIgnoreCase("logout"));
				}
			}
			System.out.println("If you wanna login again, type y or else n");
			c = sc.next();
		}while(c.equalsIgnoreCase("y"));
	}

}

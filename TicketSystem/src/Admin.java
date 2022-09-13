import java.util.*;
public class Admin extends User{
	/**
	 * 
	 */
	public void addAdmin(String Username, String Password, UserData UD)
	{
		super.register(Username, Password,"Admin", UD);
	}
	public void addEndUser(String Username, String Password, UserData UD)
	{
		super.register(Username, Password,"EndUser", UD);
	}
	public void addServiceEngineer(String Username, String Password, UserData UD)
	{
		super.register(Username, Password,"ServiceEngineer", UD);
	}
	public void viewUsers(UserData UD)
	{
		System.out.println("Admin Users are:");
		if(!UD.AdminData.isEmpty())
		{
			for(Map.Entry<String,Admin> i : UD.AdminData.entrySet())
			{
				System.out.println(i.getKey());
			}
		}
		if(!UD.ServiceEngineerData.isEmpty())
		{
			System.out.println("Service Engineer Users are:");
			for(Map.Entry<String,Map<String,ServiceEngineer>> i : UD.ServiceEngineerData.entrySet())
			{
				System.out.println(i.getKey()+" Service Engineers are:");
				for(Map.Entry<String,ServiceEngineer> j: i.getValue().entrySet())
				{
					System.out.println(j.getKey());
				}
			}
		}
		if(!UD.EndUserData.isEmpty())
		{
			System.out.println("End Users are:");
			for(Map.Entry<String,EndUser> i : UD.EndUserData.entrySet())
			{
				System.out.println(i.getKey());
			}
		}
		
	}
}
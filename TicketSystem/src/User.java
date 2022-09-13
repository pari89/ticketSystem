import java.util.*;
public abstract class User {
	Scanner sc = new Scanner(System.in);
	private String Username;
	private String Password;
	private String UserType;
	private Boolean UserStatus;
	private Boolean Availability;
	public Boolean getAvailability() {
		return Availability;
	}
	public void setAvailability(Boolean availability) {
		Availability = availability;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public Boolean getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(Boolean userStatus) {
		UserStatus = userStatus;
	}
	//public void createUser()
	public void register(String Username, String Password, String UserType,UserData UD)
	{
		if(UserType.equalsIgnoreCase("Admin"))
		{
			Admin u = new Admin();
			u.setUsername(Username);
			u.setPassword(Password);
			u.setUserType(UserType);
			u.setUserStatus(false);
			if(!UD.AdminData.containsKey(Username))
			{
				UD.AdminData.put(Username,u);
				UD.LoginData.put(Username, "Admin");
				System.out.println("User created");
			}
			else
			{
				System.out.println("Username already exists");
			}
		}
		else if(UserType.equalsIgnoreCase("EndUser"))
		{
			EndUser u = new EndUser();
			u.setUsername(Username);
			u.setPassword(Password);
			u.setUserType(UserType);
			u.setUserStatus(false);
			if(!UD.EndUserData.containsKey(Username))
			{
				UD.LoginData.put(Username,"EndUser");
				UD.EndUserData.put(Username,u);
				System.out.println("User created");
			}
			else
			{
				System.out.println("Username already exists");
			}
		}
		else if(UserType.equalsIgnoreCase("ServiceEngineer"))
		{
			ServiceEngineer u = new ServiceEngineer();
			u.setUsername(Username);
			u.setPassword(Password);
			u.setUserType(UserType);
			u.setUserStatus(false);
			System.out.println("Service Engineer Type");
			String s = sc.next();
			if(UD.ServiceEngineerData.containsKey(s))
			{
				if(!UD.ServiceEngineerData.get(s).containsKey(Username))
				{
					
					Map<String,ServiceEngineer> mp = new HashMap<String,ServiceEngineer>();
					mp.put(Username, u);
					UD.ServiceEngineerData.put(s,mp);
					UD.LoginData.put(Username,"ServiceEngineer");
					UD.ServiceEngineerData.get(s).get(Username).setAvailability(true);
					UD.ServiceEngineerData.get(s).get(Username).setServiceEngineerType(s);
					System.out.println("User created");
				}
				else
				{
					System.out.println("Username already exists");
				}
			}
			else
			{
				Map<String,ServiceEngineer> mp = new HashMap<String,ServiceEngineer>();
				mp.put(Username, u);
				UD.ServiceEngineerData.put(s,mp);
				UD.LoginData.put(Username,"ServiceEngineer");
				UD.ServiceEngineerData.get(s).get(Username).setAvailability(true);
				UD.ServiceEngineerData.get(s).get(Username).setServiceEngineerType(s);
				System.out.println("User created");
			}
		}		
	}
	public boolean login(String Username, String Password, String UserType,UserData UD)
	{		
		if(UserType.equalsIgnoreCase("Admin"))
		{
			if(UD.AdminData.containsKey(Username))
			{
				if(UD.AdminData.get(Username).getPassword().equals(Password))
				{
					if(UD.AdminData.get(Username).getUserStatus()==false)
					{
						UD.AdminData.get(Username).setUserStatus(true);
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
		else if(UserType.equalsIgnoreCase("EndUser"))
		{
			if(UD.EndUserData.containsKey(Username))
			{
				if(UD.EndUserData.get(Username).getPassword().equals(Password))
				{
					if(UD.EndUserData.get(Username).getUserStatus()==false)
					{
						UD.EndUserData.get(Username).setUserStatus(true);
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
		return false;
	}
	public void logout(User u)
	{
		u.setUserStatus(false);
		System.out.println("Logged out!");
	}
}
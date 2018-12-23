import java.util.ArrayList;
import java.util.Scanner;

public class User{
	public int Counter;
    public String email;
    public String username;
    public String password;
    public String phone;
    public int id;
    public ArrayList<String> Notify = new ArrayList<>();
    public Authentication au;
    public Verification ve;
    public UserServices us;
    
    public User(Authentication a, Verification v, UserServices u){
    	au = a;
    	ve = v;
    	us = new UserServices(this, v);
    }
    
    public void options() {
    	while(true) {
    		System.out.println("To Make Post: Press 1" + "\n" + "To Claim: Press 2"+"\nShow posts: press 3"+"\nSearch: press 4" +"\nLogOut: press 5") ;
    		Scanner in = new Scanner(System.in);
        	String ch = in.nextLine();
        	if(ch.compareTo("1")==0)
        	{
        		us.makepost();
        	}
        	else if(ch.compareTo("2")==0) {
        		us.Claim(au, -1);
        	}
        	else if(ch.compareTo("3")==0) {
        		us.ShowPosts();
        	}
        	else if(ch.compareTo("4")==0){
        		int index = us.Search();
        		if(index == -1)
        			continue;
        		us.Claim(au,  index);
        	}
        	else if(ch.compareTo("5")==0) {
        		break;
        	}
        	else {
        		System.out.println("Enter Number 3edl");
        	}
        }
    }
    
    public User() {
    	
    }
    
    public boolean login()
    {
    	if(au.verifyUser(email, password))
    	{
    		if(Notify.size()>0) {
    			for(int i=0; i<Notify.size(); i++)
    				System.out.println(Notify.get(i));
    			Notify = new ArrayList<>();
    		}
    		options();
    		return true;
    	}
    	else {
    		//System.out.println("Invalid Login, try Again or sign up");
    		return false;
    	}
    }
    
    public boolean SignUp() {
    	if(au.ValidateSignUp(this)) {
    		options();
    		return true;
    	}
    	else
    	{
    		System.out.println("Signup Failed, try again");
    		return false;
    	}
    }
}
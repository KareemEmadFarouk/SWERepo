import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	    Authentication au = new Authentication();
	    
	    Verification ve = new Verification();
	    UserServices us = new UserServices(null, null);
		
        Scanner in = new Scanner(System.in);
		while(true)
        {
			User u = new User(au,  ve,  us);
        	System.out.println("[1] Login /n [2] Signup");
        	String ch = in.nextLine();
        	if(ch.compareTo("1") == 0) {
        		System.out.println("Enter UserName: ");
        		u.email = in.nextLine();
        		System.out.println("Enter Password: ");
        		u.password = in.nextLine();
        		if(! u.login())
        		{
        			System.out.println("Invalid Login, try again or sign up");
        		}
        	}
        	else if(ch.compareTo("2")==0){
        		do {
        			System.out.println("UserName: ");
        			u.username = in.nextLine();
        		}while(u.username.compareTo("") == 0);
        		do {
	        		System.out.println("Email: ");
	        		u.email = in.nextLine();
        		}while(u.email.compareTo("") == 0);
        		do {
	        		System.out.println("password: ");
	        		u.password = in.nextLine();
        		}while(u.password.compareTo("") == 0);
        		do {
	        		System.out.println("Phone number: ");
	        		u.phone = in.nextLine();
        		}while(u.phone.compareTo("") == 0);
        		if(! u.SignUp())
        			System.out.println("signup failed, try again");
        		
        	}
        }
	}

}

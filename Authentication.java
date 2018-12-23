public class Authentication{
	public DB_User dbu = new DB_User();
	
	public Authentication() {
		User Admin = new User();
		Admin.email=  "admin";
		Admin.password = "admin";
		dbu.Vu.add(Admin);
	}
	
    public boolean verifyUser(String em, String pass) { //ValidateLogin
    	//if(dbu.Vu.size()) {
	    	for(int i=0 ; i < dbu.Vu.size(); i++ ) {
	    		if((em.compareTo(dbu.Vu.get(i).email))==0 && (pass.compareTo(dbu.Vu.get(i).password))==0) {
	    			return true;
	    		}
	    	}
	    	return false;   	
    	}
    	/*else {
    		return false;
    	}*/
    
    
    public boolean VerifyNewUser(String email) {
    	for(int i=0; i<dbu.Vu.size(); i++)
    		if(email.compareTo(dbu.Vu.get(i).email)==0)
    			return false;
    	return true;
    }
    
    public boolean ValidateSignUp(User NewUser) {
    	if(VerifyNewUser(NewUser.email)) {
    		dbu.Vu.add(NewUser);
    		return true;
    	}
    	else {
    		System.out.println("This Email Already Exists!!!\nPlease Enter Another email");
    		return false;
    	}
    }
    
    public User GetPoster(String em) {
    	for(int i=0; i<dbu.Vu.size(); i++) {
    		if(dbu.Vu.get(i).email.compareTo(em)==0)
    			return dbu.Vu.get(i);
    	}
    	return null;
    }
    
    /*public void Write() {
    	try {
    	BufferedWriter b = new BufferedWriter(new FileWriter(new File("dbu.txt")));
    	for(int i=0; i<dbu.Vu.size(); i++) {
    		b.write(dbu.Vu.get(i));
    	}
    	}catch (IOException e) {
    		System.out.println("Failed to open");
		}
    }*/
}

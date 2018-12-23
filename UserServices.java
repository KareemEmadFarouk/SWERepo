import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class UserServices {
	
	User U;
	Verification v;
	

	public UserServices(User u, Verification vr) {
		U = u;
		v = vr;
	}
	
	public void ShowPosts() {
		for(int i=0; i<v.getPosts().size(); i++) {
			System.out.println("Lost Items " +(i+1) + ": " + v.getPosts().get(i).postType +" -->*Picture");
		}
	}
	
	public void makepost(){
        Post p = new Post();
    	fillPost(p, 0);
    	v.AddPost(p);
        System.out.println(" Done ! Shater ya habebiiiii");
    }
	
	public void fillPost(Post p, int n){ // Poster
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Enter type: ");
	    	p.postType = in.nextLine();
		}
		while(p.postType.compareTo("") == 0 && n != 1);
		do {
	    	System.out.println("Enter Description: ");
	    	p.postDesc = in.nextLine();
		}
		while(p.postDesc.compareTo("") == 0);
		do {
		    System.out.println("Enter Place: ");
	    	p.place = in.nextLine();
		}
		while(p.place.compareTo("") == 0);
	    p.postID = U.email + "&" + Integer.toString(p.Counter);
    	p.Counter++;
    }
	
	public void Claim(Authentication a, int op) {
		if(op == -1){
			ShowPosts();
			System.out.println("Enter Number of the post: ");
			Scanner in = new Scanner(System.in);
			op = in.nextInt();
		}
		op--;
		System.out.println("Enter information about your Item");
		Post p = new Post();
		fillPost(p, 1);
		
		if(v.compare(p, op)) {
			String []email = v.posts.Vp.get(op).postID.split("&");
			User poster = a.GetPoster(email[0]);
			poster.Notify.add("We found right owner of lost item !");
			System.out.println("This is your object \nThe Poster's number is : " + poster.phone);
			v.RemovePost(op);
		}
		else {
			System.out.println("This is not your item, we hope you find it (*_*)");
		}
	}
	
	public int Search(){
		System.out.println("Enter the type of your item: ");
		Scanner in = new Scanner(System.in);
		String type = in.nextLine();
		
		Vector<Integer> index = new Vector<>();
		ArrayList<Post> found = v.Search(type, index);
		
		if(found.size() == 0){
			System.out.println("oops!! ,We didn't find your Item, please try again later");
			return -1;
		}
		else{
			System.out.println("P# \t post");
			for(int i=0; i<found.size(); i++){
				System.out.println((index.get(i)+1) + "\t" + found.get(i).postType +" -->*Picture");
			}
			System.out.println("Enter Post Number you want to claim: ");
			int n = in.nextInt();
			return n;
		}
		
	}
}

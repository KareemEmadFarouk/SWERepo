import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Verification {

	DB_Post posts = new DB_Post();
	
	public void AddPost(Post p) {//done
		posts.Vp.add(p);
	}
	
	public boolean compare(Post p, int i) {//done
		String[] strlist1 = p.postDesc.split(" ");
		String[] strlist2 = p.place.split(" ");
		String[] strlist3 = posts.Vp.get(i).postDesc.split(" ");
		String[] strlist4 = posts.Vp.get(i).place.split(" ");
		
		List<String> list1 = Arrays.asList(strlist1);
		List<String> list2 = Arrays.asList(strlist2);
		List<String> list3 = Arrays.asList(strlist3);
		List<String> list4 = Arrays.asList(strlist4);
		
		List<String> InterSection = new ArrayList<>(list1);
		InterSection.retainAll(list3);
		
		List<String> InterSection2 = new ArrayList<>(list2);
		InterSection2.retainAll(list4);
		
		double percentage = InterSection.size()/list3.size() ;
		double percentage2 = InterSection2.size() / list4.size() ;
		
		if(percentage > 0.50 && percentage2 > 0.75)
			return true;
		else
			return false;
		
		/*
        if(posts.Vp.get(i).postDesc.contains(p.postDesc) && posts.Vp.get(i).place.contains(p.place)) { // that claimer is the right owner for the object.
            return true;
        }
        else
        	return false;
        	*/
	}
	
	public ArrayList<Post> Search(String type, Vector<Integer> in){
		ArrayList<Post> res = new ArrayList<>();
		for(int i=0; i<posts.Vp.size(); i++){
			if(posts.Vp.get(i).postType.contains(type)){
				res.add(posts.Vp.get(i));
				in.add(i);
			}
		}
		return res;
	}
	
	public void RemovePost(int i) {
		posts.Vp.remove(i);
	}
	
	public ArrayList<Post> getPosts(){
		return posts.Vp;
	}
}

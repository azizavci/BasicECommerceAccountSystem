package basicECommerceAccountSystem;

import java.util.ArrayList;
import java.util.List;

import basicECommerceAccountSystem.business.concretes.UserManager;
import basicECommerceAccountSystem.core.concretes.EMailCheckManager;
import basicECommerceAccountSystem.dataAccess.concretes.HibernateUserDao;
import basicECommerceAccountSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {


		List<User> users=new ArrayList<User>();
		UserManager userManager = new UserManager(new HibernateUserDao(users),new EMailCheckManager()); 
		User user1 = new User(1,"aziz","avci","aziz@avci.com","aziz123");	
		User user2 = new User(2,"cemal","süreya","aziz@avci.com","cemal123");	

		users.add(user1);
		users.add(user2);
		userManager.register(user1);
		userManager.register(user2);

		

	}

}

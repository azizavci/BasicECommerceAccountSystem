package basicECommerceAccountSystem.business.abstracts;

import basicECommerceAccountSystem.entities.concretes.User;

public interface UserService {

	void logIn(User user);
	void register(User user);
	void verifyEmail(User user);
	void loginWithGoogle(User user);
	
	
	
}

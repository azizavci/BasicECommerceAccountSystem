package basicECommerceAccountSystem.JGoogle.concretes;

import basicECommerceAccountSystem.entities.concretes.User;

public class JGoogleManager {

	public void loginWithGoogle(User user) {
		System.out.println("google ile oturum açýldý:"+user.getFirstName());
	}
	
}

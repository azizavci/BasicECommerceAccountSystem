package basicECommerceAccountSystem.JGoogle.concretes;

import basicECommerceAccountSystem.core.abstracts.JGoogleService;
import basicECommerceAccountSystem.entities.concretes.User;

public class JGoogleManagerAdapter implements JGoogleService{

	@Override
	public void loginWithGoogle(User user) {
		
		JGoogleManager googleManager=new JGoogleManager();
		googleManager.loginWithGoogle(user);
		
	}

}

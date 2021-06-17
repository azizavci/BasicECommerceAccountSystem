package basicECommerceAccountSystem.core.abstracts;

import basicECommerceAccountSystem.entities.concretes.User;

public interface EMailCheckService {

	boolean emailRegexCheck(User user);
	
}

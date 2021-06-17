package basicECommerceAccountSystem.business.concretes;


import basicECommerceAccountSystem.business.abstracts.UserService;
import basicECommerceAccountSystem.core.abstracts.EMailCheckService;
import basicECommerceAccountSystem.dataAccess.abstracts.UserDao;
import basicECommerceAccountSystem.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EMailCheckService eMailCheckService; 
	
	public UserManager(UserDao userDao, EMailCheckService eMailCheckService) {
		
		super();
		this.userDao = userDao;
		this.eMailCheckService = eMailCheckService;
		
	}

	@Override
	public void logIn(User user) {
		
		for (User u : userDao.getAll()) {
			
			if (u.geteMail()==user.geteMail() && u.getPassword()==user.getPassword()) {
				
				System.out.println("baþarýlý bir þekilde giriþ yapýldý");
				
			}
			
		}			
		
	}

	@Override
	public void register(User user) {
		

			
		if (userDao.getAll().contains(user)) {
				
				System.out.println("bu e-mail adresi zaten kullanýlýyor");		
				return;
		}
			
		
		
		if (user.getFirstName().trim()=="" || user.getLastName().trim()=="" ||user.geteMail().trim()=="" ||user.getPassword().trim()=="") {
			
			System.out.println("lütfen tüm alanlarý doldurunuz");
			

			
		}
		
		if (user.getFirstName().length()<=2 || user.getLastName().length()<=2) {
			
			System.out.println("adýnýz veya soyadýnýz 2 az karakter olmalýdýr");
			return;

			
		}
		
		if(user.getPassword().length()<6) {
			
			System.out.println("parola en az 6 haneli olmalýdýr");
			return;

			
		}
		
		if (!eMailCheckService.emailRegexCheck(user)) {
			
			System.out.println("bu e-mail adresi geçersizdir");
			return;
			
		}
		
		
		
		userDao.add(user);
		System.out.println("e-mail adresiniz onaylandý.kayýt baþarýlý");
		
	}

	@Override
	public void verifyEmail(User user) {

		
		for (User u : userDao.getAll()) {
			
			if (user.geteMail()==u.geteMail()) {
				
				System.out.println("bu e-mail adresi zaten kullanýlýyor");
				
			}
		}
		
	}

	@Override
	public void loginWithGoogle(User user) {
		// TODO Auto-generated method stub
		
	}

	

}

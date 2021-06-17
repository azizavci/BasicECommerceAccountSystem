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
				
				System.out.println("ba�ar�l� bir �ekilde giri� yap�ld�");
				
			}
			
		}			
		
	}

	@Override
	public void register(User user) {
		

			
		if (userDao.getAll().contains(user)) {
				
				System.out.println("bu e-mail adresi zaten kullan�l�yor");		
				return;
		}
			
		
		
		if (user.getFirstName().trim()=="" || user.getLastName().trim()=="" ||user.geteMail().trim()=="" ||user.getPassword().trim()=="") {
			
			System.out.println("l�tfen t�m alanlar� doldurunuz");
			

			
		}
		
		if (user.getFirstName().length()<=2 || user.getLastName().length()<=2) {
			
			System.out.println("ad�n�z veya soyad�n�z 2 az karakter olmal�d�r");
			return;

			
		}
		
		if(user.getPassword().length()<6) {
			
			System.out.println("parola en az 6 haneli olmal�d�r");
			return;

			
		}
		
		if (!eMailCheckService.emailRegexCheck(user)) {
			
			System.out.println("bu e-mail adresi ge�ersizdir");
			return;
			
		}
		
		
		
		userDao.add(user);
		System.out.println("e-mail adresiniz onayland�.kay�t ba�ar�l�");
		
	}

	@Override
	public void verifyEmail(User user) {

		
		for (User u : userDao.getAll()) {
			
			if (user.geteMail()==u.geteMail()) {
				
				System.out.println("bu e-mail adresi zaten kullan�l�yor");
				
			}
		}
		
	}

	@Override
	public void loginWithGoogle(User user) {
		// TODO Auto-generated method stub
		
	}

	

}

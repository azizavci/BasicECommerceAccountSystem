package basicECommerceAccountSystem.dataAccess.concretes;

import java.util.List;

import basicECommerceAccountSystem.dataAccess.abstracts.UserDao;
import basicECommerceAccountSystem.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	
	private List<User> users;
	
	public HibernateUserDao(List<User> users) {
		super();
		this.users = users;
	}

	@Override
	public void add(User user) {
				
		System.out.println("YEN� KULLANICI EKLEND�");
		System.out.println("KULLANICI B�LG�LER�");
		System.out.println("KULLANICI ID :"+user.getId());
		System.out.println("KULLANICI ADI :"+user.getFirstName());
		System.out.println("KULLANICI SOYADI :"+user.getLastName());
		System.out.println("KULLANICI EMAIL :"+user.geteMail());

		
	}

	@Override
	public void delete(User user) {
		
		users.remove(user);
		
		System.out.println("KULLANICI B�LG�S� S�L�ND�");
		System.out.println("KULLANICI B�LG�LER�");
		System.out.println("KULLANICI ID :"+user.getId());
		System.out.println("KULLANICI ADI :"+user.getFirstName());
		System.out.println("KULLANICI SOYADI :"+user.getLastName());
		System.out.println("KULLANICI EMAIL :"+user.geteMail());
		
	}

	@Override
	public void update(User user) {
		
		System.out.println("KULLANICI B�LG�S� G�NCELLEND�");
		System.out.println("KULLANICI B�LG�LER�");
		System.out.println("KULLANICI ID :"+user.getId());
		System.out.println("KULLANICI ADI :"+user.getFirstName());
		System.out.println("KULLANICI SOYADI :"+user.getLastName());
		System.out.println("KULLANICI EMAIL :"+user.geteMail());		
		
	}

	@Override
	public User get(int id) {
		
		for (User user : users) {
			
			if (user.getId()==id) {
				
				return user;
				
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

}

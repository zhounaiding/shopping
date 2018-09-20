package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.dao.UserDao;
import shopping.entity.Product;
import shopping.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user) {
		return userDao.register(user);
	}

	public User login(String emailId, String password) {
		return userDao.login(emailId, password);
	}

	public User getProfile(String emailId) {
		return userDao.getProfile(emailId);
	}

	public boolean addProduct(Product product) {
		return userDao.addProduct(product);
	}

}

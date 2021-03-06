package shopping.service;

import shopping.entity.Product;
import shopping.entity.User;

public interface UserService {
	
	boolean register(User user);
	
	Integer login(String emailId, String password);
	
	User getProfile(int userId);
	
	boolean addProduct(Product product);
	
	boolean favorite(int userId, int productId);

}

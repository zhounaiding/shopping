package shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopping.common.RpcHelper;
import shopping.entity.User;
import shopping.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void getUser(@RequestBody User user, 
			HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject obj = new JSONObject();
		if (service.register(user)) {
			obj.put("status", "ok");
			obj.put("user", user.toJSONObject());
		} else {
			obj.put("status", "fail");
		}
		
		RpcHelper.writeResponse(response, obj);
	}
}
package cn.ssm.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ssm.entity.User;
import cn.ssm.service.master.login.LoginService;

/**
 * @author 康钟 
 * @date 2017年9月21日 
 * @version 1.0 
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login")
	public User login(String loginName,String password,HttpServletRequest request) {
		User user = loginService.login(loginName, password);
		if(null != user) {
			request.getSession().setAttribute("user", user);
			return user;
		}else {
			return null;
		}
	}
	
	@RequestMapping("/getsession")
	public User getSessionAttribute(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}
}

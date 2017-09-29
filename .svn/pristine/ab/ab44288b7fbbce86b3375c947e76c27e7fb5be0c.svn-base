package cn.ssm.service.impl.master.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ssm.entity.User;
import cn.ssm.mapper.master.UserMapper;
import cn.ssm.service.master.login.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(String loginName, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("password", password);
		User user = userMapper.login(params);
		return user==null?null:user;
	}
}
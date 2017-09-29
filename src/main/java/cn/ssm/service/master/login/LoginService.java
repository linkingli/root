package cn.ssm.service.master.login;

import cn.ssm.entity.User;

public interface LoginService {
	

	User login(String loginName, String password);
}

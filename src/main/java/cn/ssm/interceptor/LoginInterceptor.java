package cn.ssm.interceptor;

/**
 * @author 康钟 
 * @date ${date} 
 * @version 1.0 
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * @author 蒙磊
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String uri = request.getRequestURI();
		if (uri.endsWith(".js") && uri.endsWith(".img") && uri.endsWith(".png") && uri.endsWith(".html")
				&& uri.endsWith(".css") && uri.endsWith(".jpg") && uri.endsWith(".gif")) {
			return true;
		} else {
			if("/login/login".equals(uri) || "/login/getsession".equals(uri)) {
				return true;
			}else {
				User user = (User) request.getSession().getAttribute("user");
				return user==null?false:true;
			}
		}
	}

}

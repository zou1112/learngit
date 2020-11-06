package cn.appinfo.tools;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appinfo.pojo.DevUser;;

public class SysInterceptor extends HandlerInterceptorAdapter{
	private Logger logger=Logger.getLogger(getClass());
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) throws Exception{
		logger.debug("SysInterceptor preHandle");
		HttpSession session=request.getSession();
		DevUser user=(DevUser) session.getAttribute(Constants.USER_SESSION);
		if(null==user){
			response.sendRedirect(request.getContextPath()+"/401.jsp");
			return false;
		}
		return true;
	}
}

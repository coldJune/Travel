package com.competition.db.interceptor;

import java.util.Map;

import com.competition.db.action.UserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 	用于检测是否已经登录
 * @author 笨蛋
 *	 @date 2016/6/1
 */
public class LoginInteceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2597905879216780208L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		if(UserAction.class==invocation.getAction().getClass()){
			return invocation.invoke();
		}
		Map<String, Object> map = invocation.getInvocationContext().getSession();
		if(map.get("userinfo")==null){
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
	
}

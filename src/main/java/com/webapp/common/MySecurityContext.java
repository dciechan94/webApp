package com.webapp.common;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {


	/*private UserDetails user;
	
	public MySecurityContext( UserDetails pUser ) {
		user = pUser;
	}
	*/
	@Override
	public Principal getUserPrincipal() {
		return new Principal() {
			@Override
			public String getName() {
				//return Long.toString(user.getId());
				return "";
			}
		};
	}

	@Override
	public boolean isUserInRole(String string) {
		/*System.out.println(string + " hahah " + MyAuthBackend.getUserRoles(user.getId()).stream().map(role-> role.getName()).collect(Collectors.toList()).contains(string));
		boolean value = MyAuthBackend.getUserRoles(user.getId()).stream().map(role-> role.getName()).collect(Collectors.toList()).contains(string);
		return value;*/
		return true;
	}

	@Override
	public boolean isSecure() {
		return false;
		//return requestContext.getSecurityContext().isSecure();
	}

	@Override
	public String getAuthenticationScheme() {
		return BASIC_AUTH;
		//return requestContext.getSecurityContext().getAuthenticationScheme();
	}

}

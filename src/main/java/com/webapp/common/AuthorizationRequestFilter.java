package com.webapp.common;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
// @Priority(Priorities.AUTHORIZATION)
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	// private final static String HEADER_AUTHORIZATION = "authToken";
	// private final static String HEADER_DATE = "authDate";
	// private final static String HEADER_NONCE = "authNonce";


	public void filter(ContainerRequestContext request) {
		// String authToken = request.getHeaderString(HEADER_AUTHORIZATION);
		// String requestDateString = request.getHeaderString(HEADER_DATE);

		System.out.println("FUUUUUUUUUUUUUUUUUUUCK!!!!!!!!!!!!!!!!!");
		// System.out.println(request.getSecurityContext().isUserInRole("Role1")+"
		// "+request.getSecurityContext().isUserInRole("Role7"));

		// if (authToken != null) {
		//
		// if (validToken(authToken, requestDateString)) {
		// request.setSecurityContext(grantPermissions(request));
		// } else {
		// //revokePermission();
		// }
		// } else {
		// // fajny panel logowania
		//// request.abortWith(
		//// Response.status(Status.UNAUTHORIZED)
		//// .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Example\"")
		//// .entity("Login required.").build());
		// request.abortWith(Response.status(Status.UNAUTHORIZED).entity("Login
		// required").build());
		// }

		// System.out.println(request.getSecurityContext().isUserInRole("Role1")+"
		// "+request.getSecurityContext().isUserInRole("Role7"));
	}

	// private String generateToken(RoleType roleType) {
	// return "1q2w3e";
	// }

	// private boolean validToken(String authToken, String requestDateString) {
	//// if(niepoprawna posta� tokena) {
	//// return false;
	//// }
	//// if(token nie istnieje w bazie aktywnych token�w) {
	//// return false;
	//// }
	// return true;
	// }

	// private SecurityContext grantPermissions(ContainerRequestContext request
	// ) {
	// UserDetails externalUser = MyAuthBackend.getUserById(
	// MyAuthBackend.authenticate("admin",
	// "pass") ).get();
	// //request.setSecurityContext(new MySecurityContext(externalUser));
	// return new MySecurityContext(externalUser);
	//
	// }

}
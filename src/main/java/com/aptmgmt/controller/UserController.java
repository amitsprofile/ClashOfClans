package com.aptmgmt.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.model.User;
import com.aptmgmt.model.UserCredential;
import com.aptmgmt.services.UserDetailService;
import com.aptmgmt.utils.CustomUtils;

@Component
@Controller
@RequestMapping(value = "user")
public class UserController {

	private UserDetailService userService;

	/**
	 * Retrieves the currently logged in user.
	 *
	 * @return A transfer containing the username and the roles.
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
/*	@RequestMapping(value = "/auth", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUser() throws JsonGenerationException, JsonMappingException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (!(principal instanceof User)) {
			throw new WebApplicationException(401);
		}
		com.aptmgmt.model.User user = (com.aptmgmt.model.User) principal;

		return CustomUtils.writeValueAsString(user);
	}*/

	/**
	 * Authenticates a user and creates an access token.
	 *
	 * @param username
	 *            The name of the user.
	 * @param password
	 *            The password of the user.
	 * @return The generated access token.
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String authenticate(@RequestBody UserCredential userCred)
			throws JsonGenerationException, JsonMappingException, IOException {
		return CustomUtils.writeValueAsString(userService.authenticate(userCred));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String register(@RequestBody User user)
			throws JsonGenerationException, JsonMappingException, IOException {
		return CustomUtils.writeValueAsString(userService.saveUser(user));
	}

	public UserDetailService getUserService() {
		return userService;
	}

	public void setUserService(UserDetailService userService) {
		this.userService = userService;
	}
}

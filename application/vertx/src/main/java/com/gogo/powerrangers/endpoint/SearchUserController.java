package com.gogo.powerrangers.endpoint;

import com.gogo.powerrangers.UserController;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class SearchUserController extends Controller{

	private final UserController controller;
	
	public SearchUserController(UserController controller) {
        this.controller = controller;
    }
	
	public void findUser(final RoutingContext routingContext) {
		var response = routingContext.response();
		var userEmail = routingContext.request().params().get("email");
		if (userEmail == null) {
			sendError(400, response);
		} else {
			try {
				var user = controller.searchByEmail(userEmail);
				JsonObject jsonObject = new JsonObject(Json.encode(user));
				sendSuccess(jsonObject, response);
			} catch (RuntimeException e) {
				sendError(404, response);
			}
		}
	}
}

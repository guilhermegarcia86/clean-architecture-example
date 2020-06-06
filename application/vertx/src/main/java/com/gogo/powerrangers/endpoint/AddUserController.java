package com.gogo.powerrangers.endpoint;

import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.model.UserModel;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class AddUserController extends Controller{
	
	private final UserController controller;
	
	public AddUserController(UserController controller) {
        this.controller = controller;
    }
	
	public void createUser(final RoutingContext routingContext) {
        var response = routingContext.response();
        var body = routingContext.getBody();
        if (isNull(body)) {
            sendError(400, response);
        } else {
            var userModel = body.toJsonObject().mapTo(UserModel.class);
            var user = controller.createUser(userModel);
            var result = JsonObject.mapFrom(user);
            sendSuccess(result, response);
        }
    }

}

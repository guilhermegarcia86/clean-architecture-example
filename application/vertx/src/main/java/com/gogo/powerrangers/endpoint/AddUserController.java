package com.gogo.powerrangers.endpoint;

import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.presenter.UserPresenter;

import io.vertx.core.json.Json;
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
            var userModel = Json.decodeValue(body.toJsonObject().encode(), UserPresenter.class);
            var user = controller.createUser(userModel);
            JsonObject jsonObject = new JsonObject(Json.encode(user));
            sendSuccess(jsonObject, response);
        }
    }

}

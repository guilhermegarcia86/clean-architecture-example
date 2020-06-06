package com.gogo.powerrangers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gogo.powerrangers.config.VertxConfig;
import com.gogo.powerrangers.endpoint.AddUserController;
import com.gogo.powerrangers.endpoint.SearchUserController;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class VertxApplication extends AbstractVerticle{
	
	private final VertxConfig config = new VertxConfig();
	private final UserController userController = new UserController(config.createUser(), config.searchUser());
    private final AddUserController addUserController = new AddUserController(userController);
    private final SearchUserController searchUserController = new SearchUserController(userController);
    
    @Override
    public void start() {
        Json.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        var router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/add").handler(addUserController::createUser);
        router.get("/user").handler(searchUserController::findUser);

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    public static void main(String[] args) {
        Launcher.executeCommand("run", VertxApplication.class.getName());
    }
}
package com.gogo.powerrangers.endpoint;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;

public abstract class Controller {
	
    public boolean isNull(final Buffer buffer) {
        return buffer == null || "".equals(buffer.toString());
    }

    public void sendError(int statusCode, HttpServerResponse response) {
        response
                .putHeader("content-type", "application/json")
                .setStatusCode(statusCode)
                .end();
    }

    public void sendSuccess(JsonObject body, HttpServerResponse response) {
        response
                .putHeader("content-type", "application/json")
                .end(body.encodePrettily());
    }

}

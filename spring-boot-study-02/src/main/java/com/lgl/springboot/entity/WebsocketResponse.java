package com.lgl.springboot.entity;

import lombok.Data;

/**
 * Created by Leo. on 2018/7/30.
 */
@Data
public class WebsocketResponse {

    private String responseMsg;

    public WebsocketResponse(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}

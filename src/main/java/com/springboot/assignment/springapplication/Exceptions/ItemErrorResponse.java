package com.springboot.assignment.springapplication.Exceptions;

import lombok.Data;

public @Data class ItemErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public ItemErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ItemErrorResponse() {
    }
}

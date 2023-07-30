package com.fpassada.wishlist.exception;

import lombok.Getter;

@Getter
public class WishlistException extends Throwable {

    private final String message;
    private final int errorCode;

    public WishlistException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}

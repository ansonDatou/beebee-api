package com.quwan.beebee.exception;

import org.apache.commons.lang3.Validate;

public final class DaoException extends Exception {
    private ErrorCode errorCode = ErrorCode.Unknown;

    public DaoException() {
        super();
    }

    public DaoException(ErrorCode errorCode) {
        super();

        Validate.notNull(errorCode);
        this.errorCode = errorCode;
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, ErrorCode errorCode) {
        super(message);

        Validate.notNull(errorCode);
        this.errorCode = errorCode;
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);

        Validate.notNull(errorCode);
        this.errorCode = errorCode;
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(Throwable cause, ErrorCode errorCode) {
        super(cause);

        Validate.notNull(errorCode);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
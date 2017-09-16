package com.boot.exception;

public class ShipwreckNotFound extends NoDataFoundException {

	private static final long serialVersionUID = 8809600319315701667L;

	public ShipwreckNotFound() {
		super();
	}

	public ShipwreckNotFound(String message) {
		super(message);
	}

	public ShipwreckNotFound(Throwable cause) {
		super(cause);
	}

	public ShipwreckNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipwreckNotFound(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package de.dhbw.tinf23b.exceptions;

import java.io.IOException;

public class SensorException extends IOException {

	private static final long serialVersionUID = 2405713940306553730L;

	public SensorException() {
		super();
	}

	public SensorException(String message, Throwable cause) {
		super(message, cause);
	}

	public SensorException(String message) {
		super(message);
	}

	public SensorException(Throwable cause) {
		super(cause);
	}
}

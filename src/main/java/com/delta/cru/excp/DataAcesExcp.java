package com.delta.cru.excp;

public class DataAcesExcp extends Exception {

	private static final long serialVersionUID = 6733896835579677227L;

	public DataAcesExcp(Throwable cse) {
		super(cse);
	}

	/**
	 * Creates an exception object with the specified code, message and cause.
	 */
	public DataAcesExcp(String msg) {
		super(msg);
	}

}

package com.tamco.exception;

/**
 * Created by tam-co on 28/03/2017.
 */
public class ExceptionHandler {

	// If we want to propagate checked exception we have to declare throws checked exception
	public void throwCheckedException() throws CheckedException {
		System.out.println("Checked exception is thrown here in throwCheckedException method");
		Throwable cause = new Throwable("Checked exception");
		throw new CheckedException(cause);
	}

	public void handleCheckedException() {
		try {
			throwCheckedException();

		} catch (CheckedException e) {
			System.out.println("And handleCheckedException method will handle: " + e.getMessage());
		}
	}

	// We can normally propagate unchecked exception without declare throws exception unchecked exception
	public void throwUncheckedException() {
		System.out.println("Unchecked exception is thrown here in throwUncheckedException method");
		Throwable cause = new Throwable("Unchecked exception");
		throw new UncheckedException(cause);
	}

	public void handleUncheckedException() {
		try {
			throwUncheckedException();

		} catch (UncheckedException e) {
			System.out.println("And handleUncheckedException method will handle: " + e.getMessage());
		}
	}
}

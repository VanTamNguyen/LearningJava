package com.tamco.exception;

/**
 * Created by tam-co on 28/03/2017.
 */
public class CheckedException extends Throwable {
	/*
	* The Sun Micro System said that there is 3 types of exceptions
	* 1. Checked exception: all classes extend Throwable are checked exceptions except RuntimeException and Error.
	*    Checked exceptions are checked at compile-time
	*
	* 2. Unchecked exception: all classes extend RuntimeException. Unchecked exceptions are checked at runtime
	*
	* 3. Error
	**/

	/*
	*
	* This class illustrates checked exception
	*
	**/

	public CheckedException(Throwable cause) {
		super(cause);
	}
}

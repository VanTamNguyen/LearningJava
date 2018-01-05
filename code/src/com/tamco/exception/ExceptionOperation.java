package com.tamco.exception;

/**
 * Created by tam-co on 28/03/2017.
 */
public class ExceptionOperation {

	public static void main(String[] args) {

		ExceptionHandler handler = new ExceptionHandler();
		handler.handleCheckedException();

		System.out.println("\n********************************\n");
		handler.handleUncheckedException();
	}
}

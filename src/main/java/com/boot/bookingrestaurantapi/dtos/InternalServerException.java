package com.boot.bookingrestaurantapi.dtos;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.boot.bookingrestaurantapi.Exceptions.BookingException;

public class InternalServerException extends BookingException{

	private static final long serialVersionUID = 1L;
	public InternalServerException(String code, String message) {
		super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	public InternalServerException(String code, String message, ErrorDto data) {
		super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}

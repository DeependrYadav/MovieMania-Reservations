package com.moviesmania;

import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		LocalTime time = LocalTime.parse("09:50");
		System.out.println(time.getHour());
	}
}

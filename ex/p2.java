package ex;

import org.assertj.core.api.Assertions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<2;i++) {
			String input = sc.nextLine();
			Car suv = new SUV();
			if(input.equals("topSpeed")){
				suv.topSpeed();
			}
			if(input.equals("fuelType")){
				suv.fuelType();
			}
			Car car = new Car();
			if(input.equals("topSpeed")){
				car.topSpeed();
			}
			if(input.equals("fuelType")){
				car.fuelType();
			}
		}
	}

}

/*
 * public void topSpeed() prints "Top Speed of the vehicle is 100 kmph" with a newline.
 * public void fuelType() prints "Car fuel type is Petrol" with a new line.
 * public void fuelType() prints  "SUV fuel type is Diesel" with a new line.
 */

class Car {
	public void topSpeed() {
		System.out.println("Top Speed of the vehicle is 100 kmph");
	}

	public void fuelType() {
		System.out.println("Car fuel type is Petrol");
	}
}

class SUV extends Car {
	public void fuelType() {
		System.out.println("SUV fuel type is Diesel");
	}
}

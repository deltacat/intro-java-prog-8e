package chapter03;

import java.util.Scanner;

public class ComputeBMI {
	public static void main(String[] args) {

		final double KILOGRAMS_PER_POUND = 0.45359237;
		final double METERS_PER_INCH = 0.0254;
		final double METERS_PER_CM = 0.01;
		boolean usingBritishSystem = false;

		Scanner input = new Scanner(System.in);

		String weightUnit = usingBritishSystem ? "pounds" : "kg";
		String heightUnit = usingBritishSystem ? "inches" : "cm";

		System.out.println("Input wight in " + weightUnit);
		double weight = input.nextDouble();

		System.out.println("Input height in " + heightUnit);
		double height = input.nextDouble();

		input.close();

		// Convert unit then calculate BMI
		double weightInKilograms = usingBritishSystem ? weight
				* KILOGRAMS_PER_POUND : weight;
		double heightInMeters = usingBritishSystem ? height * METERS_PER_INCH
				: height * METERS_PER_CM;
		double bmi = weightInKilograms / (heightInMeters * heightInMeters);

		// output
		System.out.println("Your BMI is " + bmi);
		if (bmi < 16)
			System.out.println("Your are seriously underweight.");
		else if (bmi < 18)
			System.out.println("Your are underweight.");
		else if (bmi < 24)
			System.out.println("Your are normal weight.");
		else if (bmi < 29)
			System.out.println("Your are overweight.");
		else if (bmi < 35)
			System.out.println("Your are seriously overweight.");
		else
			System.out.println("Your are gravely overweight.");

  }
}

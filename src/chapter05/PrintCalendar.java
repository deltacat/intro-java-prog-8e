/**
 * 
 */
package chapter05;

import java.util.Scanner;

public class PrintCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//

		Scanner input = new Scanner(System.in);

		// Promote user to input year
		System.out.print("Please input full year (e.g., 2015): ");
		int year = input.nextInt();

		// Promote user to input month
		System.out.print("Please input month, a number between 1 and 12: ");
		int month = input.nextInt();

		input.close();

		// Print calendar of the month and year
		printMonth(year, month);

	}

	public static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}

	/** print the title rows */
	public static void printMonthTitle(int year, int month) {
		System.out.println("        " + getMonthName(month) + " " + year);
		System.out.println("----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	public static String getMonthName(int month) {
		String monthName = "Unknown";
		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "Feburary";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		default:
			break;
		}

		return monthName;
	}

	public static void printMonthBody(int year, int month) {
		// get the start day of week for the first date in the month
		int startDay = getStartDay(year, month);

		// get number of days in the month
		int daysOfMonth = getDaysOfMonth(year, month);

		int i = 0;

		for (i = 0; i < startDay; i++)
			System.out.print("    ");

		for (i = 1; i < daysOfMonth; i++) {
			System.out.printf("%4d", i);
			if ((i + startDay) % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}

	/** get the start day of the month/1/year */
	public static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;

		int totalDays = getTotalDays(year, month);

		int startDay = (totalDays + START_DAY_FOR_JAN_1_1800) % 7;

		return startDay;
	}

	/** get number of days in a month */
	public static int getDaysOfMonth(int year, int month) {
		int days = 31;

		if (2 == month) {
			days = isLeapYear(year) ? 29 : 28;
		} else if (4 == month || 6 == month || 9 == month || 11 == month) {
			days = 30;
		}

		return days;

	}

	/** get total number of days since January 1, 1800 */
	public static int getTotalDays(int year, int month) {
		int total = 0;

		for (int i = 1800; i < year; i++) {
			total += isLeapYear(i) ? 366 : 365;
		}

		for (int i = 1; i < month; i++) {
			total += getDaysOfMonth(year, i);
		}

		return total;
	}

	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

}

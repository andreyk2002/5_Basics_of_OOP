package by.epam_tc.oop_basics.calendar.logic;

import by.epam_tc.oop_basics.calendar.entity.Calendar;
import by.epam_tc.oop_basics.calendar.entity.Calendar.Holiday;

import java.time.*;

public class CalendarLogic {
	
	private static CalendarLogic instance = null;
	
	public static CalendarLogic getInstance() {
		if(instance == null) {
			instance = new CalendarLogic();
		}
		return instance;
	}
	
	private CalendarLogic() {
		
	}

	public void fillDays(Calendar c) {
		int dayNumber;
		dayNumber = determineDayNumber(c.getYear());
		// count day of the week of Jan. 1
		boolean isLeap = isLeapYear(c.getYear());
		if (dayNumber == 0) {
			// if SUNDAY
			dayNumber = 7;
		}
		if(isLeap) {
			dayNumber--;
		}
		
		fillYear(c, isLeap, dayNumber);
	}

	private void fillYear(Calendar c, boolean isLeap, int dayNumber) {
		int len = Calendar.DAYS;
		if (isLeapYear(c.getYear())) {
			len = Calendar.LEAP_DAYS;
		}
		int i = 1;
		while (i <= len) {
			DayOfWeek dayOfWeek = DayOfWeek.of(dayNumber);
			String dayName;
			if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
				dayName = dayOfWeek.toString();
				LocalDate date = LocalDate.ofYearDay(c.getYear(), i);
				Holiday weekend = new Holiday(date, dayName);
				c.getDays().add(weekend);
			}
			dayNumber++;
			if (dayNumber > 7) {
				dayNumber = 1;
			}

			i++;
		}
	}

	public boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		}
		if (year % 100 != 0) {
			return true;
		}
		if (year % 400 == 0) {
			return true;
		}
		return false;
	}

	private int determineDayNumber(int year) {
		return (1 + getYearCode(year)) % 7;
		/*
		 * Formula (day number + month code + year code) % 7 For 01.01.XXXX - Jan. code
		 * = 1.
		 */
	}

	private int getYearCode(int year) {
		int yearCode;
		yearCode = getCode(year) + year % 100 + ((year % 100) / 4);
		yearCode %= 7;
		
		return yearCode;
	}

	private int getCode(int year) {
		int century = year / 100;
		if (century % 4 == 0) {
			return 6;
		}
		if (century % 4 == 1) {
			return 4;
		}
		if (century % 4 == 2) {
			return 2;
		}
		return 0;
	}

	public Holiday findHoliday(Calendar c, LocalDate date) {
		for (var holiday : c.getDays()) {
			if (holiday.getHolidayDate().equals(date)) {
				return holiday;
			}
		}
		return null;
	}
	public void removeHoliday(Calendar c, String name) {
		removeHoliday(c,name, LocalDate.MAX);
	}

	public void removeHoliday(Calendar c, LocalDate date) {
		removeHoliday(c, "", date);
	}

	public void removeHoliday(Calendar c, String name, LocalDate date) {
		for (var holiday : c.getDays()) {
			if (holiday.getHolidayDate().equals(date) || holiday.getName().equals(name)) {
				c.getDays().remove(holiday);
				return;
			}
		}
	}

	public void addHoliday(Calendar c, LocalDate date, String holidayName) {
		
		Holiday previousHoliday = findHoliday(c, date);
		if (previousHoliday != null) {
			previousHoliday.setName(holidayName);
			return;
		}
		Holiday holiday = new Holiday(date, holidayName);
		c.getDays().add(holiday);
	}

	public void addHoliday(Calendar c, int dayOfMonth, int month, String holidayName) {
		LocalDate date = LocalDate.of(c.getYear(), month, dayOfMonth);
		addHoliday(c, date, holidayName);
	}
}

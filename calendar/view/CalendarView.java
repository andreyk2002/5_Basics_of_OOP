package by.epam_tc.oop_basics.calendar.view;

import by.epam_tc.oop_basics.calendar.entity.Calendar;


public class CalendarView {

	private static CalendarView instance = null;

	public static CalendarView getInstance() {
		if (instance == null) {
			instance = new CalendarView();
		}
		return instance;
	}

	private CalendarView() {

	}

	public void showHolidaysAndWeekends(Calendar c) {
		for (var holiday : c.getDays()) {
			System.out.println(holiday.toString());
		}
	}

	public void showHolidays(Calendar c) {
		boolean isEmpty = true;
		for (var holiday : c.getDays()) {
			if (!(holiday.getName().equalsIgnoreCase("SATURDAY") || holiday.getName().equalsIgnoreCase("SUNDAY"))) {
				System.out.println(holiday.toString());
				isEmpty = false;
			}
		}
		if(isEmpty) {
			System.out.println("No holidays found :(");
		}
	}

}

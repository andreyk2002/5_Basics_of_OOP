package by.epam_tc.oop_basics.calendar.main;

import java.time.DateTimeException;

import by.epam_tc.oop_basics.calendar.entity.Calendar;
import by.epam_tc.oop_basics.calendar.logic.CalendarLogic;
import by.epam_tc.oop_basics.calendar.view.CalendarView;

public class CalendarMain {

	public static void main(String... argc) {
		Calendar thisYear;
		thisYear = new Calendar(2020);

		CalendarView view = CalendarView.getInstance();
		CalendarLogic logic = CalendarLogic.getInstance();
		view.showHolidaysAndWeekends(thisYear);
		System.out.println();
		view.showHolidays(thisYear);
		System.out.println();

		try {
			logic.addHoliday(thisYear, 9, 5, "Victory Day");
			logic.addHoliday(thisYear, 31, 12, "New Year");
			logic.addHoliday(thisYear, 1, 5, "Children's day");
			logic.addHoliday(thisYear, 1, 9, "First ring");
			logic.addHoliday(thisYear, 25, 12, "Christmas day");
			logic.addHoliday(thisYear, 7, 1, "Christmas day");
		} catch (DateTimeException e) {
			System.out.println(e.getMessage());
		} finally {
			view.showHolidays(thisYear);
		}

	}

}

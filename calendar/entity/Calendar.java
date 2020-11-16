package by.epam_tc.oop_basics.calendar.entity;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import by.epam_tc.oop_basics.calendar.logic.CalendarLogic;

public class Calendar implements Serializable {

	private static final long serialVersionUID = 5580957449164655304L;
	public static final int DAYS = 365;
	public static final int LEAP_DAYS = 366;
	private List<Holiday> days = new ArrayList<Holiday>();
	private int year;

	public Calendar(int year) {
		this.year = year;
		CalendarLogic logic = CalendarLogic.getInstance();
		logic.fillDays(this);
	}

	public Calendar() {
		this(2020);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Holiday> getDays() {
		return days;
	}

	public static class Holiday implements Serializable {

		private static final long serialVersionUID = 3352628951417925936L;
		private String name;
		private LocalDate holidayDate;

		public Holiday(LocalDate holidayDate, String name) {
			super();
			this.holidayDate = holidayDate;
			setName(name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getHolidayDate() {
			return holidayDate;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((holidayDate == null) ? 0 : holidayDate.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Holiday other = (Holiday) obj;
			if (holidayDate == null) {
				if (other.holidayDate != null)
					return false;
			} else if (!holidayDate.equals(other.holidayDate))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Holiday{" + holidayDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - " + name + '}';
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendar [days=" + days + ", year=" + year + "]";
	}

}

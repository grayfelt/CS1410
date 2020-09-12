class JulianDate extends Date {
    JulianDate() {
        super(1, 1, 1);
        int days = (int) ((System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24) + 719164;
        int year = 1;
        int month = 1;
        int day = 1;
        for (int i = 0; i < days; i++) {
            day++;
            if (day > getNumberOfDaysInMonth()) {
                day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }
            setDay(day);
            setMonth(month);
            setYear(year);
            setMonthName();
            setIsLeapYear(isLeapYear(year));
        }

    }
    boolean isLeapYear(int year) {
        boolean isLeapYear;
        isLeapYear = year % 4 == 0;
        return isLeapYear;
    }
    JulianDate(int year, int month, int day) {
        super(year, month, day);
        setMonthName();
        setIsLeapYear(isLeapYear(year));
    }
}


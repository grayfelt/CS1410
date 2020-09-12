class GregorianDate extends Date {
    GregorianDate() {
        super(1970, 1, 1);
        long currentMil = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        int days = (int) ((currentMil) / 1000 / 60 / 60 / 24);
        int year = 1970;
        int month = 1;
        int day = 1;
        for (int i = 0; i < days; i++) {
            day += 1;
            if (day > getNumberOfDaysInMonth()) {
                day = 1;
                month += 1;
            }
            if (month > 12) {
                month = 1;
                year += 1;
            }
            setDay(day);
            setMonth(month);
            setYear(year);
            setMonthName();
            setIsLeapYear(isLeapYear(year));
        }
    }

    GregorianDate(int year, int month, int day) {
        super(year, month, day);
        setMonthName();
        setIsLeapYear(isLeapYear(year));
    }
    boolean isLeapYear(int year) {
        boolean isLeapYear;
        isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        return isLeapYear;
    }
}
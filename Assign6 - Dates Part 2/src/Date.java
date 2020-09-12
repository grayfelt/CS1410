class Date {
    private int year;
    private int month;
    private int day;
    private boolean isLeapYear;
    private String monthName;

    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private int getNumberOfDaysInMonth(int year, int month) {
        int numDays = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 2:
                if (isLeapYear(year)){
                    numDays = 29;
                    break;
                } else{
                    numDays = 28;
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
        }
        return numDays;
    }
    private String getMonthName(int month) {
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
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

        }
        return monthName;
    }
    void printShortDate(){
        System.out.println(getMonth() + "/" + getDayOfMonth() + "/" + getYear());
    }
    void printLongDate(){
        String monthName = getMonthName(month);
        System.out.println(monthName + " " + getDayOfMonth() + ", " + getYear());
    }
    void subtractDays(int days) {
        for (int i = 0; i < days; i++) {
            day--;
            if(day < 1){
                month--;
                day = getNumberOfDaysInMonth(year, month);
            }
            if(month < 1){
                year--;
                month = 12;
                day = 31;
            }
        }

    }
    void addDays(int days) {
        for (int i = 0; i < days; i++) {
            day++;
            if(day > getNumberOfDaysInMonth(year, month)){
                day = 1;
                month++;
            }
            if(month > 12){
                year++;
                month = 1;
            }
        }
    }
    int getMonth() {
        return this.month;
    }

    int getYear() {
        return this.year;
    }

    String getMonthName() {
        return this.monthName;
    }
    int getDayOfMonth() {
        return this.day;
    }

    int getNumberOfDaysInMonth() {
        return getNumberOfDaysInMonth(this.year, this.month);
    }
    boolean isLeapYear() {
        return this.isLeapYear;
    }
    void setDay(int day) {
        this.day = day;
    }
    void setMonth(int month) {
        this.month = month;
    }
    void setYear(int year){
        this.year = year;
    }
    void setIsLeapYear(boolean isLeapYear){
        this.isLeapYear = isLeapYear;
    }
    void setMonthName() {
        this.monthName = getMonthName(this.month);
    }
    boolean isLeapYear(int year) {
        boolean isLeapYear;
        isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        return isLeapYear;
    }
}

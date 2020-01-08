package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;


public class Date {
    private int year = -1;
    private int month = -1;
    private int day = -1;
    private int dayOfWeek = -1;

    /**
     * Instantiate date without dayOfYear field. dayOfWeek assigned -1;
     * @param nYear - year value
     * @param nMonth - month value
     * @param nDay - day value
     */
    public Date(int nYear, int nMonth, int nDay) {
        year = nYear;
        month = nMonth;
        day = nDay;
    }

    /**
     * set nDate values to this.
     * @param nDate values to set
     */
    public void set(Date nDate)
    {
        year = nDate.year;
        month = nDate.month;
        day = nDate.day;
        dayOfWeek = nDate.dayOfWeek;
    }

    /**
     * Instantiate date with dayOfYear field.
     */
    public Date(int nYear, int nMonth, int nDay, int nDayOfWeek) {
        year = nYear;
        month = nMonth;
        day = nDay;
        dayOfWeek = nDayOfWeek;
    }



    public void setDayOfWeek(int nDayOfWeek) { dayOfWeek = nDayOfWeek; }

    public int getDayOfWeek() { return  dayOfWeek; }

    public int  getDay() { return day; }

    public void setDay(int nDay){ day = nDay; }

    public int  getMonth() { return month; }

    public void setMonth(int nMonth) { month = nMonth; }

    public int  getYear() { return year; }

    public void setYear(int nYear) { year = nYear; }



    /**
     * Comparator of 2 dates
     * @param other - day to compare with
     * @return negative if less, 0 if equal, 1 if greater
     */
    public int compare(Date other){
        if (getYear() != other.getYear()){
            return getYear() - other.getYear();
        }
        if (getMonth() != other.getMonth()){
            return getMonth() - other.getMonth();
        }
        if (getDay() != other.getDay()){
            return getDay() - other.getDay();
        }
        return 0;
    }
}

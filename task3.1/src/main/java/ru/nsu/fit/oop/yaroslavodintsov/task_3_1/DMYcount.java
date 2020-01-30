package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;

/**
 * Class implements Days Months and Years count
 * It can be used for date representation
 *
 * year - year count
 * day - day count
 * month - month count
 * dayOfWeek - day of the week (mon, thu, wed, etc.)
 */
public class DMYcount {
    private int year = -1;
    private int month = -1;
    private int day = -1;
    private int dayOfWeek = -1;

    /**
     * Instantiate DMYcount without dayOfYear field. dayOfWeek assigned -1;
     * @param nYear - year value
     * @param nMonth - month value
     * @param nDay - day value
     */
    public DMYcount(int nYear, int nMonth, int nDay) {
        year = nYear;
        month = nMonth;
        day = nDay;
    }

    /**
     * set nDMYcount values to this.
     * @param nDMYcount values to set
     */
    public void set(DMYcount nDMYcount)
    {
        year = nDMYcount.year;
        month = nDMYcount.month;
        day = nDMYcount.day;
        dayOfWeek = nDMYcount.dayOfWeek;
    }

    /**
     * Instantiate DMYcount with dayOfYear field.
     */
    public DMYcount(int nYear, int nMonth, int nDay, int nDayOfWeek) {
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
     * Comparator of 2 DMYcounts
     * @param other - day to compare with
     * @return negative if less, 0 if equal, 1 if greater
     */
    public int compare(DMYcount other){
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

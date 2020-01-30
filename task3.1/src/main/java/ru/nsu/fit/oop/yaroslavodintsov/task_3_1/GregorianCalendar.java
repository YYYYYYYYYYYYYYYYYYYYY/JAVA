package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;

/**
 * Class realizes a gregorian calendar
 * It represents leap years for regular calendar
 *
 */
public class GregorianCalendar extends Calendar{

    /**
     * Is year leap
     * @return true if year is leap
     * @return false otherwise
     */
    public boolean isLeap(DMYcount DMYcount){
        if ((DMYcount.getYear() & 3) != 0) {
            return false;
        }
        if (DMYcount.getYear() % 400 == 0 || DMYcount.getYear() % 100 != 0){
            return true;
        }
        return false;
    }

    private void preInit() {
        setSomeDMYcount(new DMYcount(2020, 1, 1, 3));
    }

    /**
     * Instantiate calendar with DMYcount.
     * @param year - year;
     * @param month - month
     * @param day - day
     * @throws Exception - invalid DMYcount
     */
    public GregorianCalendar(int year, int month, int day) throws Exception{
        preInit();
        setCurrent(new DMYcount(year, month, day));
    }

    @Override
    public boolean isValid(DMYcount DMYcount) {
        if (1 <= DMYcount.getMonth() && DMYcount.getMonth() <= 12){
            if (1 <= DMYcount.getDay() && DMYcount.getDay() <= daysInMonth(DMYcount)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int daysInMonth(DMYcount DMYcount) {
        if (DMYcount.getMonth() == 1 || DMYcount.getMonth() == 3 || DMYcount.getMonth() == 5 || DMYcount.getMonth() == 7
                || DMYcount.getMonth() == 8 || DMYcount.getMonth() == 10 || DMYcount.getMonth() == 12) {
            return 31;
        }
        if (DMYcount.getMonth() == 4 || DMYcount.getMonth() == 6 || DMYcount.getMonth() == 9 || DMYcount.getMonth() == 11){
            return 30;
        }
        if (isLeap(DMYcount)) {
            return 29;
        }
        return 28;
    }
}

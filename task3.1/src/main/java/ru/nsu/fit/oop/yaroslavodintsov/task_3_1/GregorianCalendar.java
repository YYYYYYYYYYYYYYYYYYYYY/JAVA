package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;


public class GregorianCalendar extends Calendar{

    /**
     * Is year leap
     * @return true if year is leap
     * @return false otherwise
     */
    public boolean isLeap(Date date){
        if ((date.getYear() & 3) != 0) {
            return false;
        }
        if (date.getYear() % 400 == 0 || date.getYear() % 100 != 0){
            return true;
        }
        return false;
    }

    private void preInit() {
        setSomeDate(new Date(2020, 1, 1, 3));
    }

    /**
     * Instantiate calendar with date.
     * @param year - year;
     * @param month - month
     * @param day - day
     * @throws Exception - invalid date
     */
    public GregorianCalendar(int year, int month, int day) throws Exception{
        preInit();
        setCurrent(new Date(year, month, day));
    }

    @Override
    public boolean isValid(Date date) {
        if (1 <= date.getMonth() && date.getMonth() <= 12){
            if (1 <= date.getDay() && date.getDay() <= daysInMonth(date)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int daysInMonth(Date date) {
        if (date.getMonth() == 1 || date.getMonth() == 3 || date.getMonth() == 5 || date.getMonth() == 7
                || date.getMonth() == 8 || date.getMonth() == 10 || date.getMonth() == 12) {
            return 31;
        }
        if (date.getMonth() == 4 || date.getMonth() == 6 || date.getMonth() == 9 || date.getMonth() == 11){
            return 30;
        }
        if (isLeap(date)) {
            return 29;
        }
        return 28;
    }
}

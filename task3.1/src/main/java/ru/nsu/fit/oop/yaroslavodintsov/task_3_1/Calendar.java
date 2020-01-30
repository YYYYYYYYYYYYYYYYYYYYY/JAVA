package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;

/**
 * Calendar class
 * We use DMYcount here as real date
 *
 */
public abstract class Calendar{

    private DMYcount someDMYcount;  // some DMYcount to be known
    private DMYcount tmp;       // auxiliary DMYcount for calculation
    private DMYcount cur;       // DMYcount which we use in comparisons.


    private int daysInWeek = 7;
    private int monthesInYear = 12;


    /**
     * Set cur DMYcount
     * @throws Exception if newDMYcount is invalid.
     */
    public void setCurrent(DMYcount nCurrent) throws Exception{
        if (cur == null){
            cur = new DMYcount(0, 0, 0);
        }
        if (isValid(nCurrent)) {
            cur.set(nCurrent);
            if (cur.getDayOfWeek() == -1)
                init();
        }
        else {
            throw new Exception("Invalid DMYcount");
        }
    }

    /**
     * Get cur DMYcount
     */
    public DMYcount getCurrent() {
        return cur;
    }

    /**
     * Set someDMYcount DMYcount
     */
    public void setSomeDMYcount(DMYcount nEpoch){
        if (someDMYcount == null){
            someDMYcount = new DMYcount(0, 0, 0);
        }
        someDMYcount.set(nEpoch);
    }



    public void init(){
        tmp = new DMYcount(0, 0, 0);
        tmp.set(someDMYcount);
        moveTmp(cur);
        cur.set(someDMYcount);
    }

    /**
     * Validation of calendar DMYcount
     */
    public abstract boolean isValid(DMYcount DMYcount);

    /**
     * Get number of days in month. Should return positive value for each month described in monthesInYear.
     */
    public abstract int daysInMonth(DMYcount DMYcount);

    /**
     * Prints literally day of the week
     */
    public void printDayOfWeek() {
        switch (cur.getDayOfWeek()){
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            case 7:
                System.out.println("SUN");
                break;
        }
    }

    /**
     * Litteral form for moths too
     */
    public void printMonth() {
        switch (cur.getMonth()){
            case 1:
                System.out.println("JANUARY");
                break;
            case 2:
                System.out.println("FEBRUARY");
                break;
            case 3:
                System.out.println("MARCH");
                break;
            case 4:
                System.out.println("APRIL");
                break;
            case 5:
                System.out.println("MAY");
                break;
            case 6:
                System.out.println("JUNE");
                break;
            case 7:
                System.out.println("JULY");
                break;
            case 8:
                System.out.println("AUGUST");
                break;
            case 9:
                System.out.println("SEPTEMBER");
                break;
            case 10:
                System.out.println("OCTOBER");
                break;
            case 11:
                System.out.println("NOVEMBER");
                break;
            case 12:
                System.out.println("DECEMBER");
                break;
        }
    }

    /**
     * This function is only for DMYcount dates' representation
     * dont use in for difference in date!!!
     *
     */
    public void printDate() {
        printDayOfWeek();
        System.out.println(cur.getDay());
        printMonth();
        System.out.println(cur.getYear());
    }

    public int getDayOfWeek() {
        return cur.getDayOfWeek();
    }


    /**
     * Skipping day. Works with tmp DMYcount.
     */
    private void nextDay() {
        tmp.setDay(tmp.getDay() + 1);
        int nd = tmp.getDayOfWeek();
        nd++;
        if (nd > daysInWeek) nd -= daysInWeek;
        tmp.setDayOfWeek(nd);
        upDMYcountDMYcount();
    }

    /**
     * Returning back for one day. Works with tmp DMYcount.
     */
    private void previousDay() {
        tmp.setDay(tmp.getDay() - 1);
        int nd = tmp.getDayOfWeek();
        nd--;
        if (nd == 0) nd = daysInWeek;
        tmp.setDayOfWeek(nd);
        upDMYcountDMYcount();
    }

    /**
     * Skipping week. Works with tmp DMYcount.
     */
    private void nextWeek() {
        tmp.setDay(tmp.getDay() + daysInWeek);
        upDMYcountDMYcount();
    }

    /**
     * Returning back for a week. Works with tmp DMYcount.
     */
    private  void previousWeek() {
        tmp.setDay(tmp.getDay() - daysInWeek);
        upDMYcountDMYcount();
    }

    private void upDMYcountDMYcount() {
        if (tmp.getDay() < 1) {
            if (tmp.getMonth() == 1) {
                tmp.setYear(tmp.getYear() - 1);
                tmp.setMonth(monthesInYear);
            }
            else {
                tmp.setMonth(tmp.getMonth() - 1);
            }
            tmp.setDay(daysInMonth(tmp) + tmp.getDay());
        }
        else {
            int days = daysInMonth(tmp);
            if (tmp.getDay() > days) {
                tmp.setDay(tmp.getDay() - daysInMonth(tmp));
                if (tmp.getMonth() == monthesInYear) {
                    tmp.setMonth(1);
                    tmp.setYear(tmp.getYear() + 1);
                } else {
                    tmp.setMonth(tmp.getMonth() + 1);
                }
            }
        }
    }

    private void moveTmp(DMYcount dest) {
        while (tmp.compare(dest) < 0) {
            DMYcount d1 = new DMYcount(0, 0, 0);
            d1.set(tmp);
            nextWeek();
            if (tmp.compare(dest) > 0) {
                tmp.set(d1);
                nextDay();
            }
        }
        while (tmp.compare(dest) > 0) {
            DMYcount d1 = new DMYcount(0, 0, 0);
            d1.set(tmp);
            previousWeek();
            if (tmp.compare(dest) < 0) {
                tmp.set(d1);
                previousDay();
            }
        }
    }

    /**
     * Finds DMYcount after daysCount days
     */
    public DMYcount skipDays(int daysCount) {
        tmp.set(cur);
        while (daysCount > 0) {
            if (daysCount >= daysInWeek) {
                nextWeek();
                daysCount -= daysInWeek;
            }
            else{
                nextDay();
                daysCount--;

            }
        }
        return tmp;
    }

    /**
     * Find distance in days between cur and argument.
     */
    public int getDistanceInDays(DMYcount DMYcount) {
        tmp.set(cur);
        int distance = 0;
        while (tmp.compare(DMYcount) < 0) {
            DMYcount d1 = new DMYcount(0,0,0);
            d1.set(tmp);
            nextWeek();
            distance += daysInWeek;
            if (tmp.compare(DMYcount) > 0) {
                tmp.set(d1);
                nextDay();
                distance -= daysInWeek - 1;
            }
        }
        while (tmp.compare(DMYcount) > 0) {
            DMYcount d1 = new DMYcount(0,0,0);
            d1.set(tmp);
            previousWeek();
            distance -= daysInWeek;
            if (tmp.compare(DMYcount) < 0) {
                tmp.set(d1);
                previousDay();
                distance += daysInWeek - 1;
            }
        }
        if (distance <= 0){
            return -distance;
        }
        return distance;
    }

    /**
     * Get distance in days
     * DMYcount here cant be used like a date itself
     * it just a difference between two dates and can be 0 days 0 months 0 years
     */
    public DMYcount getDistanceInDMYcount(DMYcount DMYcount) {
        int distInDays = getDistanceInDays(DMYcount);
        DMYcount zero = new DMYcount(1, 1, 1);
        DMYcount tmp = new DMYcount (0,0,0);
        tmp.set(cur);
        cur.set(zero);
        zero = skipDays(distInDays);
        cur.set(tmp);
        zero.setMonth(zero.getMonth() - 1);
        zero.setDay(zero.getDay() - 1);
        zero.setYear(zero.getYear() - 1);
        return zero;
    }

    /**
     * Get day of week
     */
    public int getWeekDayDMYcount(DMYcount DMYcount) {
        tmp.set(cur);
        moveTmp(DMYcount);
        return tmp.getDayOfWeek();
    }

    /**
     * Skips weeksCount weeks.
     */
    public DMYcount skipWeeks(int weeksCount) {
        tmp.set(cur);
        while (weeksCount > 0) {
            nextWeek();
            weeksCount --;
        }
        return tmp;
    }

    /**
     * Find first day with equals number of day and day of week.
     */
    public DMYcount findClosestDMYcountByDay(DMYcount DMYcount) {
        tmp.set(cur);
        while (true) {
            if (DMYcount.getDay() == tmp.getDay() && tmp.getDayOfWeek() == DMYcount.getDayOfWeek()){
                break;
            }
            nextDay();
        }
        return tmp;
    }
}

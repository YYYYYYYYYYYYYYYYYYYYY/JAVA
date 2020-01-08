package ru.nsu.fit.oop.yaroslavodintsov.task_3_1;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class istest {

    private GregorianCalendar myCalendar = new GregorianCalendar(2020, 1, 1);

    public istest() throws Exception {
    }

    private Date myDate = myCalendar.getCurrent();

    /**
     * What day of the week will be in 1024 days?
     */
    @Test
    public void testcase0() {
        Assert.assertTrue(myCalendar.getDayOfWeek() == 3);
    }

    /**
     * How many years, months and days ago was Victory Day on May 9, 1945?
     */
    @Test
    public void testcase1() {
        Date res = myCalendar.skipDays(1024);
        Assert.assertTrue(res.getDayOfWeek() == 5);
    }

    /**
     * What day of the week were you born?
     */
    @Test
    public void testcase3(){
        Date in = new Date(1945,9,5);
        Date out = myCalendar.getDistanceInDate(in);
        Assert.assertTrue(out.getDay() == 28);
        Assert.assertTrue(out.getMonth() == 3);
        Assert.assertTrue(out.getYear() == 74);
    }

    /**
     * What month will be in 17 weeks?
     */
    @Test
    public void testcase4() throws Exception {
        Date bday = new Date(2001,1,4);
        Assert.assertTrue(myCalendar.getWeekDayDate(bday) == 4);
    }

    /**
     * How many days until the new year?
     */
    @Test
    public void testcase5(){
        Date res = myCalendar.skipWeeks(17);
        Assert.assertTrue(res.getMonth() == 4);
    }

    /**
     * Next Friday, the 13th of the month?
     */
    @Test
    public void testcase6(){
        Date newYear = new Date(myDate.getYear() + 1, 1,1);
        Assert.assertTrue(myCalendar.getDistanceInDays(newYear) == 366);
    }

    @Test
    public void testcase7(){
        Date fri13 = new Date(2019, 9,13);
        fri13.setDayOfWeek(5);
        Date out = myCalendar.findClosestDateByDay(fri13);
        Assert.assertTrue(out.getDay() == 13);
        Assert.assertTrue(out.getMonth() == 3);
        Assert.assertTrue(out.getYear() == 2020);
    }

    @Test
    public void testcase8(){
        Assert.assertTrue(myCalendar.isLeap(myDate) == true);
    }

    @Test
    public void testcase9(){
        Assert.assertTrue(myCalendar.isValid(myDate));
    }

    @Test
    @Ignore
    public void testcase10(){
        myCalendar.printDate();
    }

}

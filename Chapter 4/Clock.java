public class ClockTestDrive {
    public static void main(String[] args) {

        Clock c = new Clock();

        c.setTime("1245");

        String tod = c.getTime();

        System.out.println("Time is: " + tod);
    }
}

public class Clock {

    private String time;

    public void setTime(String t) {
        time = t;
    }
    public String getTime() {
        return time;
    }
}

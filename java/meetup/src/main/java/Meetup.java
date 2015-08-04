import org.joda.time.DateTime;

public class Meetup {

    private final DateTime startOfMonth;

    public Meetup(int month, int year) {
        startOfMonth = new DateTime(year, month, 1, 0, 0);
    }

    public DateTime day(int dayOfWeek, MeetupSchedule schedule) {
        DateTime currentDayOfMonth = getNext(dayOfWeek, startOfMonth);
        switch (schedule) {
            case FIRST:
                break;
            case SECOND:
                currentDayOfMonth = currentDayOfMonth.plusWeeks(1);
                break;
            case THIRD:
                currentDayOfMonth = currentDayOfMonth.plusWeeks(2);
                break;
            case FOURTH:
                currentDayOfMonth = currentDayOfMonth.plusWeeks(3);
                break;
            case TEENTH:
                while (currentDayOfMonth.getDayOfMonth() < 13) {
                    currentDayOfMonth = currentDayOfMonth.plusWeeks(1);
                }
                break;
            case LAST:

                break;
        }
        return currentDayOfMonth;
    }

    private DateTime getNext(int dayOfWeek, DateTime dateTime) {
        DateTime resultDateTime = new DateTime(dateTime);
        while (resultDateTime.getDayOfWeek() != dayOfWeek) {
            resultDateTime = resultDateTime.plusDays(1);
        }
        return resultDateTime;
    }
}
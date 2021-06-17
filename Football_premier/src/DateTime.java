import java.io.Serializable;
import java.util.Objects;

public class DateTime implements Serializable {
    private int day;
    private int month;
    private int year;


    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTime dateTime = (DateTime) o;
        return day == dateTime.day &&
                month == dateTime.month &&
                year == dateTime.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}

package io.github.wotjd243.findbyhint.util.check;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateObject {

    private LocalDate date;
    private LocalTime time;
    private LocalDateTime localDateTime;

    public DateObject() {
                date = LocalDate.now();
        time = LocalTime.now();
        localDateTime = LocalDateTime.now();
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "DateObject [date=" + date + ", time=" + time + ", localDateTime=" + localDateTime + "]";
    }



}

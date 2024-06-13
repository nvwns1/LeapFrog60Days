package org.suman.flightreservation.entities.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class FlightSearchDTO {
    private String from;
    private String to;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date departureDate;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
//
//    public Date getDepartureDate() {
//        return departureDate;
//    }
//
//    public void setDepartureDate(Date departureDate) {
//        this.departureDate = departureDate;
//    }
}

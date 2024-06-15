package org.suman.flightcheckedin.entities.dto;

public class ReservationUpdateRequest {
    private Long id;
    private Boolean checkedIn;
    private int numberOfBag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public int getNumberOfBag() {
        return numberOfBag;
    }

    public void setNumberOfBag(int numberOfBag) {
        this.numberOfBag = numberOfBag;
    }
}

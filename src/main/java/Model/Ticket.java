package Model;

import Common.Constant.Constant;

public class Ticket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;

    public Ticket() {
        this.departDate = Constant.DATA_DEPART_DATE;
        this.departFrom = Constant.DATA_DEPART_FROM;
        this.arriveAt = Constant.DATA_ARRIVE_AT;
        this.seatType = Constant.DATA_SEAT_TYPE;
    }

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }
}

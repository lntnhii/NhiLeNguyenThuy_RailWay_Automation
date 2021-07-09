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

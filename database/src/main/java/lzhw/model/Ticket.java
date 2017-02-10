package lzhw.model;

/**
 * Created by admin on 2017/1/19.
 */
public class Ticket {

    private Long id;
    private Long trainId;
    private Long seatId;
    private Long beginStationId;
    private Long endStationId;
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Long getBeginStationId() {
        return beginStationId;
    }

    public void setBeginStationId(Long beginStationId) {
        this.beginStationId = beginStationId;
    }

    public Long getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(Long endStationId) {
        this.endStationId = endStationId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

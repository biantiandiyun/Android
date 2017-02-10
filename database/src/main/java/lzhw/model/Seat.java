package lzhw.model;

/**
 * Created by admin on 2017/1/19.
 */
public class Seat {

    private Long id;
    private Long trainId;//车次
    private String carriages;//车厢
    private String identifier;//座号
    private String type;//类型

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

    public String getCarriages() {
        return carriages;
    }

    public void setCarriages(String carriages) {
        this.carriages = carriages;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

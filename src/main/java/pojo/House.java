package pojo;

public class House {
    private String shelfDate; //上架日期
    private String title; //房屋标题
    private String community; //小区名称
    private String address; //地址
    private String type; //类型
    private Double size; //面积
    private String direction; //朝向
    private String style; //风格
    private String floor; //楼层
    private String tags; //标签
    private Double totalPrice; //总价
    private Double unitPrice;  //单价
    private Integer id; //唯一标识

    public String getShelfDate() {
        return shelfDate;
    }

    public void setShelfDate(String shelfDate) {
        this.shelfDate = shelfDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "House{" +
                "shelfDate='" + shelfDate + '\'' +
                ", title='" + title + '\'' +
                ", community='" + community + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", direction='" + direction + '\'' +
                ", style='" + style + '\'' +
                ", floor='" + floor + '\'' +
                ", tags='" + tags + '\'' +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                ", id=" + id +
                '}';
    }
}

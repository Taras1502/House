package domain;

import javax.persistence.*;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
@Entity
@Table(name = "Advertisement")
public class Advertisement {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "type")
    private short type;

    @Column(name = "status")
    private short status;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private double price;

    @Column(name = "area")
    private double area;

    @Column(name = "roomsCount")
    private int roomsCount;

    @Column(name = "viewsCount")
    private int viewsCount;

    @Column(name = "description")
    private String description;

    @Column(name = "contacts")
    private String contacts;

    public Advertisement() {}

    public Advertisement(int userId, short type, short status, String address, double price, double area,
                         int roomsCount, int viewsCount, String description, String contacts) {
        this.userId = userId;
        this.type = type;
        this.status = status;
        this.address = address;
        this.price = price;
        this.area = area;
        this.roomsCount = roomsCount;
        this.viewsCount = viewsCount;
        this.description = description;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}

package models;

import java.util.Date;

public class Item {
    private int id;
    private String name;
    private int quantity;
    private Date expirationDate;
    private boolean isSurplus;

    public Item() {}

    public Item(int id, String name, int quantity, Date expirationDate, boolean isSurplus) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.isSurplus = isSurplus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean surplus) {
        isSurplus = surplus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", isSurplus=" + isSurplus +
                '}';
    }
}

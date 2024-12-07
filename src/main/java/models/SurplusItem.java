package models;

import java.sql.Date;

public class SurplusItem extends Item {
    private boolean forDonation;
    private double discountPrice;

    public SurplusItem() {}

    public SurplusItem(int id, String name, int quantity, java.util.Date expirationDate, boolean isSurplus,
                       boolean forDonation, double discountPrice) {
        super(id, name, quantity, expirationDate, isSurplus);
        this.forDonation = forDonation;
        this.discountPrice = discountPrice;
    }

    public SurplusItem(String banana, int i, Date date, double v) {
    }

    public boolean isForDonation() {
        return forDonation;
    }

    public void setForDonation(boolean forDonation) {
        this.forDonation = forDonation;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "SurplusItem{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", quantity=" + getQuantity() +
                ", expirationDate=" + getExpirationDate() +
                ", isSurplus=" + isSurplus() +
                ", forDonation=" + forDonation +
                ", discountPrice=" + discountPrice +
                '}';
    }
}

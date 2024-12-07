package models;

public class Claim {
    private int id;
    private int itemId;
    private int charityId;
    private String status; // e.g., "claimed", "completed"

    public Claim() {}

    public Claim(int id, int itemId, int charityId, String status) {
        this.id = id;
        this.itemId = itemId;
        this.charityId = charityId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", charityId=" + charityId +
                ", status='" + status + '\'' +
                '}';
    }
}

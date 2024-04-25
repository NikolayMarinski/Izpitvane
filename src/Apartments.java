public class Apartments {
    // град, бр.стаи, квадратура, цена, телефон
    private String sity;
    private int roomNum;
    private int space;
    private int price;
    private String phone;

    public Apartments() {
    }

    public Apartments(String city, int roomNum, int space, int price, String phone) {
        this.sity = city;
        this.roomNum = roomNum;
        this.space = space;
        this.price = price;
        this.phone = phone;
    }

    public String getCity() {
        return sity;
    }

    public void setCity(String sity) {
        this.sity = sity;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
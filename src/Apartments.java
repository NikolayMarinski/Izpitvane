public class Apartments implements Comparable<Apartments>{
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

    public int compareTo(Apartments a) {
        if((this.getCity().equals("София") || this.getCity().equals("Варна") || this.getCity().equals("Бургас")) && !a.getCity().equals("София") && !a.getCity().equals("Варна") && !a.getCity().equals("Бургас")){
            return -1;
        }else if((a.getCity().equals("София") || a.getCity().equals("Варна") || a.getCity().equals("Бургас")) && !this.getCity().equals("София") && !this.getCity().equals("Варна") && !this.getCity().equals("Бургас")){
            return 1;
        }else{
            if(this.getRoomNum()==3 && a.getRoomNum()!=3){
                return -1;
            }else if(this.getRoomNum()!=3 && a.getRoomNum()==3){
                return 1;
            }else{
                if(this.getSpace()>100 && a.getSpace()<=100){
                    return -1;
                }else if(this.getSpace()<=100 && a.getSpace()>100){
                    return 1;
                }else{
                    return this.getPrice()-a.getPrice();
                }
            }
        }
    }
}

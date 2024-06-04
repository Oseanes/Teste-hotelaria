package br.com.ada.reservala.domain;

public class Room {



    private Integer roomNumber;
    private String type;
    private Double price;
    private Boolean available;



    public Room(Integer roomNumber, String type, Double price, Boolean available) {
        this.setRoomNumber(roomNumber);
        this.setType(type);
        this.setPrice(price);
        this.setAvailable(available);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        if(roomNumber <= 0){
            throw new IllegalArgumentException("roomNumber nao deve ser negativo");
        }
        this.roomNumber = roomNumber;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == null ){
            throw new IllegalArgumentException("type nao deve ser null");
        }

        this.type = type;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        if(price <= 0){
            throw new IllegalArgumentException("price nao deve ser negativo");
        }
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        if(available == null){
            throw new IllegalArgumentException("available nao deve ser null");
        }
        this.available = available;
    }
}

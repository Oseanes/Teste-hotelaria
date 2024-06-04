package br.com.ada.reservala.domain;


import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;

public class Room {


    @PositiveOrZero(message = "O número do quarto deve ser positivo")
    private Integer roomNumber;
    @Null
    private String type;
    @PositiveOrZero(message = "O preço deve ser positivo")
    private Double price;
    private Boolean available;



    public Room(Integer roomNumber, String type, Double price, Boolean available) {
        this.setRoomNumber(roomNumber);
        this.type = type;
        this.setPrice(price);
        this.available = available;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }



    public void setRoomNumber(Integer roomNumber) {
//        if(roomNumber <= 0){
//            throw new IllegalArgumentException("roomNumber deve ser um número positivo");
//        }
        this.roomNumber = roomNumber;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
//        if(price <= 0){
//            throw new IllegalArgumentException("price deve ser um número positivo");
//        }
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

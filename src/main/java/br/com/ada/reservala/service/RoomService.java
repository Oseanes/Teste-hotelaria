package br.com.ada.reservala.service;

import br.com.ada.reservala.domain.Room;
import br.com.ada.reservala.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Room room){
        return roomRepository.createRoom(room);
    }

    public List<Room> readRoom(){
        return roomRepository.readRoom();
    }

    public Room updateRoom(Room room){
        return roomRepository.updateRoom(room);
    }

    public void deleteRoom(Integer roomNumber){
        roomRepository.deleteRoom(roomNumber);
    }

//    //Deve calcular o percentual de quartos ocupados
//    public Double getOcupation(){
//        return 100d;
//    }
//
//    //Deve calcular a receita obtida
//    public Double getRevenue(){
//        return 100d;
//    }

    public Double getOcupation(){
        List<Room> rooms = roomRepository.readRoom();
        long totalRooms = rooms.size();
        long occupiedRooms = rooms.stream().filter(Room::getAvailable).count();
        return (double) (occupiedRooms * 100) / totalRooms;
    }

    public Double getRevenue(){
        List<Room> rooms = roomRepository.readRoom();
        return rooms.stream()
                .filter(Room::getAvailable)
                .mapToDouble(Room::getPrice)
                .sum();
    }
}

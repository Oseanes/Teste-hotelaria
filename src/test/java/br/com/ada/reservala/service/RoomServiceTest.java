package br.com.ada.reservala.service;

import br.com.ada.reservala.controller.RoomController;
import br.com.ada.reservala.domain.Room;
import br.com.ada.reservala.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;


    @Test
    void deveriaCriarRoomNaoNull() {
        Room room = new Room(1, "Deluxe", 450.0, true);
        when(roomRepository.createRoom(any(Room.class))).thenReturn(room);

        Room createdRoom = roomService.createRoom(room);

        verify(roomRepository).createRoom(eq(room));

        assertNotNull(createdRoom);
    }


    @Test
    void deveriaNaoCriarRoomComRoomNumberNegativo() {
        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->  roomService.createRoom(new Room(-12, "Site", 850.78, false)),
                "Esperava-se que createRoom() fosse lançado, mas isso não aconteceu"
        );
        assertTrue(thrown.getMessage().contains("roomNumber nao deve ser negativo"));
    }

    @Test
    void deveriaNaoCriarRoomComPriceNegativo() {

        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->  roomService.createRoom(new Room(4, "Deluxe", -450.0, true)),
                "Esperava-se que createRoom() fosse lançado, mas isso não aconteceu"
        );
        assertTrue(thrown.getMessage().contains("price nao deve ser negativo"));
    }

    @Test
    void deveriaCriarRoomComPriceValoresDouble() {
        Room room = new Room(4, "Deluxe", 450.0, true);
        when(roomRepository.createRoom(any(Room.class))).thenReturn(room);

        Room createdRoom = roomService.createRoom(room);

        verify(roomRepository).createRoom(eq(room));
        assertSame(createdRoom.getPrice().getClass(), Double.class);
    }

    @Test
    void deveriaNaoCriarRoomComAvailableIgualNull() {

        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->  roomService.createRoom(new Room(4, "Deluxe", 450.0, null)),
                "Esperava-se que createRoom() fosse lançado, mas isso não aconteceu"
        );
        assertTrue(thrown.getMessage().contains("available nao deve ser null"));
    }

    @Test
    void deveriaNaoCriarRoomComTypeIgualNull() {

        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->  roomService.createRoom(new Room(4, null, 450.0, false)),
                "Esperava-se que createRoom() fosse lançado, mas isso não aconteceu"
        );
        assertTrue(thrown.getMessage().contains("type nao deve ser null"));
    }

//    @Test
//    void deveriaNaoCriarRoomComTypeIgualNumero() {
//        Room room = new Room(4, "132", 450.0, false);
//        when(roomRepository.createRoom(any(Room.class))).thenReturn(room);
//
//        Room createdRoom = roomService.createRoom(room);
//
//        verify(roomRepository).createRoom(eq(room));
//        assertTrue(createdRoom.getType().matches("\\D+"));
//    }


}

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

//    @InjectMocks
//    private RoomController roomController;


    @InjectMocks
    private RoomService roomService;

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private RoomRepository roomRepository;


    @Test
    void deveriaCiarRoomValido() {
        Room room = new Room(-12, "Site", 850.78, false);
        when(roomService.createRoom(room)).thenReturn(room);

        assertEquals(room, roomService.createRoom(room));
    }


    @Test
    void deveriaSubirIllegalArgumentExceptionRoomNumbreNegativo(){

        IllegalArgumentException thrown =  Assertions.assertThrows(
                IllegalArgumentException.class,
                ()->  roomService.createRoom(new Room(-12, "Site", 850.78, false)),
                "Esperava-se que createRoom() fosse lançado, mas isso não aconteceu"
        );
        System.out.println(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("roomNumber deve ser um número positivo"));


    }

}

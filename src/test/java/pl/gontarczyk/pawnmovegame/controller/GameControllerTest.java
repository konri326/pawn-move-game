package pl.gontarczyk.pawnmovegame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.gontarczyk.pawnmovegame.model.board.Board;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovementDto;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Board board;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setting() {
        board.getPawn().getCurrentPosition().setX(0);
        board.getPawn().getCurrentPosition().setY(0);
    }

    @Test
    void testPawnPosition_shouldReturnPositionPawnOnBoard() throws Exception {
        mockMvc.perform(get("/api/v1/move"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPosition.x", equalTo(0)))
                .andExpect(jsonPath("$.currentPosition.y", equalTo(0)));
    }

    @Test
    void testMovePawn_shouldMovePawnOnBoard() throws Exception {
        mockMvc.perform(put("/api/v1/move")
                        .content(objectMapper.writeValueAsString(PawnMovementDto.builder()
                                .direction("UP")
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentPosition.x", equalTo(0)))
                .andExpect(jsonPath("$.currentPosition.y", equalTo(1)));
    }

    @Test
    void testMovePawn_shouldThrowMethodArgumentNotValidException() throws Exception {
        mockMvc.perform(put("/api/v1/move")
                        .content(objectMapper.writeValueAsString(PawnMovementDto.builder()
                                .direction("Konrad")
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", equalTo("Invalid validation")));
    }

    @Test
    void testMovePawn_shouldThrowBoardFrameExceptionException() throws Exception {
        board.setMaxCol(0);
        board.setMaxRow(0);

        mockMvc.perform(put("/api/v1/move")
                        .content(objectMapper.writeValueAsString(PawnMovementDto.builder()
                                .direction("UP")
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", equalTo("You can't go outside the board area!")));
    }
}
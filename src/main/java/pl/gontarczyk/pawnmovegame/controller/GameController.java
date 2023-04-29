package pl.gontarczyk.pawnmovegame.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gontarczyk.pawnmovegame.mapper.PawnMapper;
import pl.gontarczyk.pawnmovegame.mapper.PawnMovementMapper;
import pl.gontarczyk.pawnmovegame.model.pawn.PawnDto;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovement;
import pl.gontarczyk.pawnmovegame.model.pawn.move.PawnMovementDto;
import pl.gontarczyk.pawnmovegame.service.GameService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final PawnMapper pawnMapper;
    private final PawnMovementMapper pawnMovementMapper;

    @PutMapping("/move")
    public ResponseEntity<PawnDto> movePawn(@RequestBody @Valid PawnMovementDto pawnMovementDto) {
        PawnMovement pawnMovement = pawnMovementMapper.mapFromDto(pawnMovementDto);
        PawnDto pawnDto = pawnMapper.mapToDto(gameService.movePawn(pawnMovement));
        return new ResponseEntity<>(pawnDto, HttpStatus.OK);
    }

    @GetMapping("/move")
    public ResponseEntity<PawnDto> pawnPosition() {
        PawnDto pawnDto = pawnMapper.mapToDto(gameService.getPawnPosition());
        return new ResponseEntity<>(pawnDto, HttpStatus.OK);
    }
}
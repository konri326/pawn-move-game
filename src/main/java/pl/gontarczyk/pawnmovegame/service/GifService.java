package pl.gontarczyk.pawnmovegame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gontarczyk.pawnmovegame.common.GifSequenceWriter;
import pl.gontarczyk.pawnmovegame.model.board.Board;
import pl.gontarczyk.pawnmovegame.model.position.Position;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class GifService {

    private final Board board;

    public void createGif(File file) throws IOException {
        BufferedImage first = ImageIO.read(getInputStream(drawBoard(board.getPawn().getCurrentPosition())));
        ImageOutputStream output = new FileImageOutputStream(file);

        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 200, true);

        for (Position position : board.getPawn().getPositions()) {
            BufferedImage next = ImageIO.read(getInputStream(drawBoard(position)));
            writer.writeToSequence(next);
        }

        board.getPawn().setPositions(new ArrayList<>());
        board.getPawn().addPositionToList(board.getPawn().getCurrentPosition());

        writer.close();
        output.close();
    }

    private InputStream getInputStream(BufferedImage bufferedImage) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    private BufferedImage drawBoard(Position position) {
        int fieldSize = 50;
        int width = (board.getMaxRow() + 1) * fieldSize;
        int height = (board.getMaxCol() + 1) * fieldSize;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        for (int i = 1; i <= board.getMaxRow(); i++) {
            g2d.setColor(Color.BLACK);
            g2d.drawLine(0, fieldSize * i, width, fieldSize * i);
            g2d.drawLine(fieldSize * i, 0, fieldSize * i, height);
        }

        g2d.setColor(Color.GREEN);
        g2d.fillOval(
                fieldSize * position.getX(),
                fieldSize * position.getY(),
                fieldSize,
                fieldSize
        );

        g2d.dispose();
        return bufferedImage;
    }
}
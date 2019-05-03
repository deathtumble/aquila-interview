package com.murraytait.aquila.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication implements CommandLineRunner {
  
  @Autowired
  private ChessPieceFactory chessPieceFactory;
  
  @Autowired
  private MoveCounter moveCounter;

  public static void main(String[] args) {
    SpringApplication.run(InterviewApplication.class, args);
  }

  @Override
  public void run(String... args) {

    if (args.length < 2) {
      System.err.println("Usage: <chess-piece> <start-position>");
    } else {
      String pieceName = args[0];
      String startPosition = args[1];

      try {
        ChessPiece chessPiece = chessPieceFactory.createChessPiece(pieceName);

        System.out.println(moveCounter.getCount(chessPiece, Integer.parseInt(startPosition), 10));
      } catch (ChessException exception) {

        System.err.println(exception.getMessage());
      } catch (NumberFormatException exception) {

        System.err.println("Unknown position: " + args[1]);
      }
    }
  }
}

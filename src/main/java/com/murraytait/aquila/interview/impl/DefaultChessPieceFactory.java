package com.murraytait.aquila.interview.impl;

import org.springframework.stereotype.Component;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.ChessPiece;
import com.murraytait.aquila.interview.ChessPieceFactory;
import com.murraytait.aquila.interview.piece.Bishop;
import com.murraytait.aquila.interview.piece.King;
import com.murraytait.aquila.interview.piece.Knight;
import com.murraytait.aquila.interview.piece.Pawn;
import com.murraytait.aquila.interview.piece.Queen;
import com.murraytait.aquila.interview.piece.Rook;

@Component
public class DefaultChessPieceFactory implements ChessPieceFactory {

  @Override
  public ChessPiece createChessPiece(String pieceName) {
    switch (pieceName) {
    case "rook":
      return new Rook();
    case "pawn":
      return new Pawn();
    case "queen":
      return new Queen();
    case "king":
      return new King();
    case "bishop":
      return new Bishop();
    case "knight":
      return new Knight();
    default:
      throw new ChessException("Chess piece not recognised");
    }
  }

}

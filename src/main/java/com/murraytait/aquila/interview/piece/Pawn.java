package com.murraytait.aquila.interview.piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.ChessPiece;

public class Pawn implements ChessPiece {

  @Override
  public Set<Integer> getPossiblePositions(Integer startPosition, boolean initial) {
    Set<Integer> possiblePositions;

    switch (startPosition) {
    case 1:
    case 2:
    case 3:
      throw new ChessException("Impossible state found.  Pawn on top row should become a Queen");
    case 4:
      possiblePositions = new HashSet<Integer>(Arrays.asList(4, 1));
      break;
    case 5:
      possiblePositions = new HashSet<Integer>(Arrays.asList(5, 2));
      break;
    case 6:
      possiblePositions = new HashSet<Integer>(Arrays.asList(6, 3));
      break;
    case 7:
      possiblePositions = new HashSet<Integer>(Arrays.asList(7, 4));
      if (initial) {
        possiblePositions.add(1);
      }
      break;
    case 8:
      possiblePositions = new HashSet<Integer>(Arrays.asList(8, 5));
      if (initial) {
        possiblePositions.add(2);
      }
       break;
    case 9:
      possiblePositions = new HashSet<Integer>(Arrays.asList(9, 6));
      if (initial) {
        possiblePositions.add(3);
      }
      break;
    case 0:
      possiblePositions = new HashSet<Integer>(Arrays.asList(0, 8));
      if (initial) {
        possiblePositions.add(5);
      }
      break;
    default:
      throw new ChessException("Unknown position: " + startPosition);
    }
    return possiblePositions;
  }

}

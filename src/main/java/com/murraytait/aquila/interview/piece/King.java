package com.murraytait.aquila.interview.piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.ChessPiece;

public class King implements ChessPiece {

  @Override
  public Set<Integer> getPossiblePositions(Integer startPosition, boolean initial) {
    Set<Integer> possiblePositions;

    switch (startPosition) {
    case 0:
      possiblePositions = new HashSet<Integer>(Arrays.asList(0, 7, 8, 9));
      break;
    case 1:
      possiblePositions = new HashSet<Integer>(Arrays.asList(1, 2, 5, 4));
      break;
    case 2:
      possiblePositions = new HashSet<Integer>(Arrays.asList(2, 1, 3, 4, 5, 6));
      break;
    case 3:
      possiblePositions = new HashSet<Integer>(Arrays.asList(3, 2, 5, 6));
      break;
    case 4:
      possiblePositions = new HashSet<Integer>(Arrays.asList(4, 1, 2, 5, 8, 7));
      break;
    case 5:
      possiblePositions = new HashSet<Integer>(Arrays.asList(5, 1, 2, 3, 4, 6, 7, 8, 9));
      break;
    case 6:
      possiblePositions = new HashSet<Integer>(Arrays.asList(6, 3, 2, 5, 8, 9));
      break;
    case 7:
      possiblePositions = new HashSet<Integer>(Arrays.asList(7, 4, 5, 8, 0));
      break;
    case 8:
      possiblePositions = new HashSet<Integer>(Arrays.asList(8, 5, 4, 6, 7, 9, 0));
      break;
    case 9:
      possiblePositions = new HashSet<Integer>(Arrays.asList(9, 6, 5, 8, 0));
      break;
    default:
      throw new ChessException("Unknown position: " + startPosition);
    }
    return possiblePositions;
  }

}

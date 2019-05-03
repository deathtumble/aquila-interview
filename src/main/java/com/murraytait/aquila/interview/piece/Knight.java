package com.murraytait.aquila.interview.piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.ChessPiece;

public class Knight implements ChessPiece {

  @Override
  public Set<Integer> getPossiblePositions(Integer startPosition, boolean initial) {
    Set<Integer> possiblePositions;

    switch (startPosition) {
    case 0:
      possiblePositions = new HashSet<Integer>(Arrays.asList(0, 4, 6));
      break;
    case 1:
      possiblePositions = new HashSet<Integer>(Arrays.asList(1, 6, 8));
      break;
    case 2:
      possiblePositions = new HashSet<Integer>(Arrays.asList(2, 7, 9));
      break;
    case 3:
      possiblePositions = new HashSet<Integer>(Arrays.asList(3, 4, 8));
      break;
    case 4:
      possiblePositions = new HashSet<Integer>(Arrays.asList(4, 3, 9));
      break;
    case 5:
      possiblePositions = new HashSet<Integer>(Arrays.asList(5));
      break;
    case 6:
      possiblePositions = new HashSet<Integer>(Arrays.asList(6, 1, 7));
      break;
    case 7:
      possiblePositions = new HashSet<Integer>(Arrays.asList(7, 2, 6));
      break;
    case 8:
      possiblePositions = new HashSet<Integer>(Arrays.asList(8, 1, 3));
      break;
    case 9:
      possiblePositions = new HashSet<Integer>(Arrays.asList(9, 2, 4));
      break;
    default:
      throw new ChessException("Unknown position: " + startPosition);
    }
    return possiblePositions;
  }

}

package com.murraytait.aquila.interview.impl;

import java.util.Set;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.springframework.stereotype.Component;

import com.murraytait.aquila.interview.ChessPiece;
import com.murraytait.aquila.interview.MoveCounter;
import com.murraytait.aquila.interview.piece.Pawn;
import com.murraytait.aquila.interview.piece.Queen;

@Component
public class DefaultMoveCounter implements MoveCounter {

  @SuppressWarnings("rawtypes")
  private static final MultiKeyMap cache = new MultiKeyMap<>();

  public Integer cacheHits = 0;

  @Override
  public int getCount(ChessPiece chessPiece, int startPosition, int depth) {
    return getCount(chessPiece, startPosition, depth, true);
  }

  @SuppressWarnings("unchecked")
  private int getCount(ChessPiece chessPiece, int currentPosition, int depthRemaining, boolean initial) {
    if (chessPiece.getClass().equals(Pawn.class) && (currentPosition > 0) && (currentPosition < 4)) {
      chessPiece = new Queen();
    }

    if (cache.containsKey(chessPiece, currentPosition, depthRemaining)) {

      return (Integer) cache.get(chessPiece, currentPosition, depthRemaining);
    } else {
      int count = getUncachedCount(chessPiece, currentPosition, depthRemaining, initial);

      cache.put(chessPiece, currentPosition, depthRemaining, count);

      return count;
    }
  }

  private int getUncachedCount(ChessPiece chessPiece, int currentPosition, int depthRemaining, boolean initial) {
    Set<Integer> nextPositions = chessPiece.getPossiblePositions(currentPosition, initial);
    int count = 0;

    if (depthRemaining == 1) {
      count = nextPositions.size();
    } else {
      for (Integer nextPosition : nextPositions) {
        int addition = getCount(chessPiece, nextPosition, depthRemaining - 1, false);
        count = count + addition;
      }
    }
    return count;
  }
}

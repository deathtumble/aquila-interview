package com.murraytait.aquila.interview;

import java.util.Set;

public interface ChessPiece {
  Set<Integer> getPossiblePositions(Integer startPosition, boolean initial);
}

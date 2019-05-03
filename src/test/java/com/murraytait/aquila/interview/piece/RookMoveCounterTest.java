package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class RookMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldThrowException_WhenRookStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new Rook(), 10, 10);
  }

  @Test
  public void shouldCountMoves_WhenRookDepth2StartsSide() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 26;

    // When

    // Then
    assertThat(moveCounter.getCount(new Rook(), 1, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 3, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 7, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 9, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 4, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 6, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenRookDepth2StartsMiddleColumn() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 32;

    // When

    // Then
    assertThat(moveCounter.getCount(new Rook(), 2, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 5, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Rook(), 8, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenRookDepth2StartsZero() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 22;

    // When

    // Then
    assertThat(moveCounter.getCount(new Rook(), 0, finalDepth)).isEqualTo(expectedCount);
  }
}

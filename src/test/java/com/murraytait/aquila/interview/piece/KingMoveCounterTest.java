package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class KingMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldThrowException_WhenKingStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new King(), 10, 10);
  }

  @Test
  public void shouldCountMoves_WhenKingDepth2StartTopCorner() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 25;

    // When

    // Then
    assertThat(moveCounter.getCount(new King(), 1, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new King(), 3, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenKingDepth2Start5() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 52;

    // When

    // Then
    assertThat(moveCounter.getCount(new King(), 5, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenKingDepth2StartMiddleSide() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 37;

    // When

    // Then
    assertThat(moveCounter.getCount(new King(), 6, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new King(), 4, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenKingDepth2Start2() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 35;

    // When

    // Then
    assertThat(moveCounter.getCount(new King(), 2, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenKingDepth2Start0() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 21;

    // When

    // Then
    assertThat(moveCounter.getCount(new King(), 0, finalDepth)).isEqualTo(expectedCount);
  }
}

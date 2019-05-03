package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class BishopMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldThrowException_WhenBishopStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new Bishop(), 10, 10);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2StartsTopCorner() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 12;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 1, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Bishop(), 3, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2StartsBottomCorner() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 15;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 7, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Bishop(), 9, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2StartsMiddleSides() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 9;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 4, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Bishop(), 6, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2Starts8() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 9;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 8, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2Starts2() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 9;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 2, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenBishopDepth2Starts5() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 19;

    // When

    // Then
    assertThat(moveCounter.getCount(new Bishop(), 5, finalDepth)).isEqualTo(expectedCount);
  }
}

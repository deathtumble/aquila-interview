package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class PawnMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldThrowException_WhenPawnStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new Pawn(), 10, 10);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth1StartsMiddleRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 1;
    int expectedCount = 2;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 4, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Pawn(), 5, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Pawn(), 6, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth1StartsZeroOrBottomRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 1;
    int expectedCount = 3;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 0, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Pawn(), 7, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Pawn(), 8, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Pawn(), 9, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMove_WhenPawnDepth1StartAtTopCorners() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 1;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 1, finalDepth)).isEqualTo(7);
    assertThat(moveCounter.getCount(new Pawn(), 3, finalDepth)).isEqualTo(7);
  }

  @Test
  public void shouldCountMove_WhenPawnDepth1StartAt2() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 1;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 2, finalDepth)).isEqualTo(8);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth2StartZeroOrBottomRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 0, finalDepth)).isEqualTo(6);
    assertThat(moveCounter.getCount(new Pawn(), 7, finalDepth)).isEqualTo(11);
    assertThat(moveCounter.getCount(new Pawn(), 8, finalDepth)).isEqualTo(12);
    assertThat(moveCounter.getCount(new Pawn(), 9, finalDepth)).isEqualTo(11);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth2StartMiddleRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 4, finalDepth)).isEqualTo(9);
    assertThat(moveCounter.getCount(new Pawn(), 5, finalDepth)).isEqualTo(10);
    assertThat(moveCounter.getCount(new Pawn(), 6, finalDepth)).isEqualTo(9);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth3StartZero() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 3;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 0, finalDepth)).isEqualTo(18);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth3StartBottomRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 3;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 7, finalDepth)).isEqualTo(68);
    assertThat(moveCounter.getCount(new Pawn(), 8, finalDepth)).isEqualTo(74);
    assertThat(moveCounter.getCount(new Pawn(), 9, finalDepth)).isEqualTo(68);
  }

  @Test
  public void shouldCountMoves_WhenPawnDepth3StartMiddleRow() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 3;

    // When

    // Then
    assertThat(moveCounter.getCount(new Pawn(), 4, finalDepth)).isEqualTo(64);
    assertThat(moveCounter.getCount(new Pawn(), 5, finalDepth)).isEqualTo(70);
    assertThat(moveCounter.getCount(new Pawn(), 6, finalDepth)).isEqualTo(64);
  }
}
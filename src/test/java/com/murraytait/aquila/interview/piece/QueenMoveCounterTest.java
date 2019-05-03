package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class QueenMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldThrowException_WhenQueenStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new Queen(), 10, 10);
  }

  @Test
  public void shouldCountMoves_WhenQueenDepth2Start5() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 76;

    // When

    // Then
    assertThat(moveCounter.getCount(new Queen(), 5, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenQueenDepth2StartBottomCorner() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 61;

    // When

    // Then
    assertThat(moveCounter.getCount(new Queen(), 7, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Queen(), 9, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenQueenDepth2StartTopCorner() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 55;

    // When

    // Then
    assertThat(moveCounter.getCount(new Queen(), 1, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Queen(), 3, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenQueenDepth2Start2() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 60;

    // When

    // Then
    assertThat(moveCounter.getCount(new Queen(), 2, finalDepth)).isEqualTo(expectedCount);
  }
}

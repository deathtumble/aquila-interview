package com.murraytait.aquila.interview.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.impl.DefaultMoveCounter;

public class KnightMoveCounterTest {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void shouldCountMoves_WhenKnightDepth2Start5() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 2;
    int expectedCount = 1;

    // When

    // Then
    assertThat(moveCounter.getCount(new Knight(), 5, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldCountMoves_WhenKnightDepth3StartNot5() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();
    int finalDepth = 3;
    int expectedCount = 27;

    // When

    // Then
    assertThat(moveCounter.getCount(new Knight(), 1, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 2, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 3, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 4, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 6, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 7, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 8, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 9, finalDepth)).isEqualTo(expectedCount);
    assertThat(moveCounter.getCount(new Knight(), 0, finalDepth)).isEqualTo(expectedCount);
  }

  @Test
  public void shouldThrowException_WhenKnightStartsOffKeyBoard() {
    // Given
    DefaultMoveCounter moveCounter = new DefaultMoveCounter();

    // When

    // Then
    exceptionRule.expect(RuntimeException.class);

    moveCounter.getCount(new Knight(), 10, 10);
  }
}

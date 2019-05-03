package com.murraytait.aquila.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.murraytait.aquila.interview.piece.Queen;

@RunWith(MockitoJUnitRunner.class)
public class InterviewApplicationTests {
  @Mock
  MoveCounter moveCounter;

  @Mock
  ChessPieceFactory chessPieceFactory;

  @InjectMocks
  InterviewApplication interviewApplication;

  private ChessPiece chessPiece;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUp() {
    chessPiece = new Queen();

    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void contextLoads() {
  }

  @Test
  public void noArguments() {
    // Given

    // When
    interviewApplication.run();

    // Then

    assertThat(errContent.toString()).isEqualTo("Usage: <chess-piece> <start-position>\n");
  }

  @Test 
  public void shouldPrintResultFromMoveCounter() {
    // Given
    when(chessPieceFactory.createChessPiece("queen")).thenReturn(chessPiece);
    when(moveCounter.getCount(chessPiece, 5, 10)).thenReturn(12345);    
    // When
    interviewApplication.run("queen", "5");
    
    // Then
    
    assertThat(outContent.toString()).isEqualTo("12345\n");
  }

  @Test 
  public void shouldPrintErrorResultWhenUnknownStart() {
    // Given
    when(chessPieceFactory.createChessPiece("queen")).thenReturn(chessPiece);
    // When
    interviewApplication.run("queen", "A");
    
    // Then
    
    assertThat(errContent.toString()).isEqualTo("Unknown position: A\n");
  }

  @Test 
  public void shouldPrintErrorResultWhenMoveCounterException() {
    // Given
    when(chessPieceFactory.createChessPiece("queen")).thenReturn(chessPiece);
    when(moveCounter.getCount(chessPiece, 5, 10)).thenThrow(new ChessException("expected message"));    

    // When
    interviewApplication.run("queen", "5");
    
    // Then
    
    assertThat(errContent.toString()).isEqualTo("expected message\n");
  }
}

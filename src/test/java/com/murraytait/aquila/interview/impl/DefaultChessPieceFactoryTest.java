package com.murraytait.aquila.interview.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.murraytait.aquila.interview.ChessException;
import com.murraytait.aquila.interview.ChessPiece;
import com.murraytait.aquila.interview.piece.Bishop;
import com.murraytait.aquila.interview.piece.King;
import com.murraytait.aquila.interview.piece.Knight;
import com.murraytait.aquila.interview.piece.Pawn;
import com.murraytait.aquila.interview.piece.Queen;
import com.murraytait.aquila.interview.piece.Rook;

public class DefaultChessPieceFactoryTest {
  
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  private DefaultChessPieceFactory chessPieceFactory;

  @Before
  public void setUp() {
    chessPieceFactory = new DefaultChessPieceFactory();
  }
  
  @Test
  public void shouldCreateAQueen() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("queen");
    
    // Then
    assertThat(chessPiece).isInstanceOf(Queen.class);
  }

  @Test
  public void shouldCreateAKing() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("king");
    
    // Then
    assertThat(chessPiece).isInstanceOf(King.class);
  }

  @Test
  public void shouldCreateABishop() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("bishop");
    
    // Then
    assertThat(chessPiece).isInstanceOf(Bishop.class);
  }

  @Test
  public void shouldCreateAKnight() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("knight");
    
    // Then
    assertThat(chessPiece).isInstanceOf(Knight.class);
  }

  @Test
  public void shouldCreateARook() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("rook");
    
    // Then
    assertThat(chessPiece).isInstanceOf(Rook.class);
  }

  @Test
  public void shouldCreateAPawn() {
    // Given
    
    // When
    ChessPiece chessPiece = chessPieceFactory.createChessPiece("pawn");
    
    // Then
    assertThat(chessPiece).isInstanceOf(Pawn.class);
  }
  
  @Test
  public void shouldThrowChessExceptionOtherwise() {
    // Given
    exceptionRule.expect(ChessException.class);
    exceptionRule.expectMessage("Chess piece not recognised");
    
    //When
    chessPieceFactory.createChessPiece("unknown");

  }
  
}

package com.example.myapplication.hangman;

import android.app.Activity;

import com.example.myapplication.databaseconnector.GameEnum;
import com.example.myapplication.domain.GameManager;
import com.example.myapplication.domain.GameStatus;
import com.example.myapplication.databaseconnector.GameStatusDaoImpl;

/** The game manager for this Hangman game. */
class HangmanGameManager extends GameManager {

  /** The singleton HangmanGameManager. */
  private static HangmanGameManager hangmanGameManager;

  /** Constructs a HangmanGameManager. */
  private HangmanGameManager(Activity activity) {
    super(activity);
  }

  /**
   * Getter for this HangmanGameManager instance.
   *
   * @return HangmanGameManager the instance of this HangmanGameManager.
   */
  static HangmanGameManager getInstance(Activity activity) {
    if (hangmanGameManager == null) {
      hangmanGameManager = new HangmanGameManager(activity);
    }
    return hangmanGameManager;
  }

  /**
   * Returns the HangmanGameManager instance that belongs to a user with specified username.
   *
   * @param username the username of the user playing this game.
   * @return HangmanGameStatFacade the HangmanGameStatFacade instance of this user.
   */
  protected HangmanGameStatFacade getGameStatus(String username) {
    HangmanGameStatFacade hangmanGameStat =
            (HangmanGameStatFacade)
                    GameStatusDaoImpl.getInstance(getActivity()).getGameStatus(username, GameEnum.HANGMAN);

    if (hangmanGameStat == null) {
      hangmanGameStat = new HangmanGameStatFacade(username);
    }

    return hangmanGameStat;
  }
}

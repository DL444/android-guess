package net.dl444.randomguessstd;

import android.graphics.Color;

interface IGameState {
    int getHintTextId();
    int getHintTextColorId();

    boolean isInputReadonly();
    boolean shouldClearInput();

    boolean isArrowShown();
    int getHighArrowColorId();
    int getLowArrowColorId();

    boolean isCheckBtnEnabled();
    boolean isCheckBtnShown();

    boolean isEmojiShown();
    int getEmojiDrawableId();
    int getEmojiColorId();

    IGameState enterGuess(String guess);
    IGameState check();
    IGameState dismiss();
}

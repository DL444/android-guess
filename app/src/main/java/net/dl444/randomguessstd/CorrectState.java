package net.dl444.randomguessstd;

class CorrectState implements IGameState {
    @Override
    public int getHintTextId() {
        return R.string.hint_correct;
    }

    @Override
    public int getHintTextColorId() {
        return R.color.colorPrimary;
    }

    @Override
    public boolean isInputReadonly() {
        return true;
    }

    @Override
    public boolean shouldClearInput() {
        return false;
    }

    @Override
    public boolean isArrowShown() {
        return false;
    }

    @Override
    public int getHighArrowColorId() {
        return R.color.baseMid;
    }

    @Override
    public int getLowArrowColorId() {
        return R.color.baseMid;
    }

    @Override
    public boolean isCheckBtnEnabled() {
        return true;
    }

    @Override
    public boolean isCheckBtnShown() {
        return false;
    }

    @Override
    public boolean isEmojiShown() {
        return true;
    }

    @Override
    public int getEmojiDrawableId() {
        return R.drawable.ic_smile;
    }

    @Override
    public int getEmojiColorId() {
        return R.color.colorPrimary;
    }

    @Override
    public IGameState enterGuess(String guess) {
        return this;
    }

    @Override
    public IGameState check() {
        return this;
    }

    @Override
    public IGameState dismiss() {
        return new ReadyState(Common.getRandomNumber(), true);
    }
}

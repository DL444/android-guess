package net.dl444.randomguessstd;

class HighState implements IGameState {
    public HighState (ReadyState rollbackState) {
        this.rollbackState = rollbackState;
    }

    @Override
    public int getHintTextId() {
        return R.string.hint_high;
    }

    @Override
    public int getHintTextColorId() {
        return R.color.baseMid;
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
        return true;
    }

    @Override
    public int getHighArrowColorId() {
        return R.color.colorPrimary;
    }

    @Override
    public int getLowArrowColorId() {
        return R.color.baseMid;
    }

    @Override
    public boolean isCheckBtnEnabled() {
        return false;
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
        return R.drawable.ic_frown;
    }

    @Override
    public int getEmojiColorId() {
        return R.color.baseMid;
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
        return rollbackState;
    }

    private ReadyState rollbackState;
}

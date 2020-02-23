package net.dl444.randomguessstd;

final class ReadyState implements IGameState {

    public ReadyState(int expect) {
        this.expect = expect;
    }
    public ReadyState(int expect, boolean clearInput) {
        this(expect);
        this.clearInput = clearInput;
    }

    @Override
    public int getHintTextId() {
        return R.string.hint_init;
    }

    @Override
    public int getHintTextColorId() {
        return R.color.baseMid;
    }

    @Override
    public boolean isInputReadonly() {
        return false;
    }

    @Override
    public boolean shouldClearInput() {
        return clearInput;
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
        return isInputValid;
    }

    @Override
    public boolean isCheckBtnShown() {
        return true;
    }

    @Override
    public boolean isEmojiShown() {
        return false;
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
        this.setGuess(guess);
        return this;
    }

    @Override
    public IGameState check() {
        try {
            int val = Integer.parseInt(guess);
            if (val > expect) {
                return new HighState(this);
            } else if (val < expect) {
                return new LowState(this);
            } else {
                return new CorrectState();
            }
        } catch (NumberFormatException ex) {
            return this;
        }
    }

    @Override
    public IGameState dismiss() {
        return this;
    }

    private void setGuess(String guess) {
        clearInput = false;
        this.guess = guess;
        try {
            Integer.parseInt(guess);
            isInputValid = true;
        } catch (NumberFormatException ex) {
            isInputValid = false;
        }
    }

    private boolean clearInput = false;
    private String guess = "";
    private boolean isInputValid = false;
    private int expect;
}

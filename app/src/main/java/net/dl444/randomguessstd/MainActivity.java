package net.dl444.randomguessstd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setState(new ReadyState(Common.getRandomNumber()));

        EditText inputBox = findViewById(R.id.inputBox);
        inputBox.addTextChangedListener(inputBoxWatcher);
    }

    public void checkBtn_click(View sender) {
        setState(state.check());
    }

    public void resultEmoji_click(View sender) {
        setState(state.dismiss());
    }

    private void setState(IGameState state) {
        this.state = state;
        TextView text = findViewById(R.id.hintTv);
        text.setText(getString(state.getHintTextId()));
        text.setTextColor(state.getHintTextColorId());

        EditText edit = findViewById(R.id.inputBox);
        if (state.shouldClearInput()) {
            edit.setText("");
        }
        if (state.isInputReadonly()) {
            edit.setEnabled(false);
        } else {
            edit.setEnabled(true);
        }

        ImageView img = findViewById(R.id.chevUp);
        img.setVisibility(state.isArrowShown() ? View.VISIBLE : View.INVISIBLE);
        img.setColorFilter(ContextCompat.getColor(this, state.getHighArrowColorId()));
        img = findViewById(R.id.chevDown);
        img.setVisibility(state.isArrowShown() ? View.VISIBLE : View.INVISIBLE);
        img.setColorFilter(ContextCompat.getColor(this, state.getLowArrowColorId()));

        Button btn = findViewById(R.id.checkBtn);
        btn.setVisibility(state.isCheckBtnShown() ? View.VISIBLE : View.INVISIBLE);

        img = findViewById(R.id.resultEmoji);
        img.setVisibility(state.isEmojiShown() ? View.VISIBLE : View.INVISIBLE);
        img.setImageResource(state.getEmojiDrawableId());
        img.setColorFilter(ContextCompat.getColor(this, state.getEmojiColorId()));
    }

    private IGameState state;
    private TextWatcher inputBoxWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().equals("")) {
                setState(state.enterGuess(s.toString()));
            }
        }
    };
}

package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by misrc_000 on 1/12/15.
 */
public class TextPlay extends Activity implements View.OnClickListener{
    Button btnCheck;
    ToggleButton tgCheck;
    EditText etCommand;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        initialize();
    }
    private void initialize(){
        btnCheck = (Button) findViewById(R.id.btnResult);
        tgCheck = (ToggleButton) findViewById(R.id.tgShow);
        etCommand = (EditText) findViewById(R.id.etCommands);
        tvShow = (TextView) findViewById(R.id.tvResult);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnResult:
                tvShow.setTextColor(Color.BLACK);
                tvShow.setText(etCommand.getText());
                if (etCommand.getText().toString().contentEquals("left"))
                    tvShow.setGravity(Gravity.LEFT);
                else if (etCommand.getText().toString().contentEquals("right"))
                    tvShow.setGravity(Gravity.RIGHT);
                else if (etCommand.getText().toString().contentEquals("blue"))
                    tvShow.setTextColor(Color.BLUE);
                else if (etCommand.getText().toString().contentEquals("red"))
                    tvShow.setTextColor(Color.RED);
                else if (etCommand.getText().toString().contentEquals("WTF")) {
                    Random random = new Random();
                    tvShow.setText("WTF!!!!");
                    tvShow.setTextColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                }
                tvShow.setGravity(Gravity.CENTER);
                break;
            case R.id.tgShow:
                if (tgCheck.isChecked())
                    etCommand.setInputType(InputType.TYPE_CLASS_TEXT);
                else {
                    etCommand.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                break;

        }
    }
}

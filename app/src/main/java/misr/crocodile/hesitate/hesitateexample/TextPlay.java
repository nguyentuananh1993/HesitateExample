package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
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
public class TextPlay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        Button btnCheck = (Button) findViewById(R.id.btnResult);
        final ToggleButton tgCheck = (ToggleButton) findViewById(R.id.tgShow);
        final EditText etCommand = (EditText) findViewById(R.id.etCommands);
        final TextView tvShow = (TextView) findViewById(R.id.tvResult);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShow.setTextColor(Color.BLACK);
                tvShow.setText(etCommand.getText());
                if(etCommand.getText().toString().contentEquals("left"))
                    tvShow.setGravity(Gravity.LEFT);
                else if(etCommand.getText().toString().contentEquals("right"))
                    tvShow.setGravity(Gravity.RIGHT);
                else if(etCommand.getText().toString().contentEquals("blue"))
                    tvShow.setTextColor(Color.BLUE);
                else if(etCommand.getText().toString().contentEquals("red"))
                    tvShow.setTextColor(Color.RED);
                else if(etCommand.getText().toString().contentEquals("WTF")){
                    Random random = new Random();
                    tvShow.setText("WTF!!!!");
                    tvShow.setTextColor(Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
                }
                    tvShow.setGravity(Gravity.CENTER);

            }
        });
        tgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgCheck.isChecked())
                    etCommand.setInputType(InputType.TYPE_CLASS_TEXT);
                else {
                    etCommand.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

            }
        });
    }
}

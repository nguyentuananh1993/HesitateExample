package misr.crocodile.hesitate.hesitateexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by misrc_000 on 1/14/15.
 */
public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    TextView question, test;
    Button ReturnData;
    RadioGroup selectionList;
    String setData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String temp = prefs.getString("name","Anonymous");
        String list = prefs.getString("list","4");
        if(list.contentEquals("1")){
            question.setText(temp);
        }
        else question.setText("anonymous is ...");
//        Bundle gotBasket = getIntent().getExtras();
//        gotBread = gotBasket.getString("key");
       question.setText(temp);
    }
    private void initialize(){
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);
        ReturnData = (Button) findViewById(R.id.btnReturn);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswer);
        selectionList.setOnCheckedChangeListener(this);
        ReturnData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", setData);
        person.putExtras(backpack);
        setResult(RESULT_OK,person);
        finish();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rBoth:
                setData = "Splot On!";
                break;
            case R.id.rSexy:
                setData = "Definitely right!";
                break;
            case R.id.rCrazy:
                setData = "Probably right!";
                break;
        }
        test.setText(setData);
    }
}

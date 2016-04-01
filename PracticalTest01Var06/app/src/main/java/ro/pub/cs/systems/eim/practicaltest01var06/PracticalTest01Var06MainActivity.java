package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PracticalTest01Var06MainActivity extends Activity
{
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private EditText firstEdit=null;
    private EditText secondEdit=null;
    private Button buttonClick=null;
    private Button secondButton=null;
    private LinearLayout layout=null;
    private TextListener text= new TextListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (layout.getVisibility() == View.INVISIBLE) {
                buttonClick.setText("Less details");
                layout.setVisibility(View.VISIBLE);

            } else {
                buttonClick.setText("More details");
                layout.setVisibility(View.INVISIBLE);

            }
        }

    }

    private class TextListener implements android.text.TextWatcher {

        @Override
       public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
                if (secondEdit.getText().toString().contains("http")) {
                    secondButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.green));
                    secondButton.setText("Pass");
                } else {
                    secondButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.red));
                    secondButton.setText("Fail");
                }

       }
        @Override
        public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4){}

        @Override
        public void afterTextChanged(Editable var1){}

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);
        firstEdit= (EditText)findViewById(R.id.edit_text);
        secondEdit= (EditText)findViewById(R.id.web_address);
        secondEdit.addTextChangedListener(text);
        buttonClick = (Button)findViewById(R.id.test_button);
        buttonClick.setOnClickListener(buttonClickListener);
        layout=(LinearLayout)findViewById(R.id.layout);
        secondButton= (Button)findViewById(R.id.new_button);

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(SAVED_STATE, secondEdit.getText());
        savedInstanceState.putString(SAVED_STATEB,secondButton.getText());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if(savedInstanceState !=null){
            secondEdit.setText(savedInstanceState.SAVE_STATE);
            secondEdit.setText(savedInstanceState.SAVE_STATEB);

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var06_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

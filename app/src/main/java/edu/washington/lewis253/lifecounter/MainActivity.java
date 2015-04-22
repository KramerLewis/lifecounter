package edu.washington.lewis253.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

    Button[][] buttons;
    int numPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numPlayers = 8;
        buttons = new Button[numPlayers][4];


        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int id = view.getId();
                boolean flag = false;
                for(int i= 1; i <= numPlayers; i++) {
                    TextView lifeCount = (TextView)findViewById(getResources().getIdentifier(("count" + i), "id", "edu.washington.lewis253.lifecounter"));
                    if(id == getResources().getIdentifier(("p" + i + "minus5"), "id", "edu.washington.lewis253.lifecounter")) {
                        lifeCount.setText("" + (Integer.parseInt(lifeCount.getText().toString()) - 5));
                        flag = true;
                    } else if (id == getResources().getIdentifier(("p" + i + "minus1"), "id", "edu.washington.lewis253.lifecounter")) {
                        lifeCount.setText("" + (Integer.parseInt(lifeCount.getText().toString()) - 1));
                        flag = true;
                    } else if (id == getResources().getIdentifier(("p" + i + "plus1"), "id", "edu.washington.lewis253.lifecounter")) {
                        lifeCount.setText("" + (Integer.parseInt(lifeCount.getText().toString()) + 1));
                        flag = true;
                    } else if (id == getResources().getIdentifier(("p" + i + "plus5"), "id", "edu.washington.lewis253.lifecounter")) {
                        lifeCount.setText("" + (Integer.parseInt(lifeCount.getText().toString()) + 5));
                        flag = true;
                    }
                    if(flag) {
                        if (Integer.parseInt(lifeCount.getText().toString()) <= 0) {
                            TextView label = (TextView)findViewById(R.id.loseLabel);
                            label.setText("Player " + i + " LOSES!");
                            label.setVisibility(View.VISIBLE);
                        }
                        break;
                    }
                }
            }
        };

        for(int i = 1; i <= numPlayers; i++) {
            String rowID = "player" + i;
            int id = getResources().getIdentifier(rowID, "id", "edu.washington.lewis253.lifecounter");
            TableRow row = (TableRow) findViewById(id);
            for(int j = 2; j < 6; j++) {
                buttons[i - 1][j - 2] = (Button) row.getChildAt(j);
                buttons[i - 1][j - 2].setOnClickListener(listener);
            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

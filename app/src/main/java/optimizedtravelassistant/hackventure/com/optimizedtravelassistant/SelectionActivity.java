package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SeekBar;

public class SelectionActivity extends AppCompatActivity {

    private Button prefButton;
    private Button settingsButton;

    private int thrill = 0;
    private int active = 0;
    private int explore = 0;
    private int engage = 0;
    private int party = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        prefButton = (Button) findViewById(R.id.pref_button);

        prefButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SeekBar thrillBar = findViewById(R.id.seekBarThrill);
                thrill = thrillBar.getProgress();
                SeekBar activeBar = findViewById(R.id.seekBarActive);
                active = activeBar.getProgress();
                SeekBar exploreBar = findViewById(R.id.seekBarExplore);
                explore = exploreBar.getProgress();
                SeekBar engageBar = findViewById(R.id.seekBarEngage);
                engage = engageBar.getProgress();
                SeekBar partyBar = findViewById(R.id.seekBarParty);
                party = partyBar.getProgress();
                int[] preferences = {thrill, active, explore, engage, party};


                Intent i = new Intent(SelectionActivity.this, AttractionMapActivity.class);
                startActivity(i);
                /**
                 Intent i = new Intent(Welcome.this, SelectionActivity.class);
                 startActivity(i);
                 */
            }
        });

        settingsButton = (Button) findViewById(R.id.pref_button2);

        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectionActivity.this, SettingsActivity.class);
                startActivity(i);
                /**
                 Intent i = new Intent(Welcome.this, SelectionActivity.class);
                 startActivity(i);
                 */
            }
        });
    }

    public int getThrill() {
        return thrill;
    }

    public int getActive() {
        return active;
    }

    public int getExplore() {
        return explore;
    }

    public int getEngage() {
        return engage;
    }

    public int getParty() {
        return party;
    }

    /**
    Spinner spinner = (Spinner) findViewById(R.id.realm_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.attraction_realms, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
    spinner.setAdapter(adapter);
     **/

}

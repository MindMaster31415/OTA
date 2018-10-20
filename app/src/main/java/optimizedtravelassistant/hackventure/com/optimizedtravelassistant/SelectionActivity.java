package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public class SelectionActivity extends AppCompatActivity {

    private int thrill = 0;
    private int active = 0;
    private int explore = 0;
    private int engage = 0;
    private int vibe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
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

    public int getVibe() {
        return vibe;
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

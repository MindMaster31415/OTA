package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SeekBar;
import org.json.*;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class SelectionActivity extends AppCompatActivity {


    private Button prefButton;
    private Button settingsButton;
    private RadioGroup radioGroup;

    private String URL = "https://hackventure---ha-1539747396872.appspot.com/sorter";

    private int thrill = 0;
    private int active = 0;
    private int explore = 0;
    private int engage = 0;
    private int party = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        radioGroup = (RadioGroup) findViewById(R.id.sort_chooser);
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

                /**
                RadioButton radioButton = (RadioButton) findViewById(selected);

                switch((String) radioButton.getText()) {
                    case "Preferences-heavy":
                        sort_value = 1;
                        break;
                    case "Weather-heavy":
                        sort_value = 2;
                        break;
                    case "Traffic-heavy":
                        sort_value = 3;
                        break;
                    default:
                        sort_value = 0;
                }
                 */
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                double[] coords = {33,-84};
                String coordinates = coords[0] + "," + coords[1];

                JSONObject packet = new JSONObject();
                int[] prefs = preferences;

                try {
                    packet.put("algorithm_num", 0);
                    packet.put("gps_coordinates", coordinates);
                    packet.put("user_preference", prefs);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, URL, packet, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Log.i("response", response.toString());
                                JSONObject result = response;
                                if (response != null) {
                                    Intent i = new Intent(SelectionActivity.this, AttractionMapActivity.class);
                                    //i.putExtra("result_json", result);
                                    startActivity(i);
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error

                            }
                        });

                queue.add(jsonObjectRequest);



                /**
                JSONObject packet = new JSONObject();
                try {
                    packet.put("preferences", preferences);
                } catch (JSONException e) {
                    e.printStackTrace();

                }
*/



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

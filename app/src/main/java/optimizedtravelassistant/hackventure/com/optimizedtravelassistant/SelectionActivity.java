package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.List;

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

                Intent i = new Intent(SelectionActivity.this, AttractionMapActivity.class);
                i.putExtra("preferences", preferences);
                startActivity(i);
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
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private double[] getGPS() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = lm.getProviders(true);
/* Loop over the array backwards, and if you get an accurate location, then break                 out the loop*/
        Location l = null;
        if(providers.size() == 0) {
            Toast.makeText(SelectionActivity.this, "No Location Service available", Toast.LENGTH_LONG).show();
            List<String> check = lm.getAllProviders();
            if(check.isEmpty()) {
                Toast.makeText(SelectionActivity.this, "Can't find any providers at all", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
                providers = lm.getAllProviders();
            }
        }
        for (int i = providers.size() - 1; i >= 0; i--) {
            if (ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                //    ActivityCompat#requestPermissions
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
                providers = lm.getProviders(true);
                if(providers.size() == 0) {
                    double[] gps = new double[2];
                    gps[0] = 30;
                    gps[1] = -80;
                    return gps;
                }
            }
            l = lm.getLastKnownLocation(providers.get(i));
            if (l != null) break;
        }

        double[] gps = new double[2];
        if (l != null) {
            gps[0] = l.getLatitude();
            gps[1] = l.getLongitude();
        }
        return gps;
    }
}

package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button beginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        beginButton = (Button) findViewById(R.id.beginButton);

        beginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Welcome.this, SelectionActivity.class);
                startActivity(i);
            }
        });
    }
}

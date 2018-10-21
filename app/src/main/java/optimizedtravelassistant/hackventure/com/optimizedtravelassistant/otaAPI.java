package optimizedtravelassistant.hackventure.com.optimizedtravelassistant;

import java.io.*;
import java.net.*;
import org.json.*;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
/**
 * Created by Param on 10/20/2018.
 */

public class otaAPI {

    private JSONObject results;
    private String URL = "https://hackventure---ha-1539747396872.appspot.com/sorter";

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
            (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    results = response;
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error

                }
            });
}
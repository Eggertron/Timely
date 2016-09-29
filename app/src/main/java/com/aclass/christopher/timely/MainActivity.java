package com.aclass.christopher.timely;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.net.sip.SipAudioCall;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    StringBuilder timeString;
    TextView tText;
    Button rButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tText = (TextView) findViewById(R.id.timeText);
        rButton = (Button) findViewById(R.id.RecordTime);
        rButton.setOnClickListener(this);


        timeString = new StringBuilder();
        if (savedInstanceState != null) {
            String temp = savedInstanceState.getString("time");
            if (temp != null && !(temp.equals("null"))) {
                timeString.append(temp);
            }
            tText.setText(timeString);
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {


        if (outState != null) {

            outState.putString("time", timeString.toString());
            //outPersistentState.putString("time", timeString.toString());
        }

        super.onSaveInstanceState(outState, outPersistentState);
    }

                                            // Edgar Han 7037178188 edgarh@vt.edu
    @Override
    public void onClick(View v) {
        if (v.getId() == rButton.getId()) {
            //SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            //Date now = new Date();

            //timeString.append(sdf.format(now));
            timeString.append("Testing save instance.");
            timeString.append("\n");
            tText.setText(timeString);
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    /**
     *
     <TextView
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:id="@+id/timeText"
     android:text="*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n"
     android:textAlignment="center"/>

     <Button
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:id="@+id/RecordTime"
     android:textAlignment="center"
     android:layout_below="@id/timeText"/>

     */
}

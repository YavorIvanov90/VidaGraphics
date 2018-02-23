package com.example.android.vidagraphics;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Used to open  Web browser to open the website
    public void openWeb(View view) {
        String www = "http://" + getString(R.string.web);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(www));
        startActivity(intent);
    }

    // Used to open email app to send email
    public void sendEmail(View view) {
        String to = getString(R.string.email);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_EMAIL, to);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // Used to open call app to dial the number
    public void phoneCall(View view) {
        String to = getString(R.string.phoneNumberToDial);
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse(to));
        if (phoneIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(phoneIntent);
        }
    }

    // Used to open Maps app to show the address
    public void openMap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:48.207689, 16.371235");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(gmmIntentUri);
        startActivity(mapIntent);
    }
}

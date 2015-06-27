package com.capitalone.dealnreward.dealandreward;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class CouponActivity extends FragmentActivity implements LocationFragment.OnFragmentInteractionListener {

    GoogleMap map;

    String zCode;
    public static FragmentManager fragmentManager;

    public String getZipCode() {
        if (getIntent().getExtras() != null) {
            zCode = getIntent().getExtras().getString("zipCodeValue");
        }
            //Toast.makeText(this, "get ZipCode:"+zCode, Toast.LENGTH_SHORT).show();
        return zCode;
    }

    public void setZipCode(String code)
    {
        zCode = code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        fragmentManager = getFragmentManager();


        FragmentTransaction ft = fragmentManager.beginTransaction();

        LocationFragment lf = new LocationFragment();
        ft.replace(R.id.mapView, lf);
        ft.commit();


       /* Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivityForResult(mapIntent, 1);*/

       // GoogleMap mGoogleMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
        /*map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        if (map != null) {
            Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
                    .title("Hamburg"));
            Marker kiel = map.addMarker(new MarkerOptions()
                    .position(KIEL)
                    .title("Kiel")
                    .snippet("Kiel is cool"));
                    *//*.icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_launcher)));*//*
        }
*/


        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                "dealnrewardPrefFiles", Context.MODE_PRIVATE);

       final EditText editText = (EditText) findViewById(R.id.locationInput);
/*
        ((EditText)findViewById(R.id.locationInput)).setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (!event.isShiftPressed()) {
                                Bundle bundle=new Bundle();
                                bundle.putString("zipcode", "60616");
                                //set Fragmentclass Arguments
                                LocationFragment fragobj=new LocationFragment();
                                fragobj.setArguments(bundle);
                                Intent i = new Intent(CouponActivity.this, CouponActivity.class);
                                startActivity(i);

                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                });*/

        /*editText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
               *//* SharedPreferences sharedPref = getBaseContext().getSharedPreferences(
                        "dealnrewardPrefFiles", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("zipcode", editText.getText().toString());*//*
                if(!hasFocus)
                {
                    Toast.makeText(getBaseContext(), "DOne focus", Toast.LENGTH_SHORT).show();
                    Bundle bundle=new Bundle();
                    bundle.putString("zipcode", "60616");
                    //set Fragmentclass Arguments
                    LocationFragment fragobj=new LocationFragment();
                    fragobj.setArguments(bundle);
                    Intent i = new Intent(CouponActivity.this, CouponActivity.class);
                    startActivity(i);

                }
            }
        });*/

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
               /* SharedPreferences sharedPref = getBaseContext().getSharedPreferences(
                        "dealnrewardPrefFiles", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("zipcode", editText.getText().toString());*/
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //Toast.makeText(getBaseContext(), "DOne focus", Toast.LENGTH_SHORT).show();
                    /*Bundle bundle = new Bundle();
                    bundle.putString("zipCode", "60616");
                    //set Fragmentclass Arguments
                    LocationFragment fragobj = new LocationFragment();
                    fragobj.setArguments(bundle);*/
                    //zCode = "60173";

                    Intent i = new Intent(CouponActivity.this, CouponActivity.class);
                    i.putExtra("zipCodeValue", editText.getText().toString() );
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });

        Button button =(Button) findViewById(R.id.tgif);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getBaseContext().getSharedPreferences(
                        "dealnrewardPrefFiles", Context.MODE_PRIVATE);
                Intent i = new Intent(CouponActivity.this, SelectedCoupon.class);
                i.putExtra("couponSelected", "tgifcoupon");
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("reward1", "test1");
                startActivity(i);
            }
        });

        ImageButton imgButton =(ImageButton) findViewById(R.id.walleticon);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CouponActivity.this, WalletActivity.class);
                startActivity(i);
            }
        });

        imgButton =(ImageButton) findViewById(R.id.icon4);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CouponActivity.this, dealMainActivity.class);
                startActivity(i);
            }
        });

        imgButton =(ImageButton)findViewById(R.id.icon1);
        imgButton.setOnTouchListener(new ButtonHighlighterOnTouchListener(imgButton));
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  Toast.makeText(getApplicationContext(), "You download is resumed", Toast.LENGTH_LONG).show();*/

               /* Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
                i.putExtra(Intent.EXTRA_TEXT, "http://www.url.com");
                startActivity(Intent.createChooser(i, "Share URL"));*/

                ArrayList<Uri> imageUris = new ArrayList<Uri>();
                // imageUris.add(R.drawable.c1);

                Resources resources = getResources();
                Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.drawable.c1) + '/' + resources.getResourceTypeName(R.drawable.c1) + '/' + resources.getResourceEntryName(R.drawable.c1));
                imageUris.add(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + resources.getResourcePackageName(R.drawable.c1) + '/' + resources.getResourceTypeName(R.drawable.c1) + '/' + resources.getResourceEntryName(R.drawable.c1)));

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, imageUris);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_TEXT, "Download CapitalOne Deals 'n Rewards App \n http://capitalone.com/Apps/DealsnRewards/U1CX7D");
                startActivity(Intent.createChooser(intent,"compatible apps:"));
            }
        });
       /* Button tgifbutton =(Button) findViewById(R.id.tgif);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CouponActivity.this, SelectedCoupon.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coupon, menu);
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

    @Override
    public void onLocationChanged(Location location) {

        //TextView tvLocation = (TextView) findViewById(R.id.tv_location);

        // Getting latitude of the current location
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        // Setting latitude and longitude in the TextView tv_location
        //tvLocation.setText("Latitude:" +  latitude  + ", Longitude:"+ longitude );

    }
*/
/*
    private static View view;
    private static GoogleMap mMap;
    private static Double latitude, longitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        view = (RelativeLayout) inflater.inflate(R.layout.activity_coupon, container, false);
        // Passing harcoded values for latitude & longitude. Please change as per your need. This is just used to drop a Marker on the Map
        latitude = 26.78;
        longitude = 72.56;

        setUpMapIfNeeded(); // For setting up the MapFragment

        return view;
    }

    *//***** Sets up the map if it is possible to do so *****//*
    public static void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) CouponActivity.
                    .findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    *//**
     * This is where we can add markers or lines, add listeners or move the
     * camera.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap}
     * is not null.
     *//*
    private static void setUpMap() {
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("My Home").snippet("Home Address"));
        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,
                longitude), 12.0f));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) MainActivity.fragmentManager
                    .findFragmentById(R.id.location_map)).getMap(); // getMap is deprecated
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    *//**** The mapfragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****//*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mMap != null) {
            MainActivity.fragmentManager.beginTransaction()
                    .remove(MainActivity.fragmentManager.findFragmentById(R.id.location_map)).commit();
            mMap = null;
        }
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            Uri dataValue = data.getData();
            Toast.makeText(this, dataValue.toString(),Toast.LENGTH_LONG);
        }
    }
}

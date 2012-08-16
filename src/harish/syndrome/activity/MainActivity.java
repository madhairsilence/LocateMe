package harish.syndrome.activity;

import harish.syndrome.R;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button whereAmId = (Button) findViewById( R.id.whereAmId);
		MyClickListener myClickListener = new MyClickListener();
		whereAmId.setOnClickListener(myClickListener);
		
		AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
		alert.setMessage( "Loading complete" );
		alert.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	class MyLocationListener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {

			AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
			alert.setMessage( location.getLongitude()+"" );
			alert.show();
		}

		@Override
		public void onProviderDisabled(String arg0) {
			 Toast.makeText(getApplicationContext(), " Location. Please Wait", 10).show();

		}

		@Override
		public void onProviderEnabled(String arg0) {
			Toast.makeText(getApplicationContext(), " Location. Please Wait", 10).show();

		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			Toast.makeText(getApplicationContext(), " Location. Please Wait", 10).show();

		}

	}

	class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			
			Toast.makeText(getApplicationContext(), "Getting Location. Please Wait", 10).show();			

			LocationListener locationListener = new MyLocationListener();		

			LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);		
			
			Toast.makeText(getApplicationContext(),locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)+"",10).show();
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 100, 1, locationListener);
			
			Toast.makeText(getApplicationContext(), "Received Location", 10).show();
		}

	}
}



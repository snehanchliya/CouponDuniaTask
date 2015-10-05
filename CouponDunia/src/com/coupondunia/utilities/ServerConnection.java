package com.coupondunia.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.coupondunia.model.Category;
import com.coupondunia.model.Data;
import com.coupondunia.model.Offers;
import com.google.gson.JsonNull;

public class ServerConnection {

	public interface OffersInterface {
		public void getOffers(List<Data> data,Address address);
	}

	private Context context;
	private static final String OFFERS_URL = "http://staging.couponapitest.com/task_data.txt ";
	private final String OutletName = "OutletName";
	private static RequestQueue queue;
	private static OffersInterface offersInterface;
	GPSTracker gps;
	double sourceLat, sourceLong;

	public ServerConnection(Context context) {
		this.context = context;
	}

	public void setOffersListener(OffersInterface offersInterface) {
		ServerConnection.offersInterface = offersInterface;
	}
	
	private Address getAddressByLatAndLong(double latitude,double longitude){
		Geocoder geocoder;
		List<Address> addresses = new ArrayList<Address>();
		geocoder = new Geocoder(context, Locale.getDefault());
		Address address=new Address(Locale.getDefault());
		try {
			addresses = geocoder.getFromLocation(latitude, longitude, 1);
			if(addresses!=null && addresses.size()>0)
			address=addresses.get(0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Here 1 represent max location result to returned, by documents it recommended 1 to 5

		return address;
		/*String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
		String city = addresses.get(0).getLocality();
		String state = addresses.get(0).getAdminArea();
		String country = addresses.get(0).getCountryName();
		String postalCode = addresses.get(0).getPostalCode();
		String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
*/	}

	private Offers mapping(String JSON) {

		gps = new GPSTracker(context);
		if (gps.canGetLocation()) { // gps enabled} // return boolean true/false
			sourceLat = gps.getLatitude();
			sourceLong = gps.getLongitude();
			
		} else {
			gps.showSettingsAlert();
		}

		Offers offers = new Offers();
		try {
			JSONObject root = new JSONObject(JSON);

			JSONObject dataJSONObj = root.getJSONObject("data");

			Data data;
			List<Data> dataList = new ArrayList<Data>(dataJSONObj.length());

			for (int i = 0; i < dataJSONObj.length() - 1; i++) {

				if (dataJSONObj.isNull(String.valueOf(i)))
					continue;
				JSONObject obj = dataJSONObj.getJSONObject(String.valueOf(i));

				String logoURL = String.valueOf(obj.getString("LogoURL"));
				String outletName = String.valueOf(obj.getString(OutletName));
				int numCoupons = obj.getInt("NumCoupons");							
				String neighbourhoodName = String.valueOf(obj.getString("NeighbourhoodName"));
				String targetLat = String.valueOf(obj.getString("Latitude"));
				String targetLog = String.valueOf(obj.getString("Longitude"));

				data = new Data();
							
				if (logoURL != null && logoURL.length() > 1)
					data.setLogoURL(logoURL);
				if (outletName != null && outletName.length() > 1)
					data.setOutletName(outletName);
				
					data.setNumCoupons(numCoupons);				
				
				if (neighbourhoodName != null && neighbourhoodName.length() > 1)
					data.setNeighbourhoodName(neighbourhoodName);
				if (targetLat != null && targetLat.length() > 1
						&& targetLog != null && targetLog.length() > 1) {
					data.setLatitude(targetLat);
					data.setLongitude(targetLog);

					double destLat = Double.parseDouble(targetLat);
					double destLong = Double.parseDouble(targetLog);
					data.setDistance(gps.getDistanceByLatAndLong(sourceLat,
							sourceLong, destLat, destLong));
				}

				if (obj.isNull("Categories")) {
					dataList.add(data);
					continue;
				}

				JSONArray categoryObj = obj.getJSONArray("Categories");
				List<Category> categories = new ArrayList<Category>();
				Category category;
				StringBuilder categoiesString=new StringBuilder();
				for (int j = 0; j < categoryObj.length(); j++) {

					if (categoryObj.isNull(j))
						continue;
					JSONObject catObj = categoryObj.getJSONObject(j);
					String name = catObj.getString("Name");
					
					category = new Category();
					if (name != null && name.length() > 1)
					{ 
						categoiesString.append("� "+name+" ");
						category.setName(name);
					}
					categories.add(category);
				}
				data.setCategoriesString(categoiesString.toString());
				data.setCategories(categories);
				dataList.add(data);
			}

			offers.setData(dataList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return offers;

		// TypeToken<Collection<OffersModel>>(){}.getType();
		// OffersModel enums = gson.fromJson(JSON, OffersModel.class);
	}

	public void getOffersFromServer() {
		
		queue = Volley.newRequestQueue(context);
		
		// Request a string response from the provided URL.
		StringRequest stringRequest = new StringRequest(Request.Method.GET,
				OFFERS_URL, new Response.Listener<String>() 
				{
					@Override
					public void onResponse(String response) {						
						Offers offers = mapping(response);
						ServerConnection.offersInterface.getOffers(offers
								.getData(),getAddressByLatAndLong(sourceLat,sourceLong));
						Log.i("onResponse", response);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
												
						Toast.makeText(context, "There is some server side issue please try again later", Toast.LENGTH_LONG).show();
					}
					
				});
		// Add the request to the RequestQueue.
		queue.add(stringRequest);

	}
}

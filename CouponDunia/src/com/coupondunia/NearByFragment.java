package com.coupondunia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.coupondunia.adapter.NearByAdapter;
import com.coupondunia.model.Data;
import com.coupondunia.utilities.GPSTracker;
import com.coupondunia.utilities.ServerConnection;
import com.coupondunia.utilities.ServerConnection.OffersInterface;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class NearByFragment extends Fragment implements OffersInterface {
	double latitude, longitude;
	GPSTracker gps;
	View mHeaderView;
	TextView currentLocation;
	ListView restaurantListView;
	TextView locatonName;
	View locationLayout;

	public static NearByFragment newInstance() {
		NearByFragment fragment = new NearByFragment();

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreateView(inflater, container, savedInstanceState);

		View view = inflater
				.inflate(R.layout.nearby_fragment, container, false);

		locationLayout = view.findViewById(R.id.locationLayout);

		locationLayout.setVisibility(View.GONE);
		
		locatonName = (TextView) view.findViewById(R.id.locationName);

		restaurantListView = (ListView) view
				.findViewById(R.id.restaurantListView);

		getOffers();

		return view;

	}

	private void getOffers() {
		ServerConnection sc = new ServerConnection(getActivity());
		sc.getOffersFromServer();
		sc.setOffersListener(this);
	}

	@Override
	public void getOffers(List<Data> offers, Address address, boolean isSucess) {
		// TODO Auto-generated method stub

		if (isSucess) {

			if (address != null) {

				String subLocality = address.getSubLocality();
				locationLayout.setVisibility(View.VISIBLE);
				if (subLocality == null || subLocality.length() < 1) {
					locatonName.setText("Location Not Found!");
				} else {
					locatonName.setText(subLocality);
				}

			}

			Collections.sort(offers, new DistanceComparator());

			restaurantListView.setAdapter(new NearByAdapter(getActivity(),
					offers));

		} else {
			locationLayout.setVisibility(View.GONE);

			Toast.makeText(getActivity(),
					"There is some server side issue please try again later",
					Toast.LENGTH_LONG).show();
		}
	}

	private void mockComparator() {
		List<Data> data = new ArrayList<Data>();
		Data d = new Data();
		d.setDistance((double) 258);
		data.add(d);
		d = new Data();
		d.setDistance((double) 225);
		data.add(d);
		d = new Data();
		d.setDistance((double) 275);
		data.add(d);
		d = new Data();
		d.setDistance((double) 201);
		data.add(d);
		d = new Data();
		d.setDistance((double) 205);
		data.add(d);
		d = new Data();
		d.setDistance((double) 245);
		data.add(d);
		d = new Data();

		Collections.sort(data, new DistanceComparator());

		Log.i("Collection", String.valueOf(data.size()));
	}

	public class DistanceComparator implements Comparator<Data> {

		@Override
		public int compare(Data o1, Data o2) {
			return o1.getDistance().compareTo(o2.getDistance());
		}

	}
}

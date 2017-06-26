package com.george.assignment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.george.assignment.Adapters.ProductFeedsAdapter;
import com.george.assignment.Models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ProductFeeds extends Fragment
{
	SwipeRefreshLayout swLayout;
	RecyclerView rvProductFeeds;

	public ProductFeeds()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_product_feeds, container, false);
		initializeComponents(view);
		return view;
	}

	private void initializeComponents(View view)
	{
		view.setClickable(true);
		swLayout = (SwipeRefreshLayout) view.findViewById(R.id.swLayout);
		swLayout.setOnRefreshListener(this::refreshLayout);
		new AsyncFetch().execute();
	}

	private void refreshLayout()
	{
		new AsyncFetch().execute();
	}


	private class AsyncFetch extends AsyncTask<String, String, String>
	{
		ProgressDialog pdLoading = new ProgressDialog(getActivity());
		HttpURLConnection conn;

		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			pdLoading.setCancelable(true);
			pdLoading.setMessage("Loading...");
			pdLoading.show();

		}

		@Override
		protected String doInBackground(String... params)
		{
			try
			{
				URL url = new URL("http://192.168.72.134/assignment/api/products");

				conn = (HttpURLConnection) url.openConnection();
				InputStream input = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				StringBuilder result = new StringBuilder();
				String line;

				while((line = reader.readLine()) != null)
				{
					result.append(line);
				}
				return (result.toString());
			}
			catch(IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return e1.toString();
			}
			finally
			{
				conn.disconnect();
			}
		}

		@Override
		protected void onPostExecute(String result)
		{
			Log.i("JSON", "onPostExecute: " + result);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create();
			List<Product> products = gson.fromJson(result, new TypeToken<List<Product>>() {}.getType());
			Log.i("Done", products.get(0).getName());
			rvProductFeeds = (RecyclerView) ProductFeeds.this.getView().findViewById(R.id.rvProductFeeds);
			ProductFeedsAdapter adapter = new ProductFeedsAdapter(products);
			rvProductFeeds.setAdapter(adapter);
			rvProductFeeds.setLayoutManager(new LinearLayoutManager(getActivity()));
			swLayout.setRefreshing(false);
			pdLoading.dismiss();
		}

	}

}

package com.george.assignment.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.george.assignment.Models.Product;
import com.george.assignment.R;
import java.text.SimpleDateFormat;
import java.util.List;


public class ProductFeedsAdapter extends RecyclerView.Adapter<ProductFeedsAdapter.ViewHolder>
{
	private static final String TAG =ProductFeedsAdapter.class.getSimpleName();

	private List<Product> products;

	static class ViewHolder extends RecyclerView.ViewHolder
	{
		private TextView tvUserName, tvDateAdded;
		private Button btComplain, btSendComplain;
		private LinearLayout complainPart;
		private ToggleButton tbtLove;
		private ImageView ivPhoto, ivUser;
		private EditText etComplain;

		private TextView getTvUserName()
		{
			return tvUserName;
		}

		private TextView getTvDateAdded()
		{
			return tvDateAdded;
		}

		private Button getBtSendComplain()
		{
			return btSendComplain;
		}

		private LinearLayout getComplainPart()
		{
			return complainPart;
		}

		private ToggleButton getTbtLove()
		{
			return tbtLove;
		}

		private ImageView getIvPhoto()
		{
			return ivPhoto;
		}

		private ImageView getIvUser()
		{
			return ivUser;
		}

		private EditText getEtComplain()
		{
			return etComplain;
		}

		ViewHolder(View v)
		{
			super(v);

			tvUserName = (TextView) v.findViewById(R.id.tvUser);
			tvDateAdded = (TextView) v.findViewById(R.id.tvDateAdded);
			btSendComplain = (Button) v.findViewById(R.id.btSendComplain);
			btComplain = (Button) v.findViewById(R.id.btComplain);
			complainPart = (LinearLayout) v.findViewById(R.id.complainPart);
			tbtLove = (ToggleButton) v.findViewById(R.id.tbtLove);
			ivPhoto = (ImageView) v.findViewById(R.id.ivPhoto);
			ivUser = (ImageView) v.findViewById(R.id.ivUser);
			etComplain=(EditText)v.findViewById(R.id.etComplain);

			btComplain.setOnClickListener(this::ButtonComplainClicked);
		}

		private void ButtonComplainClicked(View view)
		{
			if (complainPart.getVisibility() == View.VISIBLE)
				complainPart.setVisibility(View.GONE);
			else
				complainPart.setVisibility(View.VISIBLE);
		}
	}

	public ProductFeedsAdapter(List<Product> products)
	{
		this.products = products;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
	{
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_adapter_layout, viewGroup, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, final int position)
	{
		viewHolder.getBtSendComplain().setOnClickListener(v -> SendComplainClicked(viewHolder.getEtComplain(), viewHolder.getComplainPart()));
		viewHolder.getTvUserName().setText(products.get(position).getName());
		viewHolder.getTvDateAdded().setText(new SimpleDateFormat("'On' dd-MMMM-yyyy 'at' hh:mm aaa").format(products.get(position).getDateAdded()));

	}

	private void SendComplainClicked(EditText etComplain, LinearLayout complainPart)
	{
		if (etComplain.getText().toString().trim().equals(""))
		{
			Log.i(TAG, "SendComplainClicked: "+etComplain.getText());
		}
		complainPart.setVisibility(View.GONE);
		etComplain.setText("");
	}
	@Override
	public int getItemCount()
	{
		return products.size();
	}
}

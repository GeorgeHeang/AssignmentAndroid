package com.george.assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.IOException;

public class NewProduct extends Fragment
{
	private static final int SELECT_IMAGE = 1;

	ImageView ivNewPhoto;

	public NewProduct()
	{
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_new_product, container, false);
		initializeComponents(view);
		return view;
	}

	private void initializeComponents(View view)
	{

		view.setClickable(true);
		ivNewPhoto = (ImageView) view.findViewById(R.id.ivNewPhoto);
		Button btUpload = (Button) view.findViewById(R.id.btUpload);
		EditText etProductName = (EditText) view.findViewById(R.id.etProductName);
		EditText etPrice = (EditText) view.findViewById(R.id.etPrice);
		EditText etDetail = (EditText) view.findViewById(R.id.etDetail);
		EditText etQuantity = (EditText) view.findViewById(R.id.etQuantity);
		Button btSave = (Button) view.findViewById(R.id.btSave);
		RadioGroup rgCurrency = (RadioGroup) view.findViewById(R.id.rgCurrency);

		btUpload.setOnClickListener(this::uploadClicked);
	}

	private void uploadClicked(View view)
	{
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);//
		startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == SELECT_IMAGE)
		{
			if(resultCode == Activity.RESULT_OK)
			{
				if(data != null)
				{
					try
					{
						Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
						ivNewPhoto.setImageBitmap(bitmap);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
}

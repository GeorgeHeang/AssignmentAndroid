package com.george.assignment.ClassHelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public abstract class ImageConverter
{
	public static String GetBase64String(Bitmap bitmap, Bitmap.CompressFormat format)
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(format, 100, stream);
		return Base64.encodeToString(stream.toByteArray(), Base64.NO_WRAP);
	}
	public  static Bitmap GetBitmapFromBase64String(String base64String)
	{
		byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
		return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
	}
}

package com.androidbook.MediaPetTracker;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*  
 * FYI: We are not using this class in the example, but you could change the PetListAdapter.getView() to:

			 PetListItemView i = new PetListItemView(mContext, mPets[position]);
		     return i;
		     
 * This class would make each list item view programmatically instead of inflating the pet_item layout resource from XML
 * This can be helpful if you want to add bells and whistles to your ListView item layout that cannot be properly configured using the 
 * XML layout resource method
 */
public class PetListItemView extends RelativeLayout {

	private final int PET_PIC_ID = 1234;
	protected TextView mPetName;
	protected TextView mPetType;
	protected ImageView mPetPic;

	public PetListItemView(Context context, PetRecord pet) {
		super(context);

		// PET PICTURE
		mPetPic = new ImageView(context);
		mPetPic.setAdjustViewBounds(true);
		mPetPic.setMaxHeight(100);
		mPetPic.setMaxWidth(100);
		mPetPic.setId(PET_PIC_ID);
		if (pet.getPetImageId() != 0) {
			Uri baseUri = Uri.parse(pet.getPetImageUriPath());
			Uri imageUri = ContentUris.withAppendedId(baseUri, pet
					.getPetImageId());
			mPetPic.setImageURI(imageUri);
		}

		RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		imageParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

		addView(mPetPic, imageParams);

		// PET NAME
		mPetName = new TextView(context);
		mPetName.setText(pet.getPetName());

		RelativeLayout.LayoutParams nameParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		nameParams.addRule(RelativeLayout.ALIGN_RIGHT, mPetPic.getId());
		imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		addView(mPetName, nameParams);

		// PET TYPE
		mPetType = new TextView(context);
		mPetType.setText("(" + pet.getPetType() + ")");

		RelativeLayout.LayoutParams typeParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		typeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		addView(mPetType, typeParams);

	}
}

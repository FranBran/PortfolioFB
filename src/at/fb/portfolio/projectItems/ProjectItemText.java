package at.fb.portfolio.projectItems;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import at.fb.portfolio.R;

public class ProjectItemText extends ProjectItem {
	
	public static final String TYPE = "at.fb.portfolio.ProjectItemText.TYPE";
	private String mTxt;
	
	public ProjectItemText(String txt) {
		mTxt = txt;
	}
	
	@Override
	public View getView(View rootView) {
		LayoutInflater inflater = (LayoutInflater) rootView.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TextView view = (TextView) inflater.inflate(
				R.layout.project_item_text_view, null);
		
		view.setText(mTxt);
		return view;
	}
	
	public static final Parcelable.Creator<ProjectItemText> CREATOR = new Parcelable.Creator<ProjectItemText>() {
		public ProjectItemText createFromParcel(Parcel in) {
			return new ProjectItemText(in);
		}

		public ProjectItemText[] newArray(int size) {
			return new ProjectItemText[size];
		}
	};
	
	public ProjectItemText(Parcel in) {
		mTxt = in.readString();
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(TYPE);
		dest.writeString(mTxt);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}

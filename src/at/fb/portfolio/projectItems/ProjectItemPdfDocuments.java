package at.fb.portfolio.projectItems;

import java.util.ArrayList;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import at.fb.portfolio.PdfDocument;
import at.fb.portfolio.R;
import at.fb.portfolio.adapters.DocumentAdapter;

public class ProjectItemPdfDocuments extends ProjectItem {

	public static final String TYPE = "at.fb.portfolio.ProjectItemPdfDocuments.TYPE";
	private ArrayList<PdfDocument> mPdfDocuments;

	private ProjectItemPdfDocuments() {
		mPdfDocuments = new ArrayList<PdfDocument>();
	}

	public ProjectItemPdfDocuments(ArrayList<PdfDocument> pdfDocuments) {
		mPdfDocuments = pdfDocuments;
	}

	@Override
	public View getView(final View rootView) {
		LayoutInflater inflater = (LayoutInflater) rootView.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		GridView view = (GridView) inflater.inflate(
				R.layout.project_item_pdf_documents, null);

		view.setAdapter(new DocumentAdapter(rootView.getContext(),
				mPdfDocuments));

		return view;
	}

	public static final Parcelable.Creator<ProjectItemPdfDocuments> CREATOR = new Parcelable.Creator<ProjectItemPdfDocuments>() {
		public ProjectItemPdfDocuments createFromParcel(Parcel in) {
			return new ProjectItemPdfDocuments(in);
		}

		public ProjectItemPdfDocuments[] newArray(int size) {
			return new ProjectItemPdfDocuments[size];
		}
	};

	public ProjectItemPdfDocuments(Parcel in) {
		this();
		in.readTypedList(mPdfDocuments, PdfDocument.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(TYPE);
		dest.writeTypedList(mPdfDocuments);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
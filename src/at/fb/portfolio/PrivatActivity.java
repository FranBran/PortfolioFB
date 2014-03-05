package at.fb.portfolio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import at.fb.portfolio.adapter.TabsAdapter;
import at.fb.portfolio.tools.PDFTools;

public class PrivatActivity extends ActionBarActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private TabsAdapter tabsAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_privat);

		// Show the Up button in the action bar.
		final ActionBar actionBar = setupActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Fragments to be shown as Tabs
		Fragment[] frags = { new PrivatAboutMeFragment(), 
				new PrivatDocsFragment() };
		
		// Corresponding fragment's TabTitles
		String[] tabTitles = {
				getString(R.string.tabTitle_privat_fragment_aboutMe),
				getString(R.string.tabTitle_privat_fragment_documents)
		};
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		tabsAdapter = new TabsAdapter(
				getSupportFragmentManager(), frags, tabTitles);
		

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.privatPager);
		mViewPager.setAdapter(tabsAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < tabsAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(tabsAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	private ActionBar setupActionBar() {
		ActionBar aBar = getSupportActionBar();
		aBar.setDisplayHomeAsUpEnabled(true);
		return aBar;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.privat, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	public void showCV(View view) {
		PDFTools.showPDFUrl( this, "http://www.pdf-archive.com/2014/03/05/lebenslauf/lebenslauf.pdf" );
	}
	
	public void showMasterThesis(View view) {
		PDFTools.showPDFUrl( this, "http://www.pdf-archive.com/2014/03/05/masterthesis/masterthesis.pdf" );
	}
	
	public void showBakkThesis(View view) {
		PDFTools.showPDFUrl( this, "http://www.pdf-archive.com/2014/03/05/bachelorthesis/bachelorthesis.pdf" );
	}
}

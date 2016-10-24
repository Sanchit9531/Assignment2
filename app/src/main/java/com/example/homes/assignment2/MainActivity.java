package com.example.homes.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.homes.assignment2.R.id.CommedyListView;
import static com.example.homes.assignment2.R.id.container;

public class MainActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        private List<comedysection> myComedy = new ArrayList<comedysection>();
        private List<comedysection> myMovies = new ArrayList<comedysection>();
        private List<comedysection> myEdu = new ArrayList<comedysection>();
        private List<comedysection> arr;
        int listID;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
                View rootView = inflater.inflate(R.layout.fragment_comedy, container, false);
                populatecomedyList();
                arr=myComedy;
                listID=R.id.CommedyListView;
                ArrayAdapter<comedysection> adapter = new ComedyListAdapter(getActivity());

                ListView list = (ListView) rootView.findViewById(listID);
                list.setAdapter(adapter);
                clickoptions(rootView);
                return rootView;
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {
                View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
                populatemovieList();
                arr=myMovies;
                listID=R.id.MovieListView;
                ArrayAdapter<comedysection> adapter = new ComedyListAdapter(getActivity());

                ListView list = (ListView) rootView.findViewById(listID);
                list.setAdapter(adapter);
                clickoptions(rootView);
                return rootView;
            }
            else
            {
                View rootView = inflater.inflate(R.layout.fragment_edu, container, false);
                populateeduList();
                arr=myEdu;
                listID=R.id.EduListView;
                ArrayAdapter<comedysection> adapter = new ComedyListAdapter(getActivity());
                ListView list = (ListView) rootView.findViewById(listID);
                list.setAdapter(adapter);
                clickoptions(rootView);
                return rootView;
            }

        }
        private void populatemovieList() {
            if(myMovies.isEmpty()==false)
                return;
            myMovies.add(new comedysection("Dangal|Trailer", R.drawable.dangal, "https://www.youtube.com/watch?v=x_7YlGv9u1g","Dangal is an extraordinary true story based on the life of Mahavir Singh and his two daughters, Geeta and Babita Phogat. The film traces the inspirational journey of a father who trains his daughters to become world class wrestlers. "));
            myMovies.add(new comedysection("Dr. Strange|Trailer", R.drawable.strange, "https://www.youtube.com/watch?v=HSzx-zryEgM","See Marvel's 'Doctor Strange,' in theaters November 4, 2016."));
            myMovies.add(new comedysection("Logan|Trailer", R.drawable.logan, "https://www.youtube.com/watch?v=Div0iP65aZo","Cast: Hugh Jackman, Patrick Stewart, Richard E. Grant, Boyd Holbrook, Stephen Merchant, Dafne Keen Directed by James Mangold"));
            myMovies.add(new comedysection("Raees|Trailer", R.drawable.raees, "https://www.youtube.com/watch?v=8iv3ksZs0hk","Raees Teaser | Shah Rukh Khan I Nawazuddin Siddiqui I Mahira Khan"));
            myMovies.add(new comedysection("Justice League|Trailer", R.drawable.jl, "https://www.youtube.com/watch?v=fIHH5-HVS9o","Fueled by his restored faith in humanity and inspired by Superman's selfless act, Bruce Wayne enlists the help of his newfound ally, Diana Prince, to face an even greater enemy."));
            myMovies.add(new comedysection("Wonder Woman|Trailer", R.drawable.wonderwoman, "https://www.youtube.com/watch?v=Tgk_63b-Mrw","An Amazon princess leaves her island home to explore the world, and becomes the greatest of its heroes."));
        }
        private void populateeduList() {
            if(myEdu.isEmpty()==false)
                return;
            myEdu.add(new comedysection("Learn Python in 20 Minutes|Trailer", R.drawable.python, "https://www.youtube.com/watch?v=RcvXrQ2G-FA","Dangal is an extraordinary true story based on the life of Mahavir Singh and his two daughters, Geeta and Babita Phogat. The film traces the inspirational journey of a father who trains his daughters to become world class wrestlers. "));
            myEdu.add(new comedysection("Learn Android", R.drawable.android, "https://www.youtube.com/watch?v=FUbcoQ-8kRQ","Learn everything you need to know to get started building Android apps with the Android 5 SDK and Google's Android Studio IDE. Starting with a brief look at Android's history."));
            myEdu.add(new comedysection("Neural Networks", R.drawable.ann, "https://www.youtube.com/watch?v=Ih5Mr93E-2c","Neural Networks - A biologically inspired model. The efficient backpropagation learning algorithm. Hidden layers."));
            myEdu.add(new comedysection("Java Tutorial", R.drawable.java, "https://www.youtube.com/watch?v=WPvGqX-TXP0","In this Java programming Tutorial I'll teach you all of the core knowledge needed to write Java code in 30 minutes. This is the most popular request from everyone."));
            myEdu.add(new comedysection("C++ Tutorial", R.drawable.cpp, "https://www.youtube.com/watch?v=Rub-JsjMhWY","Get the Cheat Sheet Here : http://goo.gl/OpJ209"));
            myEdu.add(new comedysection("HTML Tutorial", R.drawable.html, "https://www.youtube.com/watch?v=Ggh_y-33Eso","In this tutorial I show how to use 50 different tags in HTML. I then give an example of each. This video was done because of a dare and you'll either love it or hate it. I hope you love it of course. "));
        }
        private void populatecomedyList() {
            if(myComedy.isEmpty()==false)
                return;
            myComedy.add(new comedysection("HONEST COLLEGE PLACEMENTS", R.drawable.placement, "https://www.youtube.com/watch?v=0ObMUqtZcX0","What would happen if all college students answered the questions they were asked truthfully!"));
            myComedy.add(new comedysection("TVF Rowdies 9", R.drawable.rowdies, "https://www.youtube.com/watch?v=8sgYXNwNLXg","Check Out the “Rowdies 9 Sab Q-tiyapa hai” video on TVF Qtiyapa. Enjoy Watching..."));
            myComedy.add(new comedysection("INGLORIOUS SENIORS", R.drawable.senios, "https://www.youtube.com/watch?v=DglciBwGIHk","(College Q-tiyapa & The Viral Fever are registered trademarks of TVF Media Pvt. Ltd.)"));
            myComedy.add(new comedysection("AIB: Honest Diwali", R.drawable.diwali, "https://www.youtube.com/watch?v=rKDW1of2TOs","AIB takes an honest look at one of India's favourite festivals."));
            myComedy.add(new comedysection("Honest Engineering Viva", R.drawable.viva, "https://www.youtube.com/watch?v=dCY-jodFIMM","We do not intend to harm the feelings of any student,teacher,faculty or any part of the society through the video.Any resemblance to any teacher/student/samosewala is purely co-incidental."));
            myComedy.add(new comedysection("AIB : Congress vs BJP", R.drawable.modi, "https://www.youtube.com/watch?v=qStXxdRJtms","General elections are a year away, politics is on everyone's mind. Except the level of Indian political discourse is something that would make Gandhiji turn in his grave."));
        }
        private void clickoptions(View rootView) {
            ListView list = (ListView) rootView.findViewById(listID);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View viewClicked,
                                        int position, long id) {
                    comedysection clicked = arr.get(position);
                    String message = "Install the YouTube App";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(clicked.getUrl()));
                    intent.setPackage("com.google.android.youtube");
                    PackageManager manager = getActivity().getPackageManager();
                    List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                    if (infos.size() > 0) {
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        private class ComedyListAdapter extends ArrayAdapter<comedysection> {
            //LayoutInflater inflater;

            public ComedyListAdapter(Context context) {
                super(context, R.layout.item_view,arr);
            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Make sure we have a view to work with (may have been given null)
                View itemView = convertView;
                if (itemView == null) {
                    itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_view, parent, false);
                }
                // Find the item to work with.
                comedysection current = arr.get(position);
                // Fill the view
                ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
                imageView.setImageResource(current.getIconID());
                // Name:
                TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
                makeText.setText(current.getName());
                // Description:
                TextView condionText = (TextView) itemView.findViewById(R.id.item_txtCondition);
                condionText.setText(current.getDescription());
                return itemView;
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Comedy";
                case 1:
                    return "Movies";
                case 2:
                    return "Educational";
            }
            return null;
        }
    }
}

package com.example.shane.assignment4shanecoakley;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


/**
 * Main Activity for Assignment
 * Taken from assignment 3 answer provided by Colette Kirwan
 */
public class MainActivity extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private TabPageAdapter mMyPagerAdapter;
    Intent intent, chooser;
    String email_body;
    // SectionsPagerAdapter mSectionsPagerAdapter;

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
        /** final mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
         final TabPageAdapter myadapter = new TabPageAdapter(getSupportFragmentManager());

         // Set up the ViewPager with the sections adapter.
         mViewPager = (ViewPager) findViewById(R.id.container);
         mViewPager.setAdapter(myadapter); **/

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setupWithViewPager(mViewPager);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());



        final ViewPager mypager = (ViewPager)findViewById(R.id.pager);
        final TabPageAdapter myadapter = new TabPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        mypager.setAdapter(myadapter);
        tabLayout.setupWithViewPager(mypager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            /**
             * Launches Email function when button is selected
             * @param view
             */
            @Override
            public void onClick(View view) {

                String email_body = new StringBuilder().append("Apologies for brevity and typos, sent from my phone").
                        append("\n").append("\n").toString();

                intent = new Intent(Intent.ACTION_SEND);
// Passing the data to the email app
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(intent.EXTRA_EMAIL, new String[]{"pizzaspecial.dcu.ie"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "QUERY: ");
                intent.putExtra(Intent.EXTRA_TEXT, email_body);

                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Send Order");

                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(chooser);
                }




            }
        });



    }


    /**
     * Once the app is launched the main menu is launched
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles items selected from the action bar
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.



        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,Notification2.class));
            return true;
        }
        else if(id ==R.id.notification){
           startActivity(new Intent(this,Notification1.class));
            return true;
        }


       /** else if(id ==R.id.share){
            startActivity(new Intent(this,Notification3.class));
            return true;
        }**/
        return super.onOptionsItemSelected(item);
    }




}

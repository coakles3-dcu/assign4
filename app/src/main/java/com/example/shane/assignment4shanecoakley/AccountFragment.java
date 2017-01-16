package com.example.shane.assignment4shanecoakley;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.EditText;





public  class AccountFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {


    public AccountFragment() {


    }






    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }



    @Override

    public void onCreatePreferences(Bundle bundle, String key) {



    }



    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        Preference preference = findPreference(key);
        if(preference instanceof EditTextPreference)
        {
            EditTextPreference editTextPref = (EditTextPreference) preference;

            if( preference.getKey().equals("cust_password")){
                preference.setSummary(editTextPref.getText().replaceAll(".","*"));
            }

            else if(!preference.getKey().equalsIgnoreCase("pass"))
            {

                preference.setSummary(editTextPref.getText());

            }


        }
    }

}

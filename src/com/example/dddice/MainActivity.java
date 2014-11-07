package com.example.dddice;

import android.os.Bundle;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import com.DiceApp.dddice.R;

public class MainActivity extends Activity {
	public static boolean sound = true;
	ActionBar.Tab tab1, tab2, tab3, tab4, tab5, tab6, tab7;
	Fragment fragmentTab1 = new FragmentTab1();
	Fragment fragmentTab2 = new FragmentTab2();
	Fragment fragmentTab3 = new FragmentTab3();
	Fragment fragmentTab4 = new FragmentTab4();
	Fragment fragmentTab5 = new FragmentTab5();
	Fragment fragmentTab6 = new FragmentTab6();
	Fragment fragmentTab7 = new FragmentTab7();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //getActionBar().setTitle("D&D Dice App");   
        //getSupportActionBar().setTitle("Matt's App");  // provide compatibility to all the versions
        
        tab1 = actionBar.newTab().setText("d4");
        tab2 = actionBar.newTab().setText("d6");
        tab3 = actionBar.newTab().setText("d8");
        tab4 = actionBar.newTab().setText("d10");
        tab5 = actionBar.newTab().setText("d12");
        tab6 = actionBar.newTab().setText("d20");
        tab7 = actionBar.newTab().setText("d100");
        
        tab1.setTabListener(new MyTabListener(fragmentTab1));
        tab2.setTabListener(new MyTabListener(fragmentTab2));
        tab3.setTabListener(new MyTabListener(fragmentTab3));
        tab4.setTabListener(new MyTabListener(fragmentTab4));
        tab5.setTabListener(new MyTabListener(fragmentTab6));
        tab6.setTabListener(new MyTabListener(fragmentTab7));
        tab7.setTabListener(new MyTabListener(fragmentTab5));
        
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);
        actionBar.addTab(tab5);
        actionBar.addTab(tab6);
        actionBar.addTab(tab7);
        
       
    }
    
}

package com.example.technical_assistant;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.technical_assistant.databinding.ActivityMainBinding;
import com.example.technical_assistant.domain.Company;
import com.example.technical_assistant.domain.User;
import com.example.technical_assistant.services.company_listener.DataCompany;
import com.example.technical_assistant.services.company_listener.HandlerCompanyListener;
import com.example.technical_assistant.services.company_listener.ObserverCompany;
import com.example.technical_assistant.services.companyes_list_listener.DataCompanyList;
import com.example.technical_assistant.services.companyes_list_listener.ObserverCompanyList;
import com.example.technical_assistant.services.sqlite.DatabaseHelper;
import com.example.technical_assistant.services.user_listener.DataUser;
import com.example.technical_assistant.services.user_listener.HandlerUserListener;
import com.example.technical_assistant.services.user_listener.ObserverUser;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ObserverUser, ObserverCompany, ObserverCompanyList {
	
	private AppBarConfiguration mAppBarConfiguration;
	private ActivityMainBinding binding;
	public User user;
	public Company company;
	public List<Company> companyList;
	DatabaseHelper dbHelper = new DatabaseHelper(this);
	HandlerUserListener listener = new HandlerUserListener();
	HandlerCompanyListener companyListener = new HandlerCompanyListener();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		GlobalLinkMainController.setMainActivity(this);
		if (dbHelper.getUser().getId() == 0) {
			user = null;
		} else {
			user = dbHelper.getUser();
		}
		
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		setSupportActionBar(binding.appBarMain.toolbar);
		binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		DrawerLayout drawer = binding.drawerLayout;
		NavigationView navigationView = binding.navView;
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder(
				R.id.nav_home, R.id.nav_documentation, R.id.nav_settings, R.id.add_watch_WorkProjectors)
				.setOpenableLayout(drawer)
				.build();
		
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration)
				|| super.onSupportNavigateUp();
	}
	
	@Override
	public void updateUser(DataUser dataUser) {
		this.user = dataUser.getUser();
	}
	
	@Override
	public void updateCompany(DataCompany dataCompany) {
		this.company = dataCompany.getCompany();
	}
	
	@Override
	public void updateCompanyList(DataCompanyList dataCompanyList) {
		this.companyList = dataCompanyList.getCompanyList();
	}
}
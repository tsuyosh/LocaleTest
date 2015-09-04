package com.github.tsuyosh.localetest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.localeSettingButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		updateLocaleText();
	}

	private void updateLocaleText() {
		Locale locale = getResources().getConfiguration().locale;
		StringBuilder sb = new StringBuilder();
		sb.append("country:").append(locale.getCountry()).append("\n");
		sb.append("displayCountry:").append(locale.getDisplayCountry()).append("\n");
		sb.append("ISO3Country:").append(locale.getISO3Country()).append("\n");

		sb.append("language:").append(locale.getLanguage()).append("\n");
		sb.append("displayLanguage:").append(locale.getDisplayLanguage()).append("\n");
		sb.append("ISO3Language:").append(locale.getISO3Language()).append("\n");

		sb.append("displayName:").append(locale.getDisplayName()).append("\n");

		sb.append("variant:").append(locale.getVariant()).append("\n");
		sb.append("displayVariant:").append(locale.getDisplayVariant()).append("\n");
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			sb.append("displayScript:").append(locale.getDisplayScript()).append("\n");
		}
		((TextView) findViewById(R.id.localeText)).setText(sb.toString());
	}

	@Override
	protected void onDestroy() {
		findViewById(R.id.localeSettingButton).setOnClickListener(null);
		super.onDestroy();
	}
}

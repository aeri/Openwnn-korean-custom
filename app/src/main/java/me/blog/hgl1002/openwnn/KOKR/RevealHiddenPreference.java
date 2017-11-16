package me.blog.hgl1002.openwnn.KOKR;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.widget.Toast;

import me.blog.hgl1002.openwnn.R;

public class RevealHiddenPreference extends Preference {

	public static final int REVEAL = 10;
	public static final int ALERT = 7;

	Context context;
	int clickCount;

	public RevealHiddenPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
	}

	@Override
	protected void onClick() {
		clickCount++;
		if(clickCount >= REVEAL) {
			persistBoolean(true);
		} else if(clickCount >= ALERT) {
			String message = String.format(context.getString(R.string.preference_reveal_hidden_msg), REVEAL - clickCount);
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		}
		super.onClick();
	}
}

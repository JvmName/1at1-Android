package org.oneat1.android.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.oneat1.android.R;
import org.oneat1.android.util.TypefaceTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by parthpadgaonkar on 1/4/17.
 */

public class ScheduleFragment extends Fragment {

    @BindView(R.id.schedule_datetime) TypefaceTextView scheduleDatetime;

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_schedule, container, false);
        ButterKnife.bind(this, view);
        Calendar instance = GregorianCalendar.getInstance();
        instance.set(2017, 0, 21, 13, 0);
        instance.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy / h:mm aa zzz", Locale.getDefault());
        formatter.setTimeZone(TimeZone.getDefault());
        SpannableStringBuilder ssb = new SpannableStringBuilder(getString(R.string.schedule_text, formatter.format(new Date(instance.getTimeInMillis()))));
        ssb.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.darkBlue)), 13, 15, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        scheduleDatetime.setText(ssb);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.schedule_share, R.id.schedule_facebook, R.id.schedule_instagram, R.id.schedule_twitter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.schedule_share:
                break;
            case R.id.schedule_facebook:
                break;
            case R.id.schedule_instagram:
                break;
            case R.id.schedule_twitter:
                break;
        }
    }
}

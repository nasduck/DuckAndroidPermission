package com.nasduck.duckpermission.demo.permissions;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nasduck.duckpermission.DuckPermission;
import com.nasduck.duckpermission.demo.R;
import com.nasduck.duckpermission.demo.base.BaseActivity;
import com.nasduck.duckpermission.demo.utils.ToastUtils;
import com.nasduck.duckpermission.result.code.DuckResultCode;
import com.nasduck.duckpermission.result.listener.OnPermissionResultListener;
import com.nasduck.duckpermission.result.strategy.impl.PermissionResultCustomStrategy;

public class CalendarActivity extends BaseActivity implements
        OnPermissionResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void onReadCalendarClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestReadCalendar()) {
            Toast.makeText(this, "Already granted read calendar permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void onWriteCalendarClick(View view) {
        if (DuckPermission.getInstance(this)
                .setResultStrategy(new PermissionResultCustomStrategy(this))
                .requestWriteCalendar()) {
            Toast.makeText(this, "Already granted write calendar permission", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsResultGrant(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CALENDAR:
                ToastUtils.showToast(this, "Read Calendar Granted");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CALENDAR:
                ToastUtils.showToast(this, "Write Calendar Granted");
                break;
        }
    }

    @Override
    public void onPermissionsResultDenied(int requestCode) {
        switch (requestCode) {
            case DuckResultCode.RESULT_CODE_READ_CALENDAR:
                ToastUtils.showToast(this, "Read Calendar Denied");
                break;
            case DuckResultCode.RESULT_CODE_WRITE_CALENDAR:
                ToastUtils.showToast(this, "Write Calendar Denied");
                break;
        }
    }
}

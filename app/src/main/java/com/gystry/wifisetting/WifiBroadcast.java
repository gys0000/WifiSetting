package com.gystry.wifisetting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

/**
 * 网络变化的广播
 */
public class WifiBroadcast extends BroadcastReceiver {
    private IntentFilter filter;
    private Context context;
    private WifiStateSchangeListener listener;

    public WifiBroadcast(Context context) {
        this.context = context;
        filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);//WiFi开关变化的广播
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);//热点扫描结果通知广播
        filter.addAction(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION);//—热点连接结果通知广播
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);  //—网络状态变化广播（与上一广播协同完成连接过程通知）
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(this, filter);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (null != listener) {
            listener.onWifiChange(intent);
        }
    }

    public void setWifiStateChangeListener(WifiStateSchangeListener listener) {
        this.listener = listener;
    }

    public interface WifiStateSchangeListener {
        void onWifiChange(Intent action);
    }
}

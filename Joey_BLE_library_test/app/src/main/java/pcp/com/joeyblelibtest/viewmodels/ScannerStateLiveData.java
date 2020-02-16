package pcp.com.joeyblelibtest.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;

public class ScannerStateLiveData extends LiveData<ScannerStateLiveData> {
    private static final String TAG = "ScannerStateLiveData";
    private boolean mScanningStarted;
    private boolean mHasRecords;
    private boolean mBluetoothEnabled;  //BluetoothEnabled 有無開啟
    private boolean mLocationEnabled;  //LocationEnabled 有無開啟

    ScannerStateLiveData(final boolean bluetoothEnabled,
                         final boolean locationEnabled) {  // ScannerViewModel會用到他
        Log.v(TAG, "403 001 constructor");
        mScanningStarted = false;
        mBluetoothEnabled = bluetoothEnabled;
        mLocationEnabled = locationEnabled;
        postValue(this);  // Posts a task to a main thread to set the given value.
    }

    // ScannerViewModel會用到他
    void refresh() {
        postValue(this);
    }

    // ScannerViewModel會用到他
    void scanningStarted() {
        mScanningStarted = true;
        postValue(this);
    }

    // ScannerViewModel會用到他
    void scanningStopped() {
        mScanningStarted = false;
        postValue(this);
    }

    // ScannerViewModel會用到他
    void bluetoothEnabled() {
        mBluetoothEnabled = true;
        postValue(this);
    }

    // ScannerViewModel會用到他
    synchronized void bluetoothDisabled() {
        mBluetoothEnabled = false;
        mHasRecords = false;
        postValue(this);
    }

    // ScannerViewModel會用到他
    void setLocationEnabled(final boolean enabled) {
        mLocationEnabled = enabled;
        postValue(this);
    }

    // ScannerViewModel會用到他, 用了三次
    void recordFound() {
        mHasRecords = true;
        postValue(this);
    }

    // ScannerViewModel會用到他, 用了2次
    boolean isScanning() {
        return mScanningStarted;
    }

    // ScannerActivity 會用到他
    public boolean hasRecords() {
        return mHasRecords;
    }

    // ScannerActivity, ScannerViewModel會用到他
    public boolean isBluetoothEnabled() {
        return mBluetoothEnabled;
    }

    // 無人使用
    public boolean isLocationEnabled() {
        return mLocationEnabled;
    }

    // ScannerActivity, ScannerViewModel會用到他
    public void clearRecords() {
        mHasRecords = false;
        postValue(this);
    }
}

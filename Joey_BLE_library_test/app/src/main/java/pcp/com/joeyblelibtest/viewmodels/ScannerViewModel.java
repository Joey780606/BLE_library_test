package pcp.com.joeyblelibtest.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class ScannerViewModel extends AndroidViewModel {

    private final DevicesLiveData mDevicesLiveData;  // 包含Device的List的MutableLiveData
    private final ScannerStateLiveData mScannerStateLiveData;  // 包含Scan state的MutableLiveData
    public ScannerViewModel(final Application application) {
        super(application);
    }
}

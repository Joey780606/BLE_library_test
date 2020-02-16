package pcp.com.joeyblelibtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;
import pcp.com.joeyblelibtest.viewmodels.ScannerViewModel;

import android.os.Bundle;

public class ScannerActivity extends AppCompatActivity {

    private ScannerViewModel mScannerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        ButterKnife.bind(this);

        // Create view model containing utility methods for scanning
        //mScannerViewModel = ViewModelProviders.of(this).get(ScannerViewModel.class);
        mScannerViewModel = new ViewModelProvider(this).get(ScannerViewModel.class);
        mScannerViewModel.getScannerState().observe(this, this::startScan);

    }
}

package ph.coreproc.android.barcore_scanner_demo.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.google.zxing.Result;

import butterknife.InjectView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import ph.coreproc.android.barcore_scanner_demo.R;
import ph.coreproc.android.barcore_scanner_demo.utils.UiUtil;

/**
 * Created by johneris on 6/1/2015.
 */
public class BarcodeScannerActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    public static final String TAG = "BarcodeScannerActivity";

    @InjectView(R.id.tvBarcodeFormat)
    TextView tvBarcodeFormat;

    @InjectView(R.id.tvBarcodeValue)
    TextView tvBarcodeValue;

    @InjectView(R.id.scannerView)
    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_barcode_scanner;
    }

    private void initialize() {

    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String barcodeFormat = rawResult.getBarcodeFormat().toString();
        String barcodeValue = rawResult.getText();

        tvBarcodeFormat.setText(barcodeFormat);
        tvBarcodeValue.setText(barcodeValue);

        UiUtil.showMessageDialog(getSupportFragmentManager(), barcodeFormat, barcodeValue);

        scannerView.startCamera();
    }

}

package progmobile.coursenligne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PdfActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView w=new WebView(this);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("https://docs.google.com/gview?embedded=true&url="+"http://www.pdf995.com/samples/pdf.pdf");
        setContentView(w);

    }
}

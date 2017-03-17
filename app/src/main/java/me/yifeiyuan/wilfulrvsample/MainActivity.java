package me.yifeiyuan.wilfulrvsample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private android.widget.TableLayout tbl;
    private android.support.v4.view.ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vp = (ViewPager) findViewById(R.id.vp);
        this.tbl = (TableLayout) findViewById(R.id.tbl);
    }
}

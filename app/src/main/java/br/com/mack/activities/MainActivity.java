package br.com.mack.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;

import br.com.mack.R;
import br.com.mack.manager.ConceptsManager;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ConceptsManager manager = new ConceptsManager();
        manager.productCall();
    }
}

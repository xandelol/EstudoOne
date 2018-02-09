package xandao.com.estudoone;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageLogo;
    ImageView imageSearch;
    LinearLayout linearSearchBar;
    BottomNavigationView bottomBar;
    private boolean isSearch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLogo = (ImageView) findViewById(R.id.main_screen_logo);
        imageSearch = (ImageView) findViewById(R.id.main_screen_search_button);
        linearSearchBar = (LinearLayout) findViewById(R.id.main_screen_search_bar);
        bottomBar = (BottomNavigationView) findViewById(R.id.main_screen_bottom_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomBar);
        bottomBar.setSelectedItemId(R.id.bottom_events);
    }

    public void showSearchBar(View v) {
        if (!isSearch) {
            imageLogo.animate().translationY(-200);
            imageSearch.setVisibility(View.GONE);
            linearSearchBar.setVisibility(View.VISIBLE);
            isSearch = true;
        }
    }

    public void hideSearchBar(View v){
        imageLogo.animate().translationY(0);
        imageSearch.setVisibility(View.VISIBLE);
        linearSearchBar.setVisibility(View.GONE);
        isSearch = false;
    }

    @Override
    public void onBackPressed() {
        if (isSearch) {
            imageLogo.animate().translationY(0);
            imageSearch.setVisibility(View.VISIBLE);
            linearSearchBar.setVisibility(View.GONE);
            isSearch = false;
        } else {
            super.onBackPressed();
        }
    }
}

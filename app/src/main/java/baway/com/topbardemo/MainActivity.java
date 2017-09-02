package baway.com.topbardemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * 制作UI模板：
 * 设计一个TopBar模板。学习这种设计思路和模式。
 * <p>
 * 步骤：
 * 1、设计需要的属性（自定义属性）
 * 2、实现一个我们的"View"
 * 3、引用我们的View
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Topbar topbar = (Topbar) findViewById(R.id.topbar);
        assert topbar != null;
        topbar.setOnTopbarClickListener(new Topbar.topbarClickListener() {
            @Override
            public void leftButtonClick() {
                Toast.makeText(MainActivity.this, "leftButton : Back", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightButtonClick() {
                Toast.makeText(MainActivity.this, "rightButton : More", Toast.LENGTH_SHORT).show();
            }
        });

        //topbar.setLeftIsVisiable(false);

    }
}

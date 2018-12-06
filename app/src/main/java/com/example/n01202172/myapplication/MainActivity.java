package com.example.n01202172.myapplication;

// ALL IMPORT FOR REQUIRED WIDGETS AS WELL AS TOAST
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // A USER CAN ALSO SET THEME USING : setTheme(R.style.ANYTHEME);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // CUSTOMIZATION OF fab COULD BE DONE IN XML SUCH AS SETTING UP POSITION IN LEFT OR RIGHT IN activity_main.xml

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // setOnClickListener DOES A CALLBACK AND INVOKES A VIEW. IN OTHER CASE USER CAN USE "INTENT" TO SWITCH ACTIVITIES BY WRITING CODE INSIDE onclick METHOD
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "ACTION VIEW SAMPLE", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    // THIS INFLATES THE MENU AND ADDS ACTION TO THE ACTION BAR IF IT IS THERE.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // PURPOSE IS TO HANDLE ACTION BAR ITEM WHICH WILL AUTOMATICALLY HANDLE THE ACTIONS/CLICK AS LONG AS MENTIONED UNDER A PARENT ACTIVITY IN AndroidManifest.xml

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // SWITCH STATEMENT FOR TESTING ACTION USING A TOAST MESSAGE
        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this,"Item 1 Selected",Toast.LENGTH_SHORT).show();

            case R.id.action_settings:
                Toast.makeText(this,"Option 1 Selected",Toast.LENGTH_SHORT).show();

            case R.id.action_settings2:
                Toast.makeText(this,"Option 2 Selected",Toast.LENGTH_SHORT).show();

            case R.id.subitem1:
                Toast.makeText(this,"SubItem 1 Selected",Toast.LENGTH_SHORT).show();

            case R.id.subitem2:
                Toast.makeText(this,"SubItem 2 Selected",Toast.LENGTH_SHORT).show();
        }

        //SIMPLIFIABLE IF STATEMENT

        if (id == R.id.action_settings) {
            return true;
        }

        // RETURNS BOOLEAN VALUE
        return super.onOptionsItemSelected(item);
    }
}

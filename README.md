# Project Topic
                                                       Action Menu
                                          
**An example demonstrating Action menu and view:**



![actionmenu view](https://user-images.githubusercontent.com/42980862/48924843-9e16ec00-ee8a-11e8-84d2-fd185dec2fe4.png)



# Introduction

**ActionMenuView** is an introduction of a progression of menu alternatives as a View. It gives a few best dimension choices as activity catches while spilling remaining alternatives over as things in an overflow menu. This enables applications to display packs of activities inline with explicit or rehashing content. ActionMenuView belongs to Maven artifact ```com.android.support:appcompat-v7:28.0.0-alpha1.```


## **Working**

It is one the most important element design as it helps users to understand specific functioning of the application. Action menu is the operation which is provoked on invoking any menu item. Every attributes of action whilst any action is provoked for any specific menu is defined in .xml file. Client Framework understands as well as handles the actions of menu based on action attributes. Some other action attributes that Client Framework handles are **action-command,action-type,action-value**. So depending on any of these action attributes are passed,the operation is invoked.

The toolbar bar also known to be **"Action Bar"** is spoken to as of Android 5.0 by means of the Toolbar view. It tends to be openly positioined into our layout file. It can show the icon,title, actions which can be invoked, extra perspectives and other intuitive things. It can likewise be utilized for route in our application. 

Before Android 5.0 the area of the toolbar (actionbar) was hard coded to the highest point of the action.Plus, its possible to disable the old theme in toolbar to which default Android theme is already equipped.

## **Usage**

Class: ```android.support.v7.widget.ActionMenuView```

Method: ```java.lang.Object```



# History

The very first toolabr was introduced at API level 21 in Android 5.0. Before user goes with appcompat -v7 support library in order to use the toolbar with past releases from Android. To enable this feature, user had to add a compile dependency in gradle Build file which is 
 com.android.support:appcompat which actually looks like this in Gradle Build File: compile `com.android.support:appcompat-v7:22.2.0` with an appropriate version.
 
 On other side, applications used option menu before, whose target SDK was less than API 11 if and only if they had a button on their device. This option menu is displayed if user clicks the "option" button. Toolbar plays vital role for option menu as it is visible on Action Bar whereas the other options are available on the user call. In this case, user would not be able to acknowledge if any options are accessible in the application.

# Major Method/Attribute

###### Attributes Used by me
 
 ``` android:id ``` most basic xml attribute to assign name to the view which will be later retrieved by Activity.
 
For setting up compatible theme, change parent theme under `values/style.xml` same way I did in                                   `<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">`
  
 
In order to add support action bar items, attribute  ```app:showAsAction="ifRoom"``` was used in ```res/menu_main.xml```

 
For adding items as well as handling clicks, inflater is used in ```onCreateOptionsMenu```method  
```
getMenuInflater().inflate(R.menu.menu_main, menu);
 return true;
 ```
        
   
Also in order to customize color of the vector asset icon could be performed from `drawable/ic_history_black_24dp.xml` just like ```android:fillColor="#FF000000"```

 
For expansion or addition of items in actionbar, using `app:showAsAction="never"`,

```
<menu>
            <item android:id="@+id/subitem1"
                android:title="SubItem1"
                app:showAsAction="never"/>
            <item android:id="@+id/subitem2"
                android:title="SubItem2"
                app:showAsAction="never"/>

  </menu>
  ```

which actually is nested inside an the storage `<item>` (see code for detail!)
  
  
To check whether the our icon ( in my case is ic_history_black_24dp whose id is option1) is selected or not could be known in method ```onOptionsItemSelected``` where switch statement was used with attribute ```android.R.id.option1```

  
For handling clicks, method ```onOptionsItemSelected()``` is used.


###### Some other useful attributes

class android.view.View

| Attribute |  Purpose |
| --- | --- |
| android:alpha | It's an alpha property of the view as whose value stands between 0 (Transparent) and 1 (Opaque) |
| android:autofillHints | Useful for autoservice in order to fill appropriate data |
| android:clickable | Defines invoking of view after click events |
| android:isScrollContainer | It will set the view as a scrolling container which in other words says of resizing to shrink the window to provide space for input data |
| android:rotation | Rotation of view in terms of degrees. |
| android:scrollbarStyle | Manages scrollbar size and position |

  
 

# Example Code

A tested and working project is uploaded under repository ```ActionMenu-view```.


# Code Demonstration

Files to be referred:

### ```MainActivity.java```

```
package com.example.n01202172.myapplication;

###### // ALL IMPORT FOR REQUIRED WIDGETS AS WELL AS TOAST
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
            
         // LENGTH_SHORT FOR DISPLAYING SHORT DURATION MESSAGE (FUNCTIONS SIMILAR TO TOAST)
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
```
### ```menu_main.xml```
 ```
 <menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.example.n01202172.myapplication.MainActivity">

    <!-- WHERE ID = option1 IS MY VECTOR ASSET IN MY DRAWABLE DIRECTORY -->
    
    <item
        android:title="item"
        android:id="@+id/option1"
        android:icon="@drawable/ic_history_black_24dp"
        app:showAsAction="ifRoom"/>

    <!-- WHERE action_settings IS THE FIRST OPTION IN MY ITEM  -->
    
    <item
        android:id="@+id/action_settings"
        android:orderInCategory="100"
        android:title="Option1"
        app:showAsAction="never" />

    <!-- WHERE action_settings2 IS THE SECOND OPTION WITH TWO OTHER CHILD WITH ID subitem1 and subitem2  -->
    
    <item
        android:id="@+id/action_settings2"
        android:orderInCategory="100"
        android:title="Option2"
        app:showAsAction="never">
        <menu>
            <item android:id="@+id/subitem1"
                android:title="SubItem1"
                app:showAsAction="never"/>

            <item android:id="@+id/subitem2"
                android:title="SubItem2"
                app:showAsAction="never"/>

        </menu>
    </item>


</menu>

```

# Reference

https://developer.android.com/reference/android/support/v7/widget/ActionMenuView
https://developer.xamarin.com/api/type/Android.Widget.ActionMenuView/

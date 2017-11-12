package jaykishannimbalkar.geometry;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private ListView listView;
    private ArrayList<String> nameArray;
    private ArrayList<Integer> imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameArray = new ArrayList<>();
        nameArray.add("Rectangle");
        nameArray.add("Triangle");
        nameArray.add("Squqre");
        nameArray.add("Parallelogram");
        nameArray.add("Trapezoid");
        nameArray.add("Pythagorean Theorem");
        nameArray.add("Circle");
        nameArray.add("Cube");
        nameArray.add("Cone");

        imageArray = new ArrayList<>();
        imageArray.add(R.drawable.rectangle);
        imageArray.add(R.drawable.triangle);
        imageArray.add(R.drawable.square);
        imageArray.add(R.drawable.parallogram);
        imageArray.add(R.drawable.linear);
        imageArray.add(R.drawable.linear);
        imageArray.add(R.drawable.linear);
        imageArray.add(R.drawable.linear);
        imageArray.add(R.drawable.linear);


        ListViewAdapter listViewAdapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Fragment f = null;
                if (position == 0) {
                    f = new Rectangle();
                    //Toast.makeText(MainActivity.this, "selectedItem=" + position, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    f = new Triangle();
                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    f = new Square();
                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    f = new Parallogram();
                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }else if (position == 4) {
                    f = new Trapezoid();
                    Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                }



                if (f != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, f)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("")
                .setMessage("Go To Home Screen?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                       // Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();

                    }
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START))
                {
                    drawer.closeDrawer(GravityCompat.START);

                } else {
                   // super.onBackPressed();
                }
               // Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Fragment f = null;

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            f = new Share();

            //return true;
        }
        if (f != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.container, f)
                    .addToBackStack(null)
                    .commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment f = null;


        if (id == R.id.rectangle) {
            f = new Rectangle();
            Toast.makeText(this, "Rectangle", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.triangle) {
            f = new Triangle();
            Toast.makeText(this, "Triangle", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.square) {
            f = new Square();
            Toast.makeText(this, "Square", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.parallogram) {
            f = new Parallogram();
            Toast.makeText(this, "Parallogram", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.trapezoid) {
            f = new Trapezoid();
            Toast.makeText(this, "Trapezoid", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.nav_share) {
            f = new Share();
        }



        if (f != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.container, f)
                    .addToBackStack(null)
                    .commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class ListViewAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return nameArray.size();
        }

        @Override
        public Object getItem(int position) {
            return nameArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View singleview, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.row_layout, null);

            TextView textSingleItem = (TextView) view.findViewById(R.id.item_name);
            textSingleItem.setText(nameArray.get(position));

            ImageView imageView = (ImageView) view.findViewById(R.id.item_icon);
            imageView.setImageResource(imageArray.get(position));

            return view;
        }
    }


}

package jaykishannimbalkar.geometry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 10/5/2017.
 */

public class Share extends Fragment
{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.share,container,false);
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Read android Share Function at https://play.google.com/store/apps/details?id=colorsfx.android.smart.course&h1=en");
        intent.putExtra(Intent.EXTRA_SUBJECT,"SMART ANDROID COURSE");
        startActivity(Intent.createChooser(intent,"Share via"));

        return v;
    }


}

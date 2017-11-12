package jaykishannimbalkar.geometry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class Triangle extends Fragment {

    Double num_1,num_2,a=0.5,ans;
    String msg1,msg2;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.triangle,container,false);
        final EditText editText1=(EditText)v.findViewById(R.id.num1);
        final EditText editText2=(EditText)v.findViewById(R.id.num2);
        Button button=(Button)v.findViewById(R.id.btn);
        final TextView textView=(TextView)v.findViewById(R.id.result);
        TextView title=(TextView)v.findViewById(R.id.txt);
        Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.blink);
        title.startAnimation(animation);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                msg1=editText1.getText().toString();
                msg2=editText2.getText().toString();
                num_1=Double.parseDouble(editText1.getText().toString());
                num_2=Double.parseDouble(editText2.getText().toString());

                ans=(a*num_1*num_2);
                textView.setText(""+Double.toString(ans));
            }
        });


        return v;
    }

}

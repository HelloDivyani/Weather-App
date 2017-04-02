package com.example.rssongira.localbird2;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rssongira.localbird2.data.Channel;
import com.example.rssongira.localbird2.data.Item;
import com.example.rssongira.localbird2.service.WeatherServiceCallback;
import com.example.rssongira.localbird2.service.YahooService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback{
  private   ImageView WeatherIconView;
    private TextView Temperature,Condition,Location;
    private EditText placeName;
    String place;
    private YahooService service;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherIconView=(ImageView)findViewById(R.id.na);
        Temperature=(TextView)findViewById(R.id.temperature);
        Condition=(TextView)findViewById(R.id.Condition);
        Location=(TextView)findViewById(R.id.location);
        placeName=(EditText)findViewById(R.id.place);





    }
    public void ok(View v)
    {
        place = placeName.getText().toString();
        if(place == null)
        {
            Toast.makeText(this,"Please Enter the location",Toast.LENGTH_LONG).show();
        }
        else
        {
            service=new YahooService(this);
            // Showing Dialog
            dialog = new ProgressDialog(this);
            dialog.setTitle("Dialog Title");
            dialog.setMessage("Loading ............");
            dialog.show();

            service.RefereshWeather(place);
        }

    }
    @Override
    public void ServiceSuccess(Channel channel) {
            dialog.hide();
        Item item =channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_"+channel.getItem().getCondition().getCode(),null,getPackageName());
        @SuppressWarnings("deprication")
        Drawable weatherIcon = getResources().getDrawable(resourceId);
        WeatherIconView.setImageDrawable(weatherIcon);
        Location.setText(service.getLocation());
        Temperature.setText(item.getCondition().getTemperature()+"  "+channel.getUnits().getTemperature());
        Condition.setText(item.getCondition().getDescription());
    }

    @Override
    public void ServiceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this,exception.getMessage(),Toast.LENGTH_LONG).show();

    }
}

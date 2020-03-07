package com.example.waterquality;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;


public class MainActivity extends AppCompatActivity
{
    private TextView tv;
    private Button btn;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final Handler handler=new Handler()
                {
                    @Override
                    public void handleMessage(Message msg)
                    {
                        if (msg.what==0x1233)//如果消息是本程序所发送的
                        {
                            StringBuilder sb=new StringBuilder();
                            sb.append("站名，时间，PH，高猛酸钾，溶解氧，总有机碳，氨氮，水质等级，断面，站点状态\n\n");
                            Gson gson=new Gson();

                            List<WaterQuality> qualityList = gson.fromJson(data, new TypeToken<List<WaterQuality>>()
                            {}.getType());
                            for (WaterQuality waterQuality : qualityList)
                            {
                                sb.append(waterQuality.getSiteName()+"    ")
                                        .append(waterQuality.getDateTime()+"    ")
                                        .append(waterQuality.getpH()+"    ")
                                        .append(waterQuality.getCODMn()+"    ")
                                        .append(waterQuality.getDO()+"    ")
                                        .append(waterQuality.getTOC()+"    ")
                                        .append(waterQuality.getNH4()+"    ")
                                        .append(waterQuality.getLevel()+"    ")
                                        .append(waterQuality.getAttribute()+"    ")
                                        .append(waterQuality.getStatus()+"    ")
                                        .append("\n\n");
                            }

                            tv.setText(sb.toString());

                        }
                    }
                };

                new Thread()
                {
                    @Override
                    public void run()
                    {

                        data = Utils.getData();
                        System.out.println("数据为："+data);

                        handler.sendEmptyMessage(0x1233);
                    }
                }.start();

            }
        });


    }
}

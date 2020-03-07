package com.example.waterquality;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils
{
    public static String getData()
    {
        //参数字符串，如果拼接在请求链接之后，需要对中文进行 URLEncode   字符集 UTF-8
        String param = "Method=SelectRealData";
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;
        PrintWriter out = null;
        String backStr=null;
        try {
            //接口地址
            String url = "http://123.127.175.45:8082/ajax/GwtWaterHandler.ashx";
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(10000);
            connection.setRequestProperty("accept", "*/*");
            //发送参数
            connection.setDoOutput(true);
            out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.flush();
            //接收结果
            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            //缓冲逐行读取
            while ( ( line = br.readLine() ) != null )
            {
                sb.append(line);
            }
            backStr=sb.toString();
            System.out.println("元数据"+backStr);
            System.out.println(backStr);


        } catch ( Exception e )
        {
            System.out.println(e);
        } finally
        {
            //关闭流
            try
            {
                if(is!=null)
                {
                    is.close();
                }
                if(br!=null)
                {
                    br.close();
                }
                if (out!=null)
                {
                    out.close();
                }
            } catch ( Exception ignored )
            {
                System.out.println(ignored);
            }
        }
        return backStr;
    }
}

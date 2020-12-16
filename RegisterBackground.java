package com.example.omsaiwashing;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RegisterBackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    RegisterBackground(Context ctx) {
        context = ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String user_name = voids[0];
        String password = voids[1];
        String fullname = voids[2];
        String gmail = voids[3];
        String contant = voids[4];
        String login_url = "https://omsai12.000webhostapp.com/register_form.php";

        try {
            URL url = new URL(login_url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")
                    +"&&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&&"+URLEncoder.encode("fullname","UTF-8")+"="+URLEncoder.encode(fullname,"UTF-8")+"&&"+URLEncoder.encode("gmail","UTF-8")+"="+URLEncoder.encode(gmail,"UTF-8")+"&&"+URLEncoder.encode("contant","UTF-8")+"="+URLEncoder.encode(contant,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onPostExecute(String result) {

        alertDialog.setMessage(result);
        alertDialog.show();

        if(result.equals("Account created successfully"))
        {

            Intent intent=new Intent();
            intent.setClass(context.getApplicationContext(),MainActivity.class);

            context.startActivity(intent);

        }
        else {

            alertDialog.show();
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

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



public class BookingBackground extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BookingBackground(Context ctx) {
        context = ctx;

    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String date = voids[0];
        String time = voids[1];
        String vechicle = voids[2];
        String contact = voids[3];
        String type = voids[4];
        String login_url = "https://omsai12.000webhostapp.com/bookingForm.php";

        try {
            URL url = new URL(login_url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")
                    +"&&"+URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(time,"UTF-8")+"&&"+URLEncoder.encode("vechicle","UTF-8")+"="+URLEncoder.encode(vechicle,"UTF-8")+"&&"+URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&&"+URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode(type,"UTF-8");
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






    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

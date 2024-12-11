package com.example.a1211;

import android.content.Intent;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//010 10


public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ListView listview;
    Button button_prev, button_next, button_history;
    ArrayAdapter adapter;
    LinkedList titleList=new LinkedList();
    LinkedList imageUrlList=new LinkedList();
    int LOAD=0, PREV=1, NEXT=2;
    int pageIndex=1, pageUnit=10, pageIndexMax=1000000; // pageIndexMax 설정 코드 구현 필요
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_prev=findViewById(R.id.button_prev);
        button_next=findViewById(R.id.button_next);
        button_history=findViewById(R.id.button_history);
        listview=findViewById(R.id.listview);
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, titleList);
        listview.setAdapter(adapter);
        new Thread(()->displayData(LOAD)).start();
        button_prev.setOnClickListener((v)->new Thread(()->displayData(PREV)).start());
        button_next.setOnClickListener((v)->new Thread(()->displayData(NEXT)).start());
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addToHistory((String) titleList.get(position), (String) imageUrlList.get(position));
                Intent intent=new Intent(getApplicationContext(), ContentActivity.class);
                intent.putExtra("IMAGE_URL", (String) imageUrlList.get(position));
                startActivity(intent);
            }
        });
        button_history.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), HistoryActivity.class)));
    }

    private void addToHistory(String title, String imageUrl) {
        try {
            FileOutputStream oF=openFileOutput("history.txt", MODE_APPEND);
            String s=title+"\t"+imageUrl+"\n";
            oF.write(s.getBytes());
            oF.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void displayData(int action) {
        if(action==PREV) {
            if(pageIndex==1) return;
            pageIndex--;
        }
        if(action==NEXT) {
            if(pageIndex==pageIndexMax) return;
            pageIndex++;
        }
        String xmlString=downloadXml();
        getInfoFromXml(xmlString);
        runOnUiThread(()->{
            adapter.notifyDataSetChanged();
            setTitle(pageIndex+" / "+pageIndexMax);
        });
    }
    private void getInfoFromXml(String xmlString) {
        titleList.clear();
        imageUrlList.clear();
        String data="", title="", imageUrl="";
        boolean jpgYN=false;
        int totalCnt=0;
        XmlPullParser parser= Xml.newPullParser();
        try {
            parser.setInput(new StringReader(xmlString));
            for(int event=parser.getEventType(); event!=XmlPullParser.END_DOCUMENT; event=parser.next()){
                if(event==XmlPullParser.TEXT) { data=parser.getText(); continue; }
                if(event!=XmlPullParser.END_TAG) continue;
                String tag=parser.getName();
                if(tag.equals("totalCnt")) totalCnt=Integer.parseInt(data);
                if(tag.equals("pageUnit")) pageUnit=Integer.parseInt(data);
                if(tag.equals("title")) title=data;
                if(tag.equals("fileNm")) jpgYN=data.endsWith(".jpg");
                if(tag.equals("linkUrl") && jpgYN) imageUrl=data.trim();
                if(tag.equals("list")) {
                    titleList.add(title);
                    imageUrlList.add(imageUrl);
                }
            }
            pageIndexMax=totalCnt/pageUnit;
            if(totalCnt%pageUnit>0) pageIndexMax++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private String downloadXml() {
        StringBuilder sb=new StringBuilder();
        try {
            handleSSL();
            URL url=new URL("https://www.gogung.go.kr/openApiPublication.do?pageIndex="+pageIndex);
            BufferedReader si=new BufferedReader(new InputStreamReader(url.openStream()));
            for(String line=si.readLine(); line!=null; line=si.readLine()) sb.append(line);
            si.close();
        } catch (Exception e) { throw new RuntimeException(e); }
        return sb.toString();
    }
    // HTTPS 접속에서 아래 오류 발생 시 대응
    // java.security.cert.CertificateException: java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.
    // Reference: https://copyprogramming.com/howto/way-to-ignore-ssl-certificate-using-httpsurlconnection
    private void handleSSL() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext= SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{
                new X509TrustManager() {
                    @Override public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}
                    @Override public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {}
                    @Override public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[]{};}
                }
        },null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }
}



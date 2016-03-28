package com.applicationcourse.mobile.graphmaster.UI;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.applicationcourse.mobile.graphmaster.R;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ListAdapter listAdapter;
    private String[] videoTitle = {"Level 1.1","Level 1.2","Level 1.3","Level 1.4","Level 1.5","Level 1.6","Level 2.1","Level 2.2","Level 2.3","Level 2.4","Level 2.5","Level 2.6",
            "Level 3.1","Level 3.2","Level 3.3","Level 3.4","Level 3.5","Level 3.6","Level 4.1","Level 4.2","Level 4.3","Level 4.4","Level 4.5","Level 4.6"};
    private String[] url = {"https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU",
            "https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU",
            "https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU",
            "https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU","https://youtu.be/liFLl3Eh_HU"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        listView = (ListView)findViewById(R.id.videolistView);
        listAdapter = new ListAdapter(this,R.layout.activity_list_row,videoTitle);
        try {
            listView.setAdapter(listAdapter);
        }catch (Exception e){
            Log.e("Adapter",e.getMessage());
        }

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String urltext = url[position];

        if (urltext == null){
            Log.e("Get url","no url");
        }else{
            //open  youtube
            Uri uri = Uri.parse(urltext);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            Toast.makeText(getBaseContext(), "watch the video", Toast.LENGTH_SHORT).show();
        }
    }
}

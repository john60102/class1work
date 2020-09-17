package com.example.class1work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result,pca,pla,name;
    private EditText nameset;
    private RadioGroup rg1;
    private RadioButton rb1,rb2,rb3;
    private int py,pc;
    private String pyr,nms;
    private Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=findViewById(R.id.rg1);
        rb1=findViewById(R.id.er);
        rb2=findViewById(R.id.ro);
        rb3=findViewById(R.id.pa);
        result=findViewById(R.id.textView5);
        pca=findViewById(R.id.textView2);
        pla=findViewById(R.id.textView4);
        name=findViewById(R.id.textView3);
        rg1.setOnCheckedChangeListener(listener);

        play=findViewById(R.id.play);
        play.setOnClickListener(listener2);
        nameset=findViewById(R.id.nameset);
    }
    private RadioGroup.OnCheckedChangeListener listener=
            new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(rb1.isChecked()){
                        pyr="玩家方:剪刀";
                        py=0;
                    }
                    if(rb2.isChecked()){
                        pyr="玩家方:石頭";
                        py=1;
                    }
                    if(rb3.isChecked()){
                        pyr="玩家方:布";
                        py=2;
                    }
                }
            };
    private Button.OnClickListener listener2=
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    nms=nameset.getText().toString();
                    pc=(int)(Math.random()*3);
                    name.setText("玩家名:"+nms);
                    pla.setText(pyr);
                    if(pc==0){
                        pca.setText("電腦方:剪刀");
                        if(pc==py){
                            result.setText("平手");
                        }
                        if(pc<py && py==1){
                            result.setText("玩家贏");
                        }
                        if(pc<py && py==2){
                            result.setText("電腦贏");
                        }
                    }
                    if(pc==1){
                        pca.setText("電腦方:石頭");
                        if(pc==py){
                            result.setText("平手");
                        }
                        if(pc>py){
                            result.setText("電腦贏");
                        }
                        if(pc<py){
                            result.setText("玩家贏");
                        }
                    }
                    if(pc==2){
                        pca.setText("電腦方:布");
                        if(pc==py){
                            result.setText("平手");
                        }
                        if(pc>py && py==0){
                            result.setText("玩家贏");
                        }
                        if(pc>py && py==1){
                            result.setText("電腦贏");
                        }
                    }
                }
            };
}

package com.worldmer.fragmentnavigationdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragCallBack,View.OnClickListener {

    Button btn1,btn2,btn3,btn4;
    public static final String TAG_FRAG_A = "fragment_A";
    public static final String TAG_FRAG_B = "fragment_B";
    public static final String TAG_FRAG_C = "fragment_C";
    public static final String TAG_FRAG_D = "fragment_D";

    FragBackPressed backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilize();
    }
    public void initilize()
    {
        btn1 = findViewById(R.id.btn0);
        btn2 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn2);
        btn4 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onFragWidgetClick(String tag,String msg) {
        switch (tag)
        {
            case TAG_FRAG_A:
                fragCall(TAG_FRAG_A,msg);
                break;
            case TAG_FRAG_B:
                fragCall(TAG_FRAG_B,msg);
                break;
            case TAG_FRAG_C:
                fragCall(TAG_FRAG_C,msg);
                break;
            case TAG_FRAG_D:
                fragCall(TAG_FRAG_D,msg);
                break;
        }
    }

    @Override
    public void onFragBack(String tag) {
        Log.d("hello","TAG : " + tag);
        getSupportFragmentManager().popBackStackImmediate(TAG_FRAG_A,FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn0:
                fragCall(TAG_FRAG_A,null);
                break;
            case R.id.btn1:
                fragCall(TAG_FRAG_B,null);
                break;
            case R.id.btn2:
                fragCall(TAG_FRAG_C,null);
                break;
            case R.id.btn3:
                fragCall(TAG_FRAG_D,null);
                break;
        }
    }

    public void fragCall(String tag,String msg)
    {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("tag",tag);
        if (msg !=null) {
            bundle.putString("msg", msg);
        }

        switch (tag)
        {
            case TAG_FRAG_A:
                fragment = new FragA();
                fragment.setArguments(bundle);
                break;
            case TAG_FRAG_B:
                fragment = new FragB();
                fragment.setArguments(bundle);
                break;
            case TAG_FRAG_C:
                fragment = new FragC();
                fragment.setArguments(bundle);
                break;
            case TAG_FRAG_D:
                fragment = new FragD();
                fragment.setArguments(bundle);
                break;

        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(android.R.id.content,fragment,tag);
        setBackPressListener(fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        backPressed.onBackSelected();
    }

    public void setBackPressListener(Fragment frag)
    {
        backPressed = (FragBackPressed)frag;
    }
}
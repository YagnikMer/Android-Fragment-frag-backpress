package com.worldmer.fragmentnavigationdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yagnik on 14-Oct-18.
 */

public class FragD extends Fragment implements FragBackPressed {

    FragCallBack callBack;
    TextView text;
    EditText edit;
    Button btn1,btn2,btn3;
    String msg ;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBack = (FragCallBack)context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        text = view.findViewById(R.id.text);
        edit = view.findViewById(R.id.edit);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        try {
            msg = getArguments().getString("msg");
        } catch (Exception e) {
        }

        if (null != msg) {
            text.setText(msg);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != edit) {
                    if (edit.getText().toString().trim().length() > 0) {
                        text.setText(edit.getText().toString());
                        callBack.onFragWidgetClick(MainActivity.TAG_FRAG_A,edit.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Invalid Text", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != edit) {
                    if (edit.getText().toString().trim().length() > 0) {
                        text.setText(edit.getText().toString());
                        callBack.onFragWidgetClick(MainActivity.TAG_FRAG_B,edit.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Invalid Text", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != edit) {
                    if (edit.getText().toString().trim().length() > 0) {
                        text.setText(edit.getText().toString());
                        callBack.onFragWidgetClick(MainActivity.TAG_FRAG_C,edit.getText().toString());
                    } else {
                        Toast.makeText(getActivity(), "Invalid Text", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackSelected() {
        callBack.onFragBack(MainActivity.TAG_FRAG_D);
    }

}
package com.example.test.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Dialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                   View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
                   LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
                   ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
                   TextView tipTextView = (TextView) v.findViewById(R.id.tv_message);// 提示文字
                   Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(      // 加载动画
                           MainActivity.this, R.anim.load_animation);
                   spaceshipImage.startAnimation(hyperspaceJumpAnimation);       // 使用ImageView显示动画
                   tipTextView.setText("loading.....");// 设置加载信息
                   loadingDialog = new Dialog(MainActivity.this, R.style.loading_dialog);// 创建自定义样式dialog
                   loadingDialog.setCancelable(true);          // 这里设置加载的时候点击返回是否取消  设置为true 点击返回可以取消  false 则不可以取消
                   loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                           LinearLayout.LayoutParams.WRAP_CONTENT,
                           LinearLayout.LayoutParams.WRAP_CONTENT));// 设置布局
                loadingDialog.show();
               }
        });

        /**
         *  这里面我没有增加取消加载的按钮  如果需要增加的话  直接点击事件里面配置
         *  if(loadingDialog.isShowing()){   判断Dialog 是否显示
         *          loadingDialog.cancel()
         *  }
         */
    }
}

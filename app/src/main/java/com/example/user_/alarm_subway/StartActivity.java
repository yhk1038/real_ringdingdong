package com.example.user_.alarm_subway;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

@SuppressWarnings("deprecation")
public class StartActivity extends TabActivity {
    TabHost mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //탭호스트 객체 생성
        mTab = getTabHost();
        //탭스펙 변수 선언
        TabHost.TabSpec spec;
        /* 화면을 구성할 커스텀 레이아웃 xml파일은 일반 Activity처럼
                setContentView()로 셋팅할 수 없습니다.
        LayoutInflater 객체로 생성합니다. */
        LayoutInflater.from(this).inflate(R.layout.activity_start,
                mTab.getTabContentView(), true);


        // 위에서 선언한 탭스펙을 TabHost의 newTabSpec 메서드로 생성합니다.
        // 괄호 안에 생성자 인수를 지정하며, .setIndicator("탭에 출력될 글자"),
        // .setContent()로 탭의 내용물로 보여질 레이아웃 또는 위젯의 식별자를
        // 넣습니다. 마지막으로 addTab() 메서드로 탭을 실제 화면에 추가합니다.

        //탭호스트를 가져온다.
        TabHost mTabHost = getTabHost();
        TabWidget tabWidget = mTabHost.getTabWidget();

        //검색 탭위젯
        Intent intent01 = new Intent().setClass(this, AlarmList.class);
        ///담을 이미지 설정
        ImageView tabwidget01 = new ImageView(this);
        tabwidget01.setImageResource(R.drawable.tab_widget01);
        ///이미지 적용하고 위젯 추가
        mTab.addTab(mTab.newTabSpec("tab1")
                .setIndicator(tabwidget01)
                .setContent(intent01));
                //.setContent(R.id.tv1));
        ///배경설정
        //tabWidget.getChildAt(0).setBackgroundResource(R.drawable.tab_bg);




        // 즐겨찾기 탭위젯
        Intent intent02 = new Intent().setClass(this, SearchImg.class);
        ImageView tabwidget02 = new ImageView(this);
        tabwidget02.setImageResource(R.drawable.tab_widget02);
        mTab.addTab(mTab.newTabSpec("tab2")
                .setIndicator(tabwidget02)
                .setContent(intent02));
        //tabWidget.getChildAt(1).setBackgroundResource(R.drawable.tab_bg);
        mTab.getTabWidget().setCurrentTab(1);


        // 설정 탭위젯
        Intent intent03 = new Intent().setClass(this, AlarmSet.class);
        ImageView tabwidget03 = new ImageView(this);
        tabwidget03.setImageResource(R.drawable.tab_widget03);
        spec = mTab.newTabSpec("tab3")
                .setIndicator(tabwidget03)
                .setContent(intent03);
                mTab.addTab(spec);
        //tabWidget.getChildAt(2).setBackgroundResource(R.drawable.tab_bg);

        //4번째 탭웨젯(비활성화)
        Intent intent04 = new Intent().setClass(this, StartActivity.class);
        mTab.addTab(mTab.newTabSpec("tab4")
                .setIndicator(new LinearLayout(this))
                .setContent(intent04));
        //tabWidget.getChildAt(3).setBackgroundResource(R.drawable.tab_bg);

        mTab.getTabWidget().getChildAt(3).setClickable(false);      //탭4 비활성화

        //5번째 탭웨젯(비활성화)
        Intent intent05 = new Intent().setClass(this, StartActivity.class);
        mTab.addTab(mTab.newTabSpec("tab5")
                .setIndicator(new LinearLayout(this))
                .setContent(intent05));
        //tabWidget.getChildAt(4).setBackgroundResource(R.drawable.tab_bg);

        mTab.getTabWidget().getChildAt(4).setClickable(false);      //탭5 비활성화

        tabWidget.setBackgroundResource(R.drawable.tab_bg);         //탭구분 없앰(배경 한번에 설정)
        mTab.getTabWidget().getLayoutParams().height = 80;          // 탭위젯 높이 설정
        //mTab.getTabWidget().getLayoutParams().width = 500;

        mTab.getTabWidget().setPadding(20, 15, 50, 15);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu(메뉴를 채우다); 메뉴를  이것은 만약 아이템이 존재한다면 그것을 action bar 에 추가합니다.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main1, menu);
        return true;
    }

}

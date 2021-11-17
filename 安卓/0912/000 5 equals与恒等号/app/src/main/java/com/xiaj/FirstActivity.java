package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * equals与恒等号
 * ★ == 比较是地址和值，即是否是同一个对象
 * equals 比较的是值
 * ★对基本数据类型 == 直接比较的是值
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Object object1 = new Object();
        Object object2 = new Object();
        Log.i("xj", " Object object1 = new Object();\nObject object2 = new Object();");
        Log.i("xj", "object1==object2 is " + (object1 == object2));
        Log.i("xj", "object1.equals(object2) is " + (object1.equals(object2))); //在Object类中，equals方法是采用“==”运算进行比较,★Ctrl+鼠标左键点击equals试试看

        Log.i("xj", "-----------------------------");
        object1 = object2;  //两者地址相同，是同一对象
        Log.i("xj", "执行object1=object2后比较");
        Log.i("xj", "object1==object2 is " + (object1 == object2));
        Log.i("xj", "object1.equals(object2) is " + (object1.equals(object2)));

        Log.i("xj", "-----------------------------");
        //声明了两个对象，用'=='比较的结果是false
        String str1 = new String("a");
        String str2 = new String("a");
        Log.i("xj", " String str1 = new String(\"a\");\nString str2 = new String(\"a\");");
        stringCompare(str1, str2);

        Log.i("xj", "-----------------------------");
        String str3 = "a";
        String str4 = "a";
        Log.i("xj", " String str3 = \"a\";\nString str4 = \"a\";");
        stringCompare(str3, str4);

        Log.i("xj", "-----------------------------");
        int i = 1;
        int j = new Integer(1); //Integer对象隐式转换成int，最新版JDK推荐使用Integer.valueOf(1)
        Log.i("xj", " int i = 1;\nint j = new Integer(1);");
        Log.i("xj", "基本数据类型 int i==j is " + (i == j));

        Log.i("xj", "-----------------------------");
        Integer m = new Integer(1); //新版本的JDK中已不推荐使用★不是SDK
        Integer n = new Integer(1);
        Integer x = Integer.valueOf(1); //查看valueOf源码
        Integer y = Integer.valueOf(1);
        Log.i("xj", " Integer m = new Integer(1);\nInteger n = new Integer(1);\nInteger x = Integer.valueOf(1);\nInteger y = Integer.valueOf(1);");
        Log.i("xj", "Integer对象 m==n is " + (m == n));
        Log.i("xj", "Integer对象 m equals n is " + (m.equals(n)));
        Log.i("xj", "Integer对象 m==x is " + (m == x));
        Log.i("xj", "Integer对象 m equals x is " + (m.equals(x)));
        Log.i("xj", "Integer对象 x==y is " + (x == y) + "注意此行的结果");
        Log.i("xj", "Integer对象 x equals y is " + (x.equals(y)));

        //Java的坑
        Log.i("xj", "-----------------------------");
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        Log.i("xj", " Integer a = 100;\nInteger b = 100;\nInteger c = 200;\nInteger d = 200;");
        Log.i("xj", "a==b is " + (a == b));
        Log.i("xj", "c==d is " + (c == d));

        Log.i("xj", "-----------------------------");
        Integer x1 = Integer.valueOf(100);
        Integer y1 = Integer.valueOf(100);
        Integer x2 = Integer.valueOf(200);
        Integer y2 = Integer.valueOf(200);
        Log.i("xj", " Integer x1 = Integer.valueOf(100);\nInteger y1 = Integer.valueOf(100);\nInteger x2 = Integer.valueOf(200);\nInteger y2 = Integer.valueOf(200);");
        Log.i("xj", "Integer对象 x1==y1 is " + (x1 == y1));
        Log.i("xj", "Integer对象 x1 equals y1 is " + (x1.equals(y1)));
        Log.i("xj", "Integer对象 x2==y2 is " + (x2 == y2));
        Log.i("xj", "Integer对象 x2 equals y2 is " + (x2.equals(y2)));
        /**
         * Integer中有一个静态内部类IntegerCache，在类加载的时候，它会把[-128, 127]之间的值缓存起来，
         * 而Integer a = 100这样的赋值方式，会首先调用Integer类中的静态valueOf方法，
         * 这个方法会尝试从缓存里取值，如果在这个范围之内就不用重新new一个对象了
         *
         * new Integer(1) ：会新建一个对象；已不推荐使用
         * Integer.valueOf(1) ：使用对象池中的对象，如果多次调用，会取得同一个对象的引用。
         */

    }

    /**
     * 将两个字符串比较==和equals结果
     *
     * @param str1 字符串1
     * @param str2 字符串2
     */
    static void stringCompare(String str1, String str2)
    {
//        if (str1 == str2)
//            System.out.println("两字符串 == true");
//        else
//            System.out.println("两字符串 == false");

//        if (str1.equals(str2))
//        {
//            System.out.println("两字符串 equals true");
//            return;
//        }
//        System.out.println("两字符串 equals false");

        Log.i("xj", "两字符串 == " + (str1 == str2));    //注：双等号比较的两字符串变量要用括号括起
        Log.i("xj", "两字符串 equals " + str1.equals(str2));
    }
}


/*
II:  Object object1 = new Object();
    Object object2 = new Object();
I: object1==object2 is false
I: object1.equals(object2) is false
I: -----------------------------
I: 执行object1=object2后比较
I: object1==object2 is true
I: object1.equals(object2) is true
I: -----------------------------
I:  String str1 = new String("a");
    String str2 = new String("a");
I: 两字符串 == false
I: 两字符串 equals true
I: -----------------------------
I:  String str3 = "a";
    String str4 = "a";
I: 两字符串 == true
I: 两字符串 equals true
I: -----------------------------
I:  int i = 1;
    int j = new Integer(1);
I: 基本数据类型 int i==j is true
I: -----------------------------
I:  Integer m = new Integer(1);
    Integer n = new Integer(1);
    Integer x = Integer.valueOf(1);
    Integer y = Integer.valueOf(1);
I: Integer对象 m==n is false
I: Integer对象 m equals n is true
I: Integer对象 m==x is false
I: Integer对象 m equals x is true
I: Integer对象 x==y is true注意此行的结果
I: Integer对象 x equals y is true
I: -----------------------------
I:  Integer a = 100;
    Integer b = 100;
    Integer c = 200;
    Integer d = 200;
I: a==b is true
I: c==d is false
I: -----------------------------
I:  Integer x1 = Integer.valueOf(100);
    Integer y1 = Integer.valueOf(100);
    Integer x2 = Integer.valueOf(200);
    Integer y2 = Integer.valueOf(200);
I: Integer对象 x1==y1 is true
I: Integer对象 x1 equals y1 is true
I: Integer对象 x2==y2 is false
I: Integer对象 x2 equals y2 is true
 */


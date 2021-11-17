package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/*
方法重载：必须同时满足以下条件：
1）同一个类中至少有两个方法的名称相同；
2）同名方法的参数数量或参数类型不同
注：方法重载与返回类型无关

1.精确匹配
2.自动转换匹配
Q:将重载的三个方法依次注释会产生什么结果？

★区分重载（Overload静态多态）和重写（Override动态多态）
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Test test1 = new Test();
        test1.test(5);
        test1.test(5l);
        test1.test(5.0);
        test1.test(5.0, 6.0);
    }
}

class Test
{
    void test(int x) //注释掉本方法，查看自动转换匹配 Q:本方法是构造方法吗？
    {
        Log.i("xj", "test(int):" + x);
    }

    void test(long x)
    {
        Log.i("xj", "test(long):" + x);

    }

    void test(double x)
    {
        Log.i("xj", "test(double):" + x);
    }

    String test(double x, double y) //方法重载与返回类型无关
    {
        Log.i("xj", "test(double):x=" + x + ", y=" + y);
        return "test(double):x=" + x + ", y=" + y;
    }
}

/*
自动类型转换（隐式类型转换）的次序为：
byte-->short-->char-->int-->long-->float-->double
1B      2B     1-2B    4B    8B     4B       8B

I: test(int):5
I: test(long):5
I: test(double):5.0
I: test(double):x=5.0, y=6.0
 */
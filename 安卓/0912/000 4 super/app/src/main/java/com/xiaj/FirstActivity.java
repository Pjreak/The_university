package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * super.age、super.show()与super()
 * 了解初始化类实例时 不带参数 与 带参数 两种情况下以下三种super的效果：
 * 1.不含super时的效果
 * 2.含super的效果
 * 3.super带参数的效果
 * 注：super方法必须是在构造方法的第一条命令。普通方法中不能使用super方法，如之前案例的super.say()
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); //★调用父类的方法
        setContentView(R.layout.main);
        Son son = new Son();   //注：此时Son类中要用Son()的构造方法或者 所有构造方法都没有（此时会调用父类的无参数构造方法）
//		Son son = new Son("张娃");
    }
}

class Father
{
    int age = 30;

    Father()
    {
        Log.i("xj", "Father():age=" + age + "岁");
    }

    Father(String name)
    {
        Log.i("xj", "Father(name):name=" + name + "  age=" + age + "岁");
    }

    void show()
    {
        Log.i("xj", "Father中的show方法");
    }
}

class Son extends Father
{
    int age = 10;

    Son()
    {
//         super();//是否有此命令效果一样
//        super("张三");
        // 子类无参数构造方法时，不用显式调用父类无参数构造方法，系统会自动提供
        Log.i("xj", "Son():age=" + age + "岁");
        Log.i("xj", "Son():super.age=" + super.age + "岁");  //★调用父类的成员变量
        super.show();
        show();
    }

    Son(String name)
    {
//		super();	//默认不含super时自动调用不带参super，意味着父类中必须要有不带参数的构造方法，除非子类使用带参数super
//        super("张三"); 	// 调用父类的构造方法，一定要放在方法的第一行

        Log.i("xj", "Son(name):name=" + name + "  age=" + age + "岁");
        Log.i("xj", "Son(name):super.age=" + super.age + "岁");
        super.show();
        show();
    }

    void show()
    {
        Log.i("xj", "Son中的show方法");
    }
}
/*
Q:当Son中没有定义（任何）构造方法时能正确运行吗？
Q:可以使用super.name吗?
Q：将构造方法Father()注释掉会发生什么？
Q:将Father类中所有构造方法都注释掉会如何？
 */
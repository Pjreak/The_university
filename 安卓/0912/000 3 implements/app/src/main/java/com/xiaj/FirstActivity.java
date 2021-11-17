package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 了解implements与extends的区别
 * Java不支持extends的多重继承，但是可以通过implements接口实现比多重继承更强的功能。
 * 一个类还可以有多个接口，接口间用逗号分隔。比如 class A extends B implements C,D,E;
 * 1）接口中默认变量的修饰是public static final（公共静态常量）。
 * 2）接口中默认方法的修饰是 public abstract。
 * ▲PPT：抽象类与接口的区别
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Dog dog = new Dog();
        dog.say();
        Log.i("xj", "----------------------------------");

        Cat cat = new Cat();
        cat.say();
        Log.i("xj", "----------------------------------");

        //父类引用指向Dog子类的具体实现
        Animal animal = new Dog();
        animal.say();
        animal = new Cat();
        animal.say();
        Log.i("xj", "----------------------------------");

        /**
         * 接口本身不能实例化，可采用Dog类来具体实现或使用接口派生的匿名类实现
         * 监听器就是采用接口方式响应回调，对监听器接口的使用方式与下述代码相同。
         * ★演示以下代码的自动生成
         */
        Animal animal1 = new Animal()
        {
            @Override
            public void say()
            {
                Log.i("xj", "调用匿名类中的的方法say():汪~~");
            }
        };
        animal1.say();

        //以上代码等效于
        (new Animal()
        {
            @Override
            public void say()
            {
                Log.i("xj", "调用匿名类中的方法say():汪");
            }
        }).say();
    }
}

/**
 * 接口似抽象类，表示的是一个抽象概念，不能被实例化为对象。
 * 接口具体应用时需要继承，其中的抽象方法在各具体子类中必须要具体实现。
 * 接口没有构造方法
 */
interface Animal
{
    String name = "动物世界";   //接口中默认变量的修饰是public static final
//    name = "狗"; //Q:为什么本行代码会出现错误？
    /**
     * 接口中默认方法的修饰是 public abstract
     * 如果不为空则提示interface methods cannot have body
     */
    void say();
}

class Dog implements Animal
{
    static String name = "Dog"; //能不用static修饰吗？注意观察有无此行的输出变化
    @Override
    public void say()   //需重写父类方法say，前面必须要有关键字public
    {
        Log.i("xj", "name = " + name + ", Animal.name = " + Animal.name + ", Dog.name = " + Dog.name);  //Q:可以使用 dog.name 吗？
        Log.i("xj", "调用Dog的方法say():汪汪汪");
    }
}

class Cat implements Animal
{
    @Override
    public void say()
    {
//        name = "猫";   //分析为什么是错的？
        Log.i("xj", "name = " + name + ", Animal.name = " + Animal.name + ", Cat.name = " + Cat.name);
        Log.i("xj", "调用Cat的方法say()：喵喵喵");
    }
}

/*
Q：abstract 和final可以同时修饰一个类吗？
 */
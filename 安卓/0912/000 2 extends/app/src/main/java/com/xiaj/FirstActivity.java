package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * extends继承
 * 父类和子类的关系
 * 直接父类和间接父类
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //1.类正常实例化
        Animal animal = new Animal();
        animal.say();
        animal.getName();
        Animal.getName();   //注意与上一行代码的区别（类方法可不用初始化直接调用）
        Log.i("xj", "----------------------------------");

        Dog dog = new Dog();
        dog.say();
        dog.getName();
        Log.i("xj",  "在实例dog中调用Animal.name = " + Animal.name + ", Dog.name = " + Dog.name + ", dog.name = " + dog.name);
        Log.i("xj", "----------------------------------");

        Cat cat = new Cat();
        cat.say();
        cat.getName();
        Log.i("xj",  "在实例cat中调用Animal.name = " + Animal.name + ", Cat.name = " + Cat.name + ", cat.name = " + cat.name);
        Log.i("xj", "----------------------------------");

        (new PersianCat()).say();
        (new PersianCat()).getName();
        Log.i("xj", "----------------------------------");

        //2.父类引用指向Dog子类的具体实现
        Animal newAnimal = new Dog();
        newAnimal.say();
        newAnimal.getName();
        Log.i("xj",  "在实例newAnimal中调用Animal.name = " + Animal.name + ", newAnimal.name = " + newAnimal.name);
        /**
         * 在Java中如果将子类的实例化对象赋给父类实例变量，其方法调用顺序遵循：
         * 1）如果调用的是成员方法，优先调用子类中的成员方法，子类中没有的成员方法才调用父类中的成员方法。
         * 2）如果调用的是静态方法则还是优先调用各自类中的同名静态方法（静态变量和静态方法是在定义类时就建立的，与是否实例化无关）。
         */

        //Cat是Animal，Animal不一定是Cat。以下命令是错误的
//        Cat cat2 = new Animal();  //对错误的代码会出现红色波浪线，移动光标会出现红色惊叹号
    }
}

class Animal
{
    static String name = "动物世界";
    void say()
    {
        Log.i("xj", "调用Animal的方法say()：此时无声胜有声");
    }

    static void getName()   //Q:将本方法注释了会如何？
    {
        Log.i("xj", "调用Animal的方法getName()");
        Log.i("xj", "name = " + name + ", Animal.name = " + Animal.name);
    }
}

class Dog extends Animal
{
    static String name = "Dog";
    /**
     * 重写父类方法say
     * 注意与构造方法的区别：
     * 1.与类名不相同
     * 2.不象构造方法会默认调用super()
     * 3.演示@Override的作用
     */
    @Override
    void say()
    {
//        super.say();  //注意与构造方法中super的区别（参见super案例）
        Log.i("xj", "调用Dog的方法say():汪汪汪");
    }

    static void getName()   //Q:将本方法注释了会如何？
    {
        Log.i("xj", "调用Dog的方法getName()");
        Log.i("xj", "name = " + name + ", Animal.name = " + Animal.name + ", Dog.name = " + Dog.name);  //Q:可以使用 dog.name 吗？
    }
}

class Cat extends Animal
{
    //重写父类方法say
    void say()
    {
        Log.i("xj", "name = " + name + ", Animal.name = " + Animal.name + ", Cat.name = " + Cat.name);
        Log.i("xj", "调用Cat的方法say()：喵喵喵");
    }

    static void getName()
    {
        Log.i("xj", "调用Cat的方法getName()");
    }
}

/**
 * Cat是PersianCat是直接父类
 * Animal是PersianCat是间接父类
 */
class PersianCat extends Cat
{
    //如果注销say方法会如何？
    void say()
    {
        Log.i("xj", "调用PersianCat的方法say()：波斯猫喵喵喵");
    }

    static void getName()
    {
        Log.i("xj", "调用PersianCat的方法getName()");
    }
}
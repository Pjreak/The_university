package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 类、对象和方法
 * this、this()
 * 只能有一个public class，且类名必须与文件名前缀相同
 * 讲解Student类在本文件与放置置到另外一个文件的区别
 * 内部类：讲解Student类放置到FirstActivity类中的区别
 * ▲理解成员变量、实例变量、类变量、局部变量的关系
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        student("方法中的参数");   //这是调用FirstActivity类中的student方法
        Student student1 = new Student();   //这是对Student类的实例化，不带参数
        Student student2 = new Student("李四");   //这是对Student类的实例化，带参数
        Log.i("xj", "调用类实例student1中的getName方法：" + student1.getName() + "，student1.count=" + student1.count);
        Log.i("xj", "调用类实例student2中的getName方法：" + student2.getName() + "，student2.count=" + student2.count);
        Log.i("xj", "Student.count=" + Student.count);  //区分student1.count和Student.count的区别
    }

    String student(String name)
    {
        Log.i("xj", "姓名=" + name);
        return "姓名=" + name;
    }

}

class Student
{
    String name = "";   //成员变量中的实例变量
    static int count;   //成员变量中的类变量，★这里可没有初始化值，为什么？

    Student()
    {
        /**
         * this()方法如果无参数就调用本类的无参构造方法，有参数则调用对应参数的构造方法
         * this方法必须是构造方法中的第一个语句
         */
//        this("this"); //将调用Student(String name)构造方法
//        this();   //不能调用自身构造方法
        count++;
//        this("this");   //Call to 'this()' must be first statement in constructor body（错误: 对this的调用必须是构造器中的第一个语句）
        Log.i("xj", "name=匿名，count=" + count);
    }

    /**
     * 本方法与类名同名,为构造方法，参数数量与上一个同名方法不一样，为重载的方式之一；参数类型不一样为重载方式之二
     * 构造方法不能指定返回类型，如不能指定返回String之类的数据类型，默认返回类实例。如要返回String之类的数据，需要单独定义方法，如此例中的getName()
     *
     * @param name 人员名称
     */
    Student(String name)
    {
        count++;
        Log.i("xj", "姓名=" + name + "，count=" + count);
        this.name = name;   //分清楚两个name的区别
    }

    String getName()
    {
        return "姓名是" + name;
    }
}
/*
count变量没有赋初值就执行++操作而没有报错，原因是成员变量如果是基础数据类型，其默认初值为0或0.0，包装类型的成员变量默认初值为null。如果是局部变量则必须赋初值后才能使用。
 */
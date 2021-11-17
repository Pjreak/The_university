package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 代码块
 * 1. 代码块的作用
 * 2. 代码块的的执行顺序：优先执行静态代码 -> 普通代码块 -> 成员方法
 * 3. 代码块的执行次数：静态代码块只执行一次
 */
public class FirstActivity extends Activity
{
	int i;
	//    i = 0;	//此行取消注释会如何？
	int j = 0;

	{
		int m;
		m = 0;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Log.i("xj", "onCreate方法中");
		Test test1 = new Test("张三");
		Test test2 = new Test("李四");
	}

	{
		Log.i("xj", "本代码块放置在onCreate方法之后");
	}

	static
	{
		Log.i("xj", "FirstActivity中的静态代码块");
	}
}

class Test
{
	Test(String name)
	{
		Log.i("xj", "Test中的构造方法, name=" + name);
	}

	String str1 = "字符串";
	static String str2 = "static字符串";

	{
		Log.i("xj", "Test中的代码块:" + str1);
	}

	static
	{
		Log.i("xj", "Test中的静态代码块:" + str2);
//		Log.i("xj", "Test中的静态代码块" + str1);	//在静态代码块中不能调用非静态变量或对象
	}
}
//Q：如果在Test类中添加print方法，会在执行顺序中的什么位置？
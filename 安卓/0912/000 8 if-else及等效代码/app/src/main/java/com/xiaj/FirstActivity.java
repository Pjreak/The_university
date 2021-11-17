package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * if-else及等效代码
 * 1）	使用switch替代，提高代码可读性。
 * 2）	使用return去除不必要的else。
 * 3）	使用三元运算符。
 * 4）	其他方式根据具体情况可采用枚举、数组等方式优化。
 */
public class FirstActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.i("xj", "2->" + deal(2) + "，-2->" + deal(-2));  //区分student1.count和Student.count的区别
    }

    int deal(int i)
    {
        if (i > 0)
            i--;
        else
            i++;
        return i;
    }

    int deal2(int i)
    {
        if (i > 0)
        {
            i--;
            return i;
        }
        return ++i;
    }

    int deal3(int i)
    {
        switch (Boolean.toString(i > 0))
        {
            case "true":
                return --i;
            case "false":
                return ++i; //与return i++;的结果一样吗？
        }
        return ++i;
    }

    int deal4(int i)
    {
        return (i > 0 ? --i : ++i);
    }

}
package com.xiaj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
 * 注意:
   1. APP和Title的命令
        AndroidManifest.xml中application与activity中皆能够设置android:lable作为APP的名称
        activity中的android:lable优先级高于application中android:lable
        如果需要单独修改activity中标题，使用setTitle("java代码设置的标题");
   2. 掌握Log调试方法
   3. 掌握断点调试方法
   4. 知道R.java的前世今生（Android Studio 3.6取消了此文档，可以参看R.txt）
   5. 打包好的apk在哪儿？
   6. 演示adb logcat
   7. 布局文件或java文件中对要写入strings.xml的内容选中文字后按alt+Enter，弹出菜单中选中 Extract string resource
   8. 项目名称不能有中文、空格等
   9. 行注释、块注释、文档注释
   10. （大、小）驼峰命名法
   11. 乱码问题
   *
   * ★演示使用Android Studio的Device File Explorer上传文件到模拟器
   *
 */
public class FirstActivity extends Activity //只能有一个public修饰的类，且类名与文件前缀同名。如果Activity换成AppCompatActivity，需修改AndroidManifest.xml中的theme
{
    /**
     * 本方法为Activity第一次运行时首先被调用的方法
     *
     * @Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处: 1、可以当注释用,方便阅读；
     * 2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
     * 例如：如果没写@Override，而下面的方法名又写错了，这时编译器是可以编译通过的，
     * 因为编译器以为这个方法是子类中新增加的方法。
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    //底层是Activity，中层是Window，上层是View

        //R.layout.main参看R.java

//        setTitle("java代码设置的标题");    //修改标题栏，权限高于Manifest.xml中android:lable

        TextView textView1 = (TextView) findViewById(R.id.textView1); // 获取对象
//        textView1.setText("你好，Android！");

        show("ok"); //演示文档注释作用
    }

    /**
     * 本方法用于调试输出结果，显示在智能提示中
     *
     * @param stringShow show方法的String类型形参，显示在智能提示中
     * @author 张三 不显示在智能提示中
     * @version 1.0 不显示在智能提示中
     */
    void show(String stringShow)
    {
        int i = 1;
        int j = 2 + (((3)));
        int k = i + j;
        //注意观察以下调试输出的差异
        //第一种调试输出方法
        System.out.println("变量i=" + i);

        //第二种调试输出方法  注：以下集中方法是分优先级的，如果过滤中选择i则会显示w、e，而不显示d的记录
        Log.d("xj", "变量j=" + j);
        Log.i("xj",     //方法中使用行注释，参数一
                "变量j=" + j);    //参数二
        Log.w("xj", "变量j=" + j);
        Log.e("xj", "变量j=" + j);
//        float kl = (float)1.1 -1.001f;
//        Log.e("xj", String.valueOf(kl));

    }
//     Log.e("xj", "为什么这里不能使用Log命令？");
}
/*
注： res目录下的相关布局文件、values中的strings.xml、图片文件目录中文件名必须由小写字母、数字、下划线组成，且必须小写字符开头。如：main.xml、my_main.xml。

约定：
●：查看AndroidManifest.xml
▲：查看assets目录下的文件
■：查看布局文件
★：需要注意事项
*/

/*
常用快捷键
1）Ctrl+E：弹出最近打开文件列表。
2）Ctrl+/：给当前行或选中的代码块添加或取消注释。
3）Ctrl+Q：弹出光标所对应标识符的说明文档。
4）Ctrl+Shift+向上（或下）箭头：将当前行或选中的代码块上移（或下移），移动范围限制在当前所在类或方法内部。
5）Alt+Shift+向上（或下）箭头：将当前行或选中的代码块上移（或下移），移动范围不受限制。
6）Ctrl+D：复制当前行或选中的代码块并粘贴在选定代码之后。
7）Shift+Delete：删除当前行或选中的代码块。
8）Shift+F6：同步重命名标识符或文件名。
9）Ctrl+空格：匹配代码智能提示。因与输入法切换快捷键冲突，最好在“Settings -> Keymap”中修改快捷键。
10）Ctrl+Shift+Backspace：返回到上次编辑的位置。
11）F11/Ctrl+F11：添加或删除书签标记。
12）Ctrl+Alt+L：将当前文件按Setting中格式重排代码（含xml、java文件）。
13）Alt+Enter：导入光标所在字符串对应的类，将自动生成一条import命令。
14）Double Shift：全局搜索。
15）Ctrl+鼠标左键（Ctrl+B）：跳转到定义类、方法、成员变量的源码文件。
16）Ctrl+Alt+O：删除没有被引用使用的包。
17）Shift + F10/F9：Run / Debug
 */
package com.peng.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {

        String str = "{'name':'zhangsan','age':'12'}";
        Gson gson = new Gson();
        Person person = gson.fromJson(str, Person.class);
        System.out.println(person.getName() + "   " + person.getAge());
    }

    public void click2(View view) {
        String str = "[{'name':'peng','age':'23'},{'name':'jack','age':'22'}]";
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {
        }.getType();

        List<Person> list = gson.fromJson(str, listType);
        for (Person person : list)
            System.out.println(person.getName() + "   " + person.getAge());
    }

    public void click3(View view) {
        String str = "{\"name\":\"宝强\",\"age\":\"32\",\n" +
                "\"other\":[{\"name\":\"小马\",\"age\":\"22\",\"id\":\"1\"},\n" +
                "   {\"name\":\"小蓉\",\"age\":\"32\",\"id\":\"2\"},\n" +
                "   {\"name\":\"小王\",\"age\":\"42\",\"id\":\"3\"}]\n" +
                "}";
        Gson gson = new Gson();
        BaoBao js = gson.fromJson(str, BaoBao.class);
        System.out.println("name:" + js.getName() + " age:" + js.getAge());
        List<BaoBao.OtherBean> list = js.getOther();
        for (BaoBao.OtherBean ob : list) {
            System.out.println("name:" + ob.getName() + " id:" + ob.getId() + " age:" + ob.getAge());
        }
    }

    /**
     * 添加json数据
     *
     * @param view
     */
    public void click4(View view) {
        /*{"name":"宝强","age":"32",
                "other":[{"name":"小马","age":"22","id":"1"},
            {"name":"小蓉","age":"32","id":"2"},
            {"name":"小王","age":"42","id":"3"}]
        }*/
        BaoBao b = new BaoBao();
        b.setName("宝强");
        b.setAge("32");
        List<BaoBao.OtherBean> list = new ArrayList<>();
        /**
         * 如果你重写了OtherBean的构造函数
         * 你也可以这样加数据
         * BaoBao.OtherBean ob= new BaoBao.OtherBean("小马","22","1");
         */
        BaoBao.OtherBean ob = new BaoBao.OtherBean();
        ob.setName("小马");
        ob.setAge("22");
        ob.setId("1");

        BaoBao.OtherBean ob1 = new BaoBao.OtherBean();
        ob1.setName("小荣");
        ob1.setAge("32");
        ob1.setId("2");

        BaoBao.OtherBean ob2 = new BaoBao.OtherBean();
        ob2.setName("小王");
        ob2.setAge("42");
        ob2.setId("3");

        list.add(ob);
        list.add(ob1);
        list.add(ob2);

        b.setOther(list);

        Gson gson = new Gson();
        System.out.println(gson.toJson(b));

    }
}

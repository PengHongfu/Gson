package com.peng.gson;

import java.util.List;

/**
 * Created by Peng on 2016/8/20.
 */
public class BaoBao {
    /**
     * name : 宝强
     * age : 32
     * other : [{"name":"小马","age":"22","id":"1"},{"name":"小蓉","age":"32","id":"2"},{"name":"小王","age":"42","id":"3"}]
     */

    private String name;
    private String age;
    /**
     * name : 小马
     * age : 22
     * id : 1
     */

    private List<OtherBean> other;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<OtherBean> getOther() {
        return other;
    }

    public void setOther(List<OtherBean> other) {
        this.other = other;
    }

    public static class OtherBean {
        private String name;
        private String age;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

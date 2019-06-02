package com.baidu.bean;

import java.util.List;

public class HomeBrandBean {

    /**
     * code : 200
     * dlist : [{"id":1,"name":"小米","bigPic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","zuidijia":0},{"id":2,"name":"华为","bigPic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","zuidijia":0},{"id":3,"name":"玛莎离地","bigPic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","zuidijia":0},{"id":4,"name":"HZ","bigPic":"http://imgsrc.baidu.com/baike/pic/item/570f8c58885d84f19c8204a0.jpg","zuidijia":0}]
     */

    private int code;
    private List<DlistBean> dlist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DlistBean> getDlist() {
        return dlist;
    }

    public void setDlist(List<DlistBean> dlist) {
        this.dlist = dlist;
    }

    public static class DlistBean {
        /**
         * id : 1
         * name : 小米
         * bigPic : http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg
         * zuidijia : 0
         */

        private int id;
        private String name;
        private String bigPic;
        private int zuidijia;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBigPic() {
            return bigPic;
        }

        public void setBigPic(String bigPic) {
            this.bigPic = bigPic;
        }

        public int getZuidijia() {
            return zuidijia;
        }

        public void setZuidijia(int zuidijia) {
            this.zuidijia = zuidijia;
        }
    }
}

package com.baidu.bean;

import java.util.List;

public class HomeBannerBean {

    /**
     * code : 200
     * dlist : [{"id":1,"pic":"http://img2.cheshi-img.com/product/1_1024/p/40600/40629/56680656ee3ac.jpg"},{"id":2,"pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg"},{"id":3,"pic":"http://imgsrc.baidu.com/baike/pic/item/570f8c58885d84f19c8204a0.jpg"},{"id":4,"pic":"http://img2.cheshi-img.com/product/1_1024/p/40600/40629/56680656ee3ac.jpg"},{"id":5,"pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg"}]
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
         * pic : http://img2.cheshi-img.com/product/1_1024/p/40600/40629/56680656ee3ac.jpg
         */

        private int id;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}

package com.example.dell.myapplication.text;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication3
 * @Package com.example.dell.myapplication
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/7/25 19:18
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class JamedContent implements SelectAdapter {
   public static String Type="JamedContent";


    @Override
    public List setContentView() {
        ArrayList<String> list = new ArrayList<>();
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        return list;
    }

    @Override
    public List setContentT() {
        ArrayList<String> list = new ArrayList<>();
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");
        return list;
    }
}

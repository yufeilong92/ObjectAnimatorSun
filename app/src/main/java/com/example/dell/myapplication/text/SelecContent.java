package com.example.dell.myapplication.text;

import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication3
 * @Package com.example.dell.myapplication
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/7/25 20:32
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class SelecContent {
    private SelectAdapter adapter;

    public SelecContent(SelectAdapter adapter) {
        this.adapter = adapter;
    }

    public SelectAdapter getAdapter() {
        return this.adapter;
    }

    public List getListfragment() {
        return this.adapter.setContentView();
    }

    public List getTitle() {
        return this.adapter.setContentT();
    }
}

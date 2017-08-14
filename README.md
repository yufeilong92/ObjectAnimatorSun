##``添加水平分割线：高度为2px，颜色为灰色
         //水平分割线
         recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.HORIZONTAL_LIST));
<br>

##``添加垂直分割线：高度为2px，颜色为灰色
     //垂直分割线
     re``cyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.VERTICAL_LIST));
<br>
                 
##``水平+垂直分割线：高度为2px，颜色为灰色
       //垂直+水平分割线
       recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.BOTH_SET));

<br>

##``水平+垂直分割线：高度为2px，颜色为灰色
       //垂直+水平分割线
       recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.BOTH_SET));
<br>                 
                 
##``带颜色的分割线
     //添加带颜色分割线
     recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.BOTH_SET,5,Color.BLUE));

##自定义图片的分割线(图片必须有高度，比如说Xml文件，就可能没设置高度)：
     //添加图片分割线
     recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.HORIZONTAL_LIST,R.mipmap.ic_launcher));
<br>

##  //如果希望横竖都是图片边框，那可能要失望了
         recyclerView.addItemDecoration(new DividerItemDecoration(
                 ListRecycle.this, DividerItemDecoration.BOTH_SET,R.mipmap.ic_launcher));
<br>

##原因分析：
 假如我们有两个ItemView，明显只需要写一个分割线，分割线是有宽度的，而分割线的宽度是通过调整其中一个ItemView的宽度，然后空出间隙来绘制这个分割线，从原理上来讲，其中一个ItemView会比另一个小，当分割线比较窄的时候，视觉是不易察觉的，当它过宽的时候，就开始崩了。
 对于RecycleView的瀑布流的边框，表示确实有些无能为力，原因是getItemOffsets会绘制整占满屏幕的边框，假如ItemView只有半个屏幕大小，明显不合适。
 解决方案推荐：
 直接调整ItemView的Margin的大小，放弃使用分割线，采用之前说的Margin+Background方式。
 调整代码，对onDraw绘制的位置进行微调，这里需要一个有耐心去测试修改代码的人
<br> 

 ##editTEXT 与lines 冲突
    @Override
     public InputConnection onCreateInputConnection(EditorInfo outAttrs)
     {
         InputConnection conn = super.onCreateInputConnection(outAttrs);
         outAttrs.imeOptions &= ~EditorInfo.IME_FLAG_NO_ENTER_ACTION;
         return conn;
     }}
     
     <com.example.views.ActionEditText
         android:id=...
         android:layout_stuff=...
         android:imeOptions="actionDone"
         android:inputType="textAutoCorrect|textCapSentences|textMultiLine"
         android:maxLines="3" />
##另一种无论什么状况都是手动设置

 @Overridepublic InputConnection onCreateInputConnection(EditorInfo outAttrs) {
     InputConnection connection = super.onCreateInputConnection(outAttrs);
     int imeActions = outAttrs.imeOptions&EditorInfo.IME_MASK_ACTION;
     if ((imeActions&EditorInfo.IME_ACTION_DONE) != 0) {
         // clear the existing action
         outAttrs.imeOptions ^= imeActions;
         // set the DONE action
         outAttrs.imeOptions |= EditorInfo.IME_ACTION_DONE;//动态设置自己需要的
     }
     if ((outAttrs.imeOptions&EditorInfo.IME_FLAG_NO_ENTER_ACTION) != 0) {
         outAttrs.imeOptions &= ~EditorInfo.IME_FLAG_NO_ENTER_ACTION;
     }
     return connection;}
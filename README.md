# NotePad
This is an AndroidStudio rebuild of google SDK sample NotePad
# 实现了两个基本功能


## 1.显示note时间戳

### 要实现时间戳的功能要修改映射到数据库的PROJECTTION,ViweID,datacloumn,在NoteLsit对应布局中添加时间戳的textview.获取北京时间,然后再Noteeditor修改时间戳的格式。


![Image text](https://raw.githubusercontent.com/lx85886693/NotePad/master/app/src/main/res/time.png)


## 2.实现note的搜索功能


###  实现搜索功能，创建一个新的Activity，再其layout中加入searchview和listview控件。在NoteList的optionmenu添加一条新的Item，创建点击事件通过intent跳到Search这个新的Activity中，设置searchview的监听事件，重写onQueryTextChange方法。通过比较title完成搜索

![Image text](https://raw.githubusercontent.com/lx85886693/NotePad/master/app/src/main/res/search.png)

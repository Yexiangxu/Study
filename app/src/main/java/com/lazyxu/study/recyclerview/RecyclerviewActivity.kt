package com.lazyxu.study.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lazyxu.study.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

/**
 * User:Lazy_xu
 * Data:2019/10/30
 * Description:
 * FIXME 删除 插入 局部刷新
 */
class RecyclerviewActivity : AppCompatActivity() {
    private var rvMainAdapter: RvMainAdapter? = null
    val lists = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        for (i in 0..99) {
            lists.add("测试$i")
        }
        rvMainAdapter = RvMainAdapter(this, lists)
        //设置布局管理器
        rvMain.layoutManager = LinearLayoutManager(this)

        rvMain.addItemDecoration(SpacesItemDecoration(8))
        rvMain.adapter = rvMainAdapter

        tvChangeData.setOnClickListener {
            changeItem(20)
        }
    }

    private fun changeItem(position: Int) {
        lists[position] = "修改了数据$position，item没有闪动"
        rvMainAdapter!!.notifyItemChanged(position, "payload")
    }
}

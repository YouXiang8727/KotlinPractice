package com.youxiang8727.kotlinpractice

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.youxiang8727.kotlinpractice.CommonFunc.setSingleClickListener
import com.youxiang8727.kotlinpractice.ViewModels.MainViewModel
import com.youxiang8727.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            adapter = ActivityListAdapter().apply {
                setData(mainViewModel.getActivities(context))
            }
            layoutManager = LinearLayoutManager(context).apply { orientation = LinearLayoutManager.VERTICAL }
        }
    }

    inner class ActivityListAdapter: RecyclerView.Adapter<ActivityListAdapter.ViewHolder>() {
        private var mData: List<ActivityInfo> = listOf<ActivityInfo>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_activity, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text_view_activity_name.text = mData[position].name
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        fun setData(data: List<ActivityInfo>){
            mData = data
            notifyDataSetChanged()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val card_view_activity_info: MaterialCardView = itemView.findViewById(R.id.card_view_activity_info)
            val text_view_activity_name: TextView = itemView.findViewById(R.id.text_view_activity_name)

            init {
                card_view_activity_info.setSingleClickListener{
                    it.context.startActivity(Intent(it.context, Class.forName(mData[adapterPosition].name)))
                }
            }
        }
    }
}
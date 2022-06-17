package com.youxiang8727.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.youxiang8727.kotlinpractice.Database.Word
import com.youxiang8727.kotlinpractice.ViewModels.RoomTestViewModel
import com.youxiang8727.kotlinpractice.databinding.ActivityRoomTestBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class RoomTestActivity : AppCompatActivity() {
    private val viewModel: RoomTestViewModel by viewModels()
    private lateinit var binding: ActivityRoomTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter: WordListAdapter = WordListAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        viewModel.getAllWordsLiveData().observe(this){
            adapter.setData(it)
        }

        binding.btnAdd.setOnClickListener{
            GlobalScope.launch {
                viewModel.insertWord(Word(chinese = "測試", english = "TEST"))
            }
        }
    }

    inner class WordListAdapter: RecyclerView.Adapter<WordListAdapter.ViewHolder>() {
        private var mData: List<Word> = arrayListOf<Word>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_word, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val word: Word = mData[position]
            holder.text_view_word_id.text = word.id.toString()
            holder.text_view_word_english.text = word.english
            holder.text_view_word_chinese.text = word.chinese
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        fun setData(data: List<Word>){
            mData = data
            notifyDataSetChanged()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val text_view_word_id: TextView = itemView.findViewById(R.id.text_view_word_id)
            val text_view_word_english: TextView = itemView.findViewById(R.id.text_view_word_english)
            val text_view_word_chinese: TextView = itemView.findViewById(R.id.text_view_word_chinese)
        }
    }
}
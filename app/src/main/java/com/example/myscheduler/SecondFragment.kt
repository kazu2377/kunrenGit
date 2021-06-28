package com.example.myscheduler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myscheduler.databinding.FragmentSecondBinding
import java.util.*

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    // アダプターにセットするためのサンプルデータを作成するメソッド
    private fun createDummyBookList(): MutableList<Book> {
        var bookList: MutableList<Book> = ArrayList()
        var book = Book("ほあんさん", 5656, "2020/11/24")

        // 20件のサンプルーデータを登録
        var i = 0
        while (i < 20) {
            i++
            bookList.add(book)
        }
        return bookList
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = arguments?.getString("BUNDLE_KEY_TITLE") // "タイトル"

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // タイトルをセット
        activity?.title = "書籍情報一覧"

        // レイアウト要素RecyclerViewを取得
        val bookListRecyclerView = view.findViewById<RecyclerView>(R.id.list)
        // LayoutManagerを取得
        val linearLayoutManager = LinearLayoutManager(view.context)
        // ダミーデータをセットしたアダプターを作成
        val adapter = BookListRecyclerViewAdapter(createDummyBookList())

        // linearLayoutManager と adapter をRecyclerViewにセット
        bookListRecyclerView.layoutManager = linearLayoutManager
        bookListRecyclerView.adapter = adapter

        // 一覧画面の各セルの区切り線を作成
        bookListRecyclerView.addItemDecoration(
            DividerItemDecoration(
                view.context,
                linearLayoutManager.orientation
            )
        )

        return view

//        _binding = FragmentSecondBinding.inflate(inflater, container, false)
//
//        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
//
//        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//
//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

//        (activity as? MainActivity)?.setFabVisible(View.VISIBLE)
//        binding.list.layoutManager = LinearLayoutManager(context)
//        var dateTime = Calendar.getInstance().apply {
//
//        }
//        findSchedule(
//            dateTime.get(Calendar.YEAR),
//            dateTime.get(Calendar.MONTH),
//            dateTime.get(Calendar.DAY_OF_MONTH)
//        )

}

//    private fun findSchedule(
//        year: Int,
//        month: Int,
//        dayOfMonth: Int
//    ) {
//        var selectDate = Calendar.getInstance().apply {
//            clear()
//            set(year, month, dayOfMonth)
//        }
//        val schedules = realm.where<Schedule>()
//            .between(
//                "date",
//                selectDate.time,
//                selectDate.apply {
//                    add(Calendar.DAY_OF_MONTH, 1)
//                    add(Calendar.MILLISECOND, -1)
//                }.time
//            ).findAll().sort("date")
//        val adapter = ScheduleAdapter(schedules)
//        binding.list.adapter = adapter
//
//        adapter.setOnItemClickListener { id ->
//            id?.let {
//                val action = SecondFragmentDirections
//                    .actionToScheduleEditFragment(it)
//                findNavController().navigate(action)
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        realm.close()
//    }

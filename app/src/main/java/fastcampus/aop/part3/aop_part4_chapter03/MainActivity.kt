package fastcampus.aop.part3.aop_part4_chapter03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import fastcampus.aop.part3.aop_part4_chapter03.databinding.ActivityMainBinding
import fastcampus.aop.part3.aop_part4_chapter03.model.LocationLatLngEntity
import fastcampus.aop.part3.aop_part4_chapter03.model.SearchResultEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initView()
        setData()
    }

    private fun initAdapter() {
        adapter = SearchRecyclerAdapter()
    }

    private fun initView() = with(binding) {
        emptyResultText.isVisible = false
        recyclerView.adapter = adapter

    }

    private fun initData() {
        adapter.notifyDataSetChanged()
    }

    private fun setData() {
        val dataList = (0..10).map {
            SearchResultEntity (
                name = "빌딩 $it",
                fullAdress = "주소 $it",
                locationLatLng = LocationLatLngEntity(
                     it.toFloat(),
                    it.toFloat()
                )
                    )
        }
        adapter.setSearchResultList(dataList) {
            Toast.makeText(this, "빌딩이름 : ${it.name} 주소 : ${it.fullAdress}", Toast.LENGTH_SHORT).show()
        }
    }
}
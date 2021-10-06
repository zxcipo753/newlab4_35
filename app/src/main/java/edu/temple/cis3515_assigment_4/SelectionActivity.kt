package edu.temple.cis3515_assigment_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dogdata: Array<ImageObject> = getData()
        val recycle = findViewById<RecyclerView>(R.id.rcvView) as RecyclerView
        val detailActivityIntent = Intent(this,DisplayActivity::class.java)
        //var text = findViewById<TextView>(R.id.dog)
        //var image = findViewById<ImageView>(R.id.mainImageView)
        var adapter =ImageAdapter(dogdata)
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                detailActivityIntent.putExtra("name",dogdata[position].description)
                detailActivityIntent.putExtra("image",dogdata[position].resourceId)
                startActivity(detailActivityIntent)
            }
        })
        recycle.layoutManager = GridLayoutManager(this,3)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("chihuahua", R.drawable.chihuahua),
            ImageObject("dashshund",R.drawable.dashshund),
            ImageObject("doberman", R.drawable.doberman),
            ImageObject("goldenretriever",R.drawable.goldenretriever),
            ImageObject("bulldog",R.drawable.bulldog),
            ImageObject("pomeranian",R.drawable.pomeranian),
            ImageObject("havanese",R.drawable.havanese),
            ImageObject("corgi",R.drawable.corgi),
            ImageObject("bernesemountain",R.drawable.bernesemountain),
            ImageObject("bodercollie",R.drawable.bodercollie))

    }

}
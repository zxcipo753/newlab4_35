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
        val dognames = resources.getStringArray(R.array.dog_names)
        return arrayOf(ImageObject(dognames[0], R.drawable.chihuahua),
            ImageObject(dognames[1],R.drawable.dashshund),
            ImageObject(dognames[2], R.drawable.doberman),
            ImageObject(dognames[3],R.drawable.goldenretriever),
            ImageObject(dognames[4],R.drawable.bulldog),
            ImageObject(dognames[5],R.drawable.pomeranian),
            ImageObject(dognames[6],R.drawable.havanese),
            ImageObject(dognames[7],R.drawable.corgi),
            ImageObject(dognames[8],R.drawable.bernesemountain),
            ImageObject(dognames[9],R.drawable.bodercollie))

    }

}
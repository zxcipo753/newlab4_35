package edu.temple.cis3515_assigment_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val arrayImageObject: Array<ImageObject>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    private lateinit var myListner: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListner = listener
    }
    //try
    //try 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val mangaView = inflater.inflate(R.layout.rcv_itemcontainer,parent,false)
        return ViewHolder(mangaView,myListner)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        val dog: ImageObject = arrayImageObject[position]

        val imageViews = holder.imageView
        imageViews.setImageResource(dog.resourceId)

    }

    override fun getItemCount(): Int {
        return arrayImageObject.size
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.rcvImageView)

        init{
            itemView.setOnClickListener(){
                listener.onItemClick(adapterPosition)
            }
        }

    }
}


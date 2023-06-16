package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter (private val context: Context, private val barang: List<BarangClass>, val listener: (BarangClass) -> Unit)
    : RecyclerView.Adapter<HomeAdapter.BarangViewHolder>(){
    class BarangViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val barangimg = view.findViewById<ImageView>(R.id.image_harga)
        val barangname = view.findViewById<TextView>(R.id.name_harga)

        fun bindView(barang: BarangClass, listener: (BarangClass) -> Unit){
            barangimg.setImageResource(barang.barangimg)
            barangname.text = barang.barangname
            itemView.setOnClickListener{
                (listener(barang))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        return BarangViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        holder.bindView(barang[position], listener)
    }

    override fun getItemCount(): Int = barang.size

}
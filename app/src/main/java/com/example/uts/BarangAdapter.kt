package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarangAdapter (private val context: Context, private val barang: List<BarangClass>, val listener: (BarangClass) -> Unit)
    : RecyclerView.Adapter<BarangAdapter.BarangViewHolder>(){
    class BarangViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val barangimg = view.findViewById<ImageView>(R.id.image)
        val barangname = view.findViewById<TextView>(R.id.tv_name)
        val barangharga = view.findViewById<TextView>(R.id.tv_date)
        val barangdeskripsi = view.findViewById<TextView>(R.id.tv_author)


        fun bindView(barang: BarangClass, listener: (BarangClass) -> Unit){
            barangimg.setImageResource(barang.barangimg)
            barangname.text = barang.barangname
            barangharga.text = barang.barangharga
            barangdeskripsi.text = barang.barangdeskripsi
            itemView.setOnClickListener{
                (listener(barang))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        return BarangViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        holder.bindView(barang[position], listener)
    }

    override fun getItemCount(): Int = barang.size

}
package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val youtube = findViewById<Button>(R.id.button)
        youtube.setOnClickListener {
            val url = "https://citraweb.com/index_produk/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
            }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val barang = intent.getParcelableExtra<BarangClass>(MainActivity.INTENT_PARCELABLE)

        val barangimg = findViewById<ImageView>(R.id.image)
        val barangname = findViewById<TextView>(R.id.tv_name)
        val barangharga = findViewById<TextView>(R.id.tv_date)
        val barangdeskripsi = findViewById<TextView>(R.id.tv_author)

        barangimg.setImageResource(barang?.barangimg!!)
        barangname.text = barang.barangname
        barangharga.text = barang.barangharga
        barangdeskripsi.text = barang.barangdeskripsi

    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}
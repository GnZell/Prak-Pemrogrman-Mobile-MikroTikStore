package com.example.uts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeList: List<BarangClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_home)
        recyclerView.setHasFixedSize(true)
        adapter = HomeAdapter(requireContext(), homeList) { BarangClass ->
            // Tidak ada aksi yang dilakukan, pesan toast dihapus
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }

    private fun dataInitialize() {

        homeList = listOf<BarangClass>(
            BarangClass(
                R.drawable.barang1,
                barangname = "Router Indoor",
                barangharga = "Rp 1.902.000,00",
                barangdeskripsi = "Routerboard RB450Gx4 (716MHz Quad Core CPU, 1 GB DDR RAM, 512MB NAND Storage) dengan RouterOS (Level 5) dalam kemasan kotak indoor yang ringkas, 5 (lima) buah port gigabit 10/100/1000, dan slot mikro-SD. Tidak bisa dipasangkan wireless card. Sudah termasuk 1 buah adaptor 24 Volt.",
            ),
            BarangClass(
                R.drawable.barang8,
                barangname = "hEX",
                barangharga = "Rp 905.000,00",
                barangdeskripsi = "RB951Ui-2HND memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port ethernet, 1 buah access point embedded 2,4 GHz MIMO, antenna embedded 2,5 dbi, dan satu buah port USB. Sudah termasuk power adaptor. PoE out 24v di ether 5. ",
            ),
            BarangClass(
                R.drawable.barang4,
                barangname = "hAP",
                barangharga = "Rp 1.207.000,00",
                barangdeskripsi = "RB951G-2HND memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port gigabit ethernet, 1 buah access point embedded 2,4 GHz MIMO, antenna embedded 2,5 dbi, dan satu buah port USB. Sudah termasuk power adaptor. ",
            )
        )
    }
}
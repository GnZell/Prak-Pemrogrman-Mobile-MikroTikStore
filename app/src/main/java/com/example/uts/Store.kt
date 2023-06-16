package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Store.newInstance] factory method to
 * create an instance of this fragment.
 */
class Store : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: BarangAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var BarangList: List<BarangClass>

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
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Store.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Store().apply {
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
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        adapter = BarangAdapter(requireContext(), BarangList) { BarangClass ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, BarangClass)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager


    }

    private fun dataInitialize() {

        BarangList = listOf<BarangClass>(
            BarangClass(
                R.drawable.barang1,
                barangname = "Router Indoor RB450Gx4",
                barangharga = "Rp 1.902.000,00",
                barangdeskripsi = "Routerboard RB450Gx4 (716MHz Quad Core CPU, 1 GB DDR RAM, 512MB NAND Storage) dengan RouterOS (Level 5) dalam kemasan kotak indoor yang ringkas, 5 (lima) buah port gigabit 10/100/1000, dan slot mikro-SD. Tidak bisa dipasangkan wireless card. Sudah termasuk 1 buah adaptor 24 Volt.",
            ),
            BarangClass(
                R.drawable.barang2,
                barangname = "RB951Ui-2HnD",
                barangharga = "Rp 905.000,00",
                barangdeskripsi = "RB951Ui-2HND memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port ethernet, 1 buah access point embedded 2,4 GHz MIMO, antenna embedded 2,5 dbi, dan satu buah port USB. Sudah termasuk power adaptor. PoE out 24v di ether 5. ",
            ),
            BarangClass(
                R.drawable.barang3,
                barangname = "RB951G-2HnD",
                barangharga = "Rp 1.207.000,00",
                barangdeskripsi = "RB951G-2HND memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port gigabit ethernet, 1 buah access point embedded 2,4 GHz MIMO, antenna embedded 2,5 dbi, dan satu buah port USB. Sudah termasuk power adaptor. ",
            ),
            BarangClass(
                R.drawable.barang4,
                barangname = "RB962UiGS-5HacT2HnT",
                barangharga = "Rp 1.941.000,00",
                barangdeskripsi = "RB962UiGS-5HacT2HnT memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port ethernet, 1 buah access point Dual Band 2,4 GHz dan 5Ghz MIMO, antenna embedded 2 dbi, satu buah port USB serta SFP Port. Sudah termasuk power adaptor. PoE out 24v di ether 5.",
            ),
            BarangClass(
                R.drawable.barang5,
                barangname = "RB952Ui-5ac2nD",
                barangharga = "Rp 863.000,00",
                barangdeskripsi = "RB952Ui-5ac2nD memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port ethernet, 1 buah access point Dual Band 2,4 GHz dan 5Ghz MIMO, antenna embedded 2,5 dbi, dan satu buah port USB. Sudah termasuk power adaptor. PoE out 24v di ether 5. ",
            ),
            BarangClass(
                R.drawable.barang6,
                barangname = "RB941-2nD-TC",
                barangharga = "Rp 372.000,00",
                barangdeskripsi = "RB941-2nD memiliki semua kebutuhan router dan gateway untuk segala kondisi jaringan. Memiliki 4 buah port ethernet, 1 buah access point embedded 2,4 GHz, antenna embedded 2x1,5 dbi. Sudah termasuk power adaptor.\n" +
                        "-RB941-2nD hanya support Winbox 3.x\n" +
                        "-tidak support PoE-in\n" +
                        "-belum bisa diinstall Usermanager",
            ),
            BarangClass(
                R.drawable.barang7,
                barangname = "RB951Ui-2nD",
                barangharga = "Rp 669.000,00",
                barangdeskripsi = "RB951Ui-2nD memiliki semua kebutuhan router dan gateway untuk personal dan kantor. Memiliki 5 buah port ethernet, 1 buah access point embedded 2,4 GHz, antenna embedded 1,5 dbi dan USB port. Sudah termasuk power adaptor. ",
            ),
            BarangClass(
                R.drawable.barang8,
                barangname = "RB941-2nD",
                barangharga = "Rp 372.000,00",
                barangdeskripsi = "RB941-2nD memiliki semua kebutuhan router dan gateway untuk segala kondisi jaringan. Memiliki 4 buah port ethernet, 1 buah access point embedded 2,4 GHz, antenna embedded 2x1,5 dbi. Sudah termasuk power adaptor.\n" +
                        "RB941-2nD hanya support Winbox 3.x dan tidak support PoE-in\n",
            ),
            BarangClass(
                R.drawable.barang9,
                barangname = "RB750UPr2",
                barangharga = "Rp 949.000,00",
                barangdeskripsi = "Dengan RB750UPr2 kita bisa menyalurkan daya via PoE ke perangkat routerboard lainnya (via ether2 hingga ether5). Memiliki 5 buah port ethernet dan satu buah port USB, disertai lisensi routerOS level 4.l",
            ),
            BarangClass(
                R.drawable.barang10,
                barangname = "RB750r2",
                barangharga = "Rp 678.000,00",
                barangdeskripsi = "hEX (RB750r2) sesuai namanya adalah produk generasi kedua dari RB750. Masih sama dengan pendahulunya yang bentuknya mungil dan Memiliki 5 buah port ethernet 10/100, dengan prosesor baru Qualcom 850MHz. Sudah termasuk dengan lisensi level 4 dan adaptor 12V. Perangkat ini cocok digunakan di jaringan rumah dan SOHO.",
            )
        )
    }

}
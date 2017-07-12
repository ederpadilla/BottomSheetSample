package androiddeveloper.eder.padilla.bottomsheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnBusSelected{


    var busList = ArrayList<Bus>()

    val adapter = RecyclerAdapter(busList,this@MainActivity,this@MainActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showBSDialog()
        initRecycler()

    }

    private fun showBSDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null)
        val mRecyclerViewBus = view.findViewById(R.id.mRecyclerViewBus) as RecyclerView
        mRecyclerViewBus.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        mRecyclerViewBus.setHasFixedSize(true)
        mRecyclerViewBus.adapter=adapter
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    private fun initRecycler() {
        busList.add(Bus(1,"","",""))
        busList.add(Bus(2,"","",""))
        busList.add(Bus(3,"","",""))
        busList.add(Bus(4,"","",""))
        busList.add(Bus(5,"","",""))
        busList.add(Bus(6,"","",""))
        busList.add(Bus(7,"","",""))
        busList.add(Bus(8,"","",""))
        adapter.notifyDataSetChanged()
    }

    override fun onBusSelected(bus: Bus) {
        Log.e("click","${bus.toString()}")
    }

}

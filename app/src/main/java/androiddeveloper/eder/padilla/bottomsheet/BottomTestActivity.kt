package androiddeveloper.eder.padilla.bottomsheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.widget.TextView
import androiddeveloper.eder.padilla.bottomsheet.lib.BottomSheetBehaviorGoogleMapsLike
import android.support.annotation.NonNull
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View


class BottomTestActivity : AppCompatActivity(),OnBusSelected {

    internal var bottomSheetTextView: TextView?=null
    var busList = ArrayList<Bus>()
    val adapter = RecyclerAdapter(busList,this@BottomTestActivity,this@BottomTestActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_test)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = " Test Bottom "
        }
        val coordinatorLayout = findViewById(R.id.coordinatorlayout) as CoordinatorLayout
        val bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet)
        val mRecyclerViewBus = bottomSheet.findViewById(R.id.mRecyclerViewBus) as RecyclerView
        initRecycler(mRecyclerViewBus)
        val behavior = BottomSheetBehaviorGoogleMapsLike.from(bottomSheet)
        behavior.state = BottomSheetBehaviorGoogleMapsLike.STATE_COLLAPSED
        behavior.addBottomSheetCallback(object : BottomSheetBehaviorGoogleMapsLike.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
               // when (newState) {
               //     BottomSheetBehaviorGoogleMapsLike.STATE_COLLAPSED -> Log.d("bottomsheet-", "STATE_COLLAPSED")
               //     BottomSheetBehaviorGoogleMapsLike.STATE_DRAGGING -> Log.d("bottomsheet-", "STATE_DRAGGING")
               //     BottomSheetBehaviorGoogleMapsLike.STATE_EXPANDED -> Log.d("bottomsheet-", "STATE_EXPANDED")
               //     BottomSheetBehaviorGoogleMapsLike.STATE_ANCHOR_POINT -> Log.d("bottomsheet-", "STATE_ANCHOR_POINT")
               //     BottomSheetBehaviorGoogleMapsLike.STATE_HIDDEN -> Log.d("bottomsheet-", "STATE_HIDDEN")
               //     else -> Log.d("bottomsheet-", "STATE_SETTLING")
               // }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
        //val behaviorTest = BottomSheetBehavior.from(bottomSheet)
        //behaviorTest.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
        //    override fun onStateChanged(bottomSheet: View, newState: Int) {
        //        if (newState == BottomSheetBehavior.STATE_DRAGGING) {
        //            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        //        }
        //    }
//
        //    override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        //})
    }

    private fun initRecycler(mRecyclerViewBus: RecyclerView) {
        mRecyclerViewBus.layoutManager = LinearLayoutManager(this@BottomTestActivity, LinearLayoutManager.VERTICAL, false)
        mRecyclerViewBus.setHasFixedSize(true)
        mRecyclerViewBus.adapter=adapter
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
        Log.e("bus"," select ${bus.toString()}")
    }

}

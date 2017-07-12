package androiddeveloper.eder.padilla.bottomsheet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.bus_item.view.*
/**
 * Created by ederpadilla on 28/06/17.
 */
class RecyclerAdapter(private val notesList: List<Bus>, private var context: Context?, private val onBusSelected: OnBusSelected) : RecyclerView.Adapter<RecyclerAdapter.ViewHolderAdapter>(), View.OnClickListener {

    private val listener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {

        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.bus_item, parent, false)
        val viewholder = ViewHolderAdapter(view)
        return viewholder
    }

    fun setOnClickListener(listener: View.OnClickListener) {}
    override fun onClick(view: View) {
        listener?.onClick(view)
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        val item = notesList[position]
        holder.bindTexts(item)
        holder.rootView.setOnClickListener { view -> onBusSelected.onBusSelected(notesList[position]) }

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    inner class ViewHolderAdapter(internal var rootView: View) : RecyclerView.ViewHolder(rootView) {

        fun bindTexts(bus: Bus) {
            itemView?.let {
                with(itemView) {
                    when (bus.idBusStatus) {
                        1 -> {
                            mTvState.text ="Apoyo en camino"
                            mImageState.setImageResource(R.mipmap.apoyoencamino)
                        }
                        2 -> {
                            mTvState.text ="Apoyo realizado"
                            mImageState.setImageResource(R.mipmap.apoyorealizado)
                        }
                        3 -> {
                            mTvState.text ="Comezando viaje"
                            mImageState.setImageResource(R.mipmap.comenzandoviaje)
                        }
                        4 -> {
                            mTvState.text ="No hay viajes"
                            mImageState.setImageResource(R.mipmap.nohayviajes)
                        }
                        5 -> {
                            mTvState.text ="Retraso por averia"
                            mImageState.setImageResource(R.mipmap.retrasoporaveria)
                        }
                        6 -> {
                            mTvState.text ="Retraso por colision"
                            mImageState.setImageResource(R.mipmap.retrasoporcolision)
                        }
                        7 -> {
                            mTvState.text ="Retraso por trafico"
                            mImageState.setImageResource(R.mipmap.retrasoportrafico)
                        }
                        8 -> {
                            mTvState.text ="Viaje terminado"
                            mImageState.setImageResource(R.mipmap.viajeterminado)
                        }

                    }
                }
            }
        }
    }

}

package julien.vermet.techtest.presentation.features.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import julien.vermet.techtest.presentation.databinding.ViewListItemBinding
import julien.vermet.techtest.presentation.model.AlbumUI

class ListAdapter(context: Context, private val onItemClick: (AlbumUI) -> Unit) : RecyclerView.Adapter<ListItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    var items = emptyList<AlbumUI>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ViewListItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount() = items.size


}
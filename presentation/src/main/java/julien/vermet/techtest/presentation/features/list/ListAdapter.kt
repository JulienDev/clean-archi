package julien.vermet.techtest.presentation.features.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import julien.vermet.techtest.presentation.databinding.ViewListItemBinding
import julien.vermet.techtest.presentation.model.AlbumUI

class ListAlbumAdapter(
    context: Context,
    private val onItemClick: (AlbumUI) -> Unit
) : ListAdapter<AlbumUI, ListItemViewHolder>(ListAlbumCallback()) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ViewListItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

}

class ListAlbumCallback : DiffUtil.ItemCallback<AlbumUI>() {
    override fun areItemsTheSame(oldItem: AlbumUI, newItem: AlbumUI): Boolean {
        return oldItem.id == newItem.id;
    }

    override fun areContentsTheSame(oldItem: AlbumUI, newItem: AlbumUI): Boolean {
        return oldItem == newItem
    }
}
package julien.vermet.techtest.presentation.features.list

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import julien.vermet.techtest.designsystem.AlbumListItemView
import julien.vermet.techtest.designsystem.AlbumListItemViewModel
import julien.vermet.techtest.presentation.model.AlbumUI

class ListAlbumAdapter(
    private val context: Context,
    private val onItemClick: (AlbumUI) -> Unit
) : ListAdapter<AlbumUI, ListItemViewHolder>(ListAlbumCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = AlbumListItemView(context)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = getItem(position)
        val view = holder.itemView as AlbumListItemView
        val viewModel = AlbumListItemViewModel(item.url, item.title)
        view.setModel(viewModel)
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
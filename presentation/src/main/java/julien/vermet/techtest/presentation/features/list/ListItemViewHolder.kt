package julien.vermet.techtest.presentation.features.list

import androidx.recyclerview.widget.RecyclerView
import coil.load
import julien.vermet.techtest.presentation.databinding.ViewListItemBinding
import julien.vermet.techtest.presentation.model.AlbumUI

class ListItemViewHolder(private val binding : ViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(album : AlbumUI) {
        binding.itemImage.load(album.url)
        binding.itemTitle.text = album.title
    }

}
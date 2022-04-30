package com.mlhysrszn.ibuy.ui.favorites

import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.databinding.FragmentFavoritesBinding
import com.mlhysrszn.ibuy.ui.favorites.adapter.FavoriteAdapter

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private lateinit var adapter: FavoriteAdapter
    private val viewModel: FavoritesViewModel by viewModels()

    override fun layoutId(): Int = R.layout.fragment_favorites

    override fun initUI() {
        viewModel.favoritesList.observe(viewLifecycleOwner) {
            adapter = FavoriteAdapter(it)
            binding.rvFavorites.adapter = adapter
        }
    }
}
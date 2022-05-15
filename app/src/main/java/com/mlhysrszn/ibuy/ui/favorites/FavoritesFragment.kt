package com.mlhysrszn.ibuy.ui.favorites

import androidx.fragment.app.viewModels
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.local.AppDatabase
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.databinding.FragmentFavoritesBinding
import com.mlhysrszn.ibuy.ui.favorites.adapter.FavoriteAdapter

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private val adapter: FavoriteAdapter by lazy { FavoriteAdapter() }

    override fun layoutId(): Int = R.layout.fragment_favorites

    override fun initUI() {
        val productsDao = AppDatabase.getFavoritesDatabase(requireContext())?.productsDao()
        val repository = ProductRepository(productsDao)
        val viewModel: FavoritesViewModel by viewModels {
            FavoritesViewModelFactory(repository)
        }
        viewModel.favoritesList.observe(viewLifecycleOwner) {
            adapter.favoritesList = it
            binding.rvFavorites.adapter = adapter
        }

        adapter.onClick = {
            viewModel.deleteFromFav(it)

            viewModel.favoritesList.observe(viewLifecycleOwner) { list ->
                adapter.favoritesList = list
                binding.rvFavorites.adapter = adapter
            }
        }
    }
}
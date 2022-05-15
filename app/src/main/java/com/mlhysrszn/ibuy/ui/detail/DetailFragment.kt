package com.mlhysrszn.ibuy.ui.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.mlhysrszn.ibuy.R
import com.mlhysrszn.ibuy.base.BaseFragment
import com.mlhysrszn.ibuy.data.local.AppDatabase
import com.mlhysrszn.ibuy.data.model.Product
import com.mlhysrszn.ibuy.data.repository.ProductRepository
import com.mlhysrszn.ibuy.databinding.FragmentDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override fun layoutId(): Int = R.layout.fragment_detail

    override fun initUI() {

        val productsDao = AppDatabase.getFavoritesDatabase(requireContext())?.productsDao()
        val repository = ProductRepository(productsDao)
        val viewModel: DetailViewModel by viewModels {
            DetailViewModelFactory(repository)
        }

        lateinit var product: Product
        arguments?.let {
            product = DetailFragmentArgs.fromBundle(it).product
            binding.product = product
        }
        if (product.status == 1) {
            binding.buttonAddBasket.text = "Remove from basket"
        }
        binding.imageAddFav.setOnClickListener {
            if (viewModel.isFavorite(product.id)) {
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.deleteFromFav(viewModel.convertToEntity(product))
                }
                binding.imageAddFav.setImageResource(R.drawable.ic_favorite_border)
            } else {
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.addToFav(viewModel.convertToEntity(product))
                }
                binding.imageAddFav.setImageResource(R.drawable.ic_faved)
            }
        }

        if (viewModel.isFavorite(product.id)) {
            binding.imageAddFav.setImageResource(R.drawable.ic_faved)
        } else {
            binding.imageAddFav.setImageResource(R.drawable.ic_favorite_border)
        }
        Glide.with(requireContext()).load(product.image).into(binding.imageViewProductImage)
    }
}
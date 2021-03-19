package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel

        binding.cancelDetailButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesFragment())
        }

        viewModel.eventDataSave.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                sharedViewModel.onSave(
                    Shoe(
                        binding.shoeNameDetailEdit.text.toString(),
                        binding.shoeSizeDetailEdit.text.toString().toDouble(),
                        binding.companyDetailEdit.text.toString(),
                        binding.descriptionDetailEdit.text.toString()
                    )
                )
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesFragment())
                viewModel.onDataSaveComplete()
            }
        })

        return binding.root
    }

}
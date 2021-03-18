package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoesFragmentBinding

class ShoesFragment : Fragment() {

    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoesFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_fragment, container, false)
        setHasOptionsMenu(true)
        
        binding.fab.setOnClickListener {
            findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}
package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoesFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoesFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoesFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_fragment, container, false)
        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { list ->
            Toast.makeText(activity, list[0].name, Toast.LENGTH_LONG).show()
        })
        
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
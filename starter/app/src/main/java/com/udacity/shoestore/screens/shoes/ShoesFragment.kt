package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.ShoesFragmentBinding

class ShoesFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoesFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoes_fragment, container, false
        )
        setHasOptionsMenu(true)
        shoeListObserver(binding)

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    private fun shoeListObserver(binding: ShoesFragmentBinding) {
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { list ->
            if (list.isNotEmpty()) {
                list.forEach { shoe ->
                    val textView = TextView(activity)
                    textView.apply {
                        text = shoe.name
                        textSize = 32f
                        gravity = Gravity.CENTER_HORIZONTAL
                    }
                    binding.shoeLayout.addView(textView)
                }
            }
        })
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
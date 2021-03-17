package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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

        binding.fab.setOnClickListener {
            Toast.makeText(activity, "Text", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
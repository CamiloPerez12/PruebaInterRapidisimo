package com.jcpd.pruebainterrapidisimo.presentation.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.databinding.LocationsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationScreen : Fragment(){

    private var _binding: LocationsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        _binding = LocationsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
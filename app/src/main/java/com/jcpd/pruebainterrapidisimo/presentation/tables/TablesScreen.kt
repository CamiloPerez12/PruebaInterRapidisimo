package com.jcpd.pruebainterrapidisimo.presentation.tables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.databinding.TablesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TablesScreen : Fragment() {

    private var _binding: TablesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        _binding = TablesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
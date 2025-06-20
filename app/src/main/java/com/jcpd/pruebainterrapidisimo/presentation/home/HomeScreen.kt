package com.jcpd.pruebainterrapidisimo.presentation.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import com.jcpd.pruebainterrapidisimo.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreen : Fragment() {

    private val homeViewModel by viewModels<HomeViewModel>()

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private var user: TextView? = null
    private var name: TextView? = null
    private var id: TextView? = null
    private var buttonTables: Button? = null
    private var buttonLocations: Button? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        observeState()

    }

    private fun observeState() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.state.collect {
                    if (it.version?.isNotBlank()==true) {
                        showVersion(it.shouldDisplayDialog)
                    }
                    if (!it.loading){
                        progressBar?.visibility = View.GONE
                    }
                    showLoginError(it.error)
                    showInfo(it.userModel)
                }
            }
        }
    }

    private fun showVersion(displayer : Boolean){
        if (displayer) {
            val dialogBuilder = AlertDialog.Builder(requireActivity())
            dialogBuilder.setMessage("La version actual del aplicativo es diferente")
                .setCancelable(true)
                .setNegativeButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Version Control")
            alert.show()
        }
    }

    private fun showLoginError(errorStatus : Boolean){
        if (errorStatus) {
            val dialogBuilder = AlertDialog.Builder(requireActivity())
            dialogBuilder.setMessage("Error al realizar el login")
                .setCancelable(true)
                .setNegativeButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("Login Control")
            alert.show()
        }
    }

    private fun showInfo(userModelResponse : UserModel?) {
        user?.text = userModelResponse?.user
        name?.text = userModelResponse?.name
        id?.text = userModelResponse?.id
    }

    private fun initializeViews() {
        user = binding.User
        name = binding.Name
        id = binding.Id
        buttonTables = binding.buttonTables
        buttonLocations = binding.buttonLocations
        progressBar = binding.progressCircular

        buttonTables?.text = "Tables"
        buttonLocations?.text = "Locations"

        buttonTables?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tableFragment)
        }

        buttonLocations?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_locationsFragment)
        }

    }
}
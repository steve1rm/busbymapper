package me.androidbox.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.mapboxsdk.Mapbox
import me.androidbox.presentation.R
import me.androidbox.presentation.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private lateinit var bindings: FragmentMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(requireContext(), requireActivity().getString(R.string.mapboxAccessToken))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindings = FragmentMapBinding.inflate(inflater, container, false)

        val mapView = bindings.mvMain
        mapView.onCreate(null)

        return bindings.root
    }
}
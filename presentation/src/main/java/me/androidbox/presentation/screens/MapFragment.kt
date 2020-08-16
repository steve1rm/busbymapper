package me.androidbox.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import me.androidbox.presentation.R
import me.androidbox.presentation.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private lateinit var bindings: FragmentMapBinding

    private
    val mapView: MapView by lazy {
        bindings.mvMain
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindings = FragmentMapBinding.inflate(inflater, container, false)

        return bindings.root
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync {
            Log.d("MAPBOX", "ONMAPREADY ${it.isDebugActive}")
        }
    }
}

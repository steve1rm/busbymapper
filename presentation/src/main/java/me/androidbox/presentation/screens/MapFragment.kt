package me.androidbox.presentation.screens

import android.Manifest
import android.Manifest.permission.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.maps.MapView
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import me.androidbox.presentation.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private lateinit var bindings: FragmentMapBinding
    private val compositeDisposable = CompositeDisposable()

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
        RxPermissions(this)
            .request(READ_PHONE_STATE)
            .subscribeBy(
                onNext = { isGranted ->
                    if(isGranted) {
                        mapView.onCreate(savedInstanceState)
                        mapView.getMapAsync {
                            Log.d("MAPBOX", "ONMAPREADY ${it.isDebugActive}")
                        }
                    }
                },
                onError = { Log.e("", it.localizedMessage) }
            )
            .addTo(compositeDisposable)
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }
}

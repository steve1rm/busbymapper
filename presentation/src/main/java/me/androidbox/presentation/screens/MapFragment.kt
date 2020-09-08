package me.androidbox.presentation.screens

import android.Manifest
import android.Manifest.permission.*
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.LocationRequest
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import me.androidbox.presentation.databinding.FragmentMapBinding
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider

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
        mapView.onCreate(savedInstanceState)
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
            .request(READ_PHONE_STATE, ACCESS_FINE_LOCATION)
            .subscribeBy(
                onNext = { isGranted ->
                    if(isGranted) {
                        getLocation()
                    }
                },
                onError = { Log.e("", it.localizedMessage ?: "") }
            )
            .addTo(compositeDisposable)


    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            ReactiveLocationProvider(requireContext())
                .getUpdatedLocation(buildLocationRequest())
                .subscribeBy(
                    onNext = { location ->
                        Log.d(MapFragment::class.java.name, "${location.latitude}  ${location.longitude}")

                        mapView.getMapAsync {
                            Log.d("MAPBOX", "ONMAPREADY ${it.isDebugActive}")

                            val cameraPosition = CameraPosition.Builder().apply {
                                target(LatLng(location.latitude, location.longitude))
                            }.build()

                            it.cameraPosition = cameraPosition
                      //      it.setStyle(Style.OUTDOORS)
                            it.setStyle(Style.Builder().fromUri("mapbox://styles/mapbox/cjf4m44iw0uza2spb3q0a7s41"))
                            it.getLatLngBoundsZoomFromCamera(cameraPosition)
                        }

                    },
                    onError = {
                        Log.e(MapFragment::class.java.name, it.localizedMessage ?: "")
                    }
                ).addTo(compositeDisposable)
        }
    }

    private fun buildLocationRequest(): LocationRequest {
        return LocationRequest
            .create()
            .apply {
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                numUpdates = 1
                interval = 1 * 1_000L
                fastestInterval = 1 * 1_000L
            }
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        mapView.onDestroy()
        super.onDestroyView()
    }
}

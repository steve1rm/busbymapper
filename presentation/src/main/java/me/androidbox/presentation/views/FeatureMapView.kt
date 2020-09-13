package me.androidbox.presentation.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import me.androidbox.presentation.R

class FeatureMapView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private lateinit var tvFeatureName: TextView
    private lateinit var ivFeatureIcon: ImageView
    private lateinit var flBackground: FrameLayout

    init {
        if(!isInEditMode) {
            val view = View.inflate(context, R.layout.feature_map_view, this)
            tvFeatureName = view.findViewById(R.id.tvFeatureName)
            ivFeatureIcon = view.findViewById(R.id.ivFeatureIcon)
            flBackground = view.findViewById(R.id.flBackground)

            background = ContextCompat.getDrawable(context, R.drawable.condition_bg)
            val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.FeatureMapView)

            setBackground(attributes)
            setupCornerRadius(attributes)
            setFeatureName(attributes)
            setFeatureIcon(attributes)
            attributes.recycle()
        }
    }

    private fun setBackground(styleAttributes: TypedArray) {
        flBackground.background = ContextCompat.getDrawable(context, R.drawable.condition_bg)
    }

    private fun setFeatureIcon(styleAttributes: TypedArray) {
        ivFeatureIcon.setImageResource(styleAttributes.getResourceId(R.styleable.FeatureMapView_featureIcon, R.drawable.ic_logo))
    }

    private fun setFeatureName(styleAttributes: TypedArray) {
        tvFeatureName.text = styleAttributes.getString(R.styleable.FeatureMapView_featureName)
        tvFeatureName.background = styleAttributes.getDrawable(R.styleable.FeatureMapView_featureNameBackground)
    }

    private fun setupCornerRadius(styleAttributes: TypedArray) {
        val frameLayoutDrawable = flBackground.background.mutate()

        if(frameLayoutDrawable is GradientDrawable) {
            val topStartRadius = styleAttributes.getDimensionPixelSize(
                R.styleable.FeatureMapView_topStartRadius, 0).toFloat()
            val topEndRadius = styleAttributes.getDimensionPixelSize(
                R.styleable.FeatureMapView_topEndRadius, 0).toFloat()
            val bottomStartRadius = styleAttributes.getDimensionPixelSize(
                R.styleable.FeatureMapView_bottomStartRadius, 0).toFloat()
            val bottomEndRadius = styleAttributes.getDimensionPixelSize(
                R.styleable.FeatureMapView_bottomEndRadius, 0).toFloat()
            val radius = styleAttributes.getDimensionPixelSize(
                R.styleable.FeatureMapView_featureRadius, 0).toFloat()

            if(radius != 0F) {
                frameLayoutDrawable.cornerRadius = radius
            }
            else {
                val radiusFloatArray = floatArrayOf(
                    topStartRadius,
                    topStartRadius,
                    topEndRadius,
                    topEndRadius,
                    bottomStartRadius,
                    bottomStartRadius,
                    bottomEndRadius,
                    bottomEndRadius)

                frameLayoutDrawable.cornerRadii = radiusFloatArray
            }
        }
    }
}
package com.example.learning.lifecycleobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learning.R

class LifeCycleObserverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_observer_acticity)
        lifecycle.addObserver(LifeCycle())
    }
}
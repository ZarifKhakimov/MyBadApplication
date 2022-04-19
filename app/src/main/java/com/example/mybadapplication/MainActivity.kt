package com.example.mybadapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.mybadapplication.lodem.Rush

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.toString()

    var tv_home //int LAUNCH_DETAIL = 22;
            : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val rush = Rush(14, "Zarifjon")
            Log.d(TAG, "rush")
            tv_home?.setText(rush.toString())
        }
    }

    fun initViews() {
        tv_home = findViewById(R.id.b_one)
        val b_one = findViewById<Button>(R.id.b_one)
        b_one.setOnClickListener {
            val rush = Rush(14, "Zarifjon")
            openDetailActivity(rush)
        }
        if (intent.hasExtra("crush")) {
            val quora = intent.getParcelableExtra<Parcelable>("crush")
            Log.d(TAG, quora.toString())
            tv_home?.setText(quora.toString())
        }
    }

    fun openDetailActivity(rush: Rush) {
        val intent = Intent(this, DataActivity::class.java)
        intent.putExtra("rush",  rush)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
    }

}

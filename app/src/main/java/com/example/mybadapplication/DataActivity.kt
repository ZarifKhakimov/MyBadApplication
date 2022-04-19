package com.example.mybadapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.mybadapplication.lodem.Crush

class DataActivity : AppCompatActivity() {
    val TAG: String = DataActivity::class.java.toString()

    var tv_thing: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val crush = Crush(1.3, "Now")
            Log.d(TAG, "crush")
            tv_thing?.setText(crush.toString())
        }
    }

    fun initViews() {
        tv_thing = findViewById(R.id.tv_thing)
        val b_close = findViewById<Button>(R.id.b_close)
        b_close.setOnClickListener {
            val crush = Crush(1.6, "Big")
            backToFinish(crush)
        }
        val field = intent.getParcelableExtra<Parcelable>("rush")
        Log.d(TAG, field.toString())
        tv_thing?.setText(field.toString())
    }

    fun backToFinish(crush: Crush) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("crush", crush)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
        finish()
    }
}
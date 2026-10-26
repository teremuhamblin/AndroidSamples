package com.androidsamples.provisioningqr

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidsamples.provisioningqr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val payload = ProvisioningPayload.default()
        val qrBitmap: Bitmap = QrGenerator.generate(payload.toJson())

        binding.qrImage.setImageBitmap(qrBitmap)
    }
}

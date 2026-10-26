package com.androidsamples.provisioningqr

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

object QrGenerator {

    fun generate(text: String): Bitmap {
        val writer = QRCodeWriter()
        val matrix = writer.encode(text, BarcodeFormat.QR_CODE, 800, 800)

        val bmp = Bitmap.createBitmap(800, 800, Bitmap.Config.RGB_565)
        for (x in 0 until 800) {
            for (y in 0 until 800) {
                bmp.setPixel(x, y, if (matrix[x, y]) -0x1000000 else -0x1)
            }
        }
        return bmp
    }
}

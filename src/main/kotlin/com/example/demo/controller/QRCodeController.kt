package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.io.ByteArrayOutputStream

@RestController
class QRCodeController {
    @GetMapping("/generateQRCode")
    fun generateQRCode(@RequestParam("qrCode") qrCode: String): ResponseEntity<ByteArray> {
        val width = 200
        val height = 200
        val qrCodeData = qrCode.toByteArray(Charsets.UTF_8)
        val bitMatrix = MultiFormatWriter().encode(String(qrCodeData), BarcodeFormat.QR_CODE, width, height)
        val outputStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix, MediaType.IMAGE_PNG.getSubtype(), outputStream)
        val qrCodeImage = outputStream.toByteArray()
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCodeImage)
    }
}
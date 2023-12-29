package org.example.communicationktorservertest.api

import com.varabyte.kobweb.api.ApiContext
import java.util.*

object CipheringHelper {
    private const val TRANSFORMATION = "RSA/ECB/PKCS1Padding"
    fun encrypt(context: ApiContext, data: String, publicKey: String): String? {
        context.logger.debug("encrypt: $data $publicKey")
//        val cipher = Cipher.getInstance(TRANSFORMATION).apply {
//            init(Cipher.ENCRYPT_MODE, RSAPublicKeyImpl.)
//        }
//        val result = cipher.doFinal(data.toByteArray())
        return Base64.getEncoder().encodeToString(data.encodeToByteArray())
    }
}
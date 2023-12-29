package org.example.communicationktorservertest.api

import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext

@Api("data")
suspend fun getKeyAndReturnEncryptedData(context: ApiContext) {
    val firstKey = "123"
    val secondKey = "456"
    context.logger.debug("getKeyAndReturnEncryptedData")
    try {
        val publicKey = context.req.body?.decodeToString()
        if (publicKey == null) {
            context.logger.error("Public key is null")
            context.res.status = 200
        } else {
            val encryptedDataInResponse = CipheringHelper.encrypt(context, "$firstKey $secondKey", publicKey)
            context.res.body = encryptedDataInResponse?.encodeToByteArray() ?: ByteArray(0)
        }
    } catch (e: Exception) {
        context.logger.error(e.message.toString())
        context.res.status = 500
    }
}
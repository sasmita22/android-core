package com.hiroshisasmita.android_core.extension

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import kotlin.jvm.Throws

/**
 * this helper is intended for the uri with prefix content://
 * see Uri.fileUriToFile() for the uri with prefix file://
 **/
fun Uri.extContentUriToFile(context: Context): File? {
    val inputStream = context.contentResolver.openInputStream(this) ?: return null
    val file = File(context.cacheDir, extExtractFileName(context))
    val outputStream = FileOutputStream(file)
    outputStream.write(inputStream.available())
    outputStream.close()
    return file
}

/**
* this helper is intended for the uri with prefix file://
* see Uri.contentUriToFile() for the uri with prefix content://
**/
fun Uri.extFileUriToFile(context: Context, uri: Uri): File? {
    val projection = arrayOf(MediaStore.Images.Media.DATA)
    val cursor = context.contentResolver.query(uri, projection, null, null, null) ?: return null
    val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    cursor.moveToFirst()
    val s = cursor.getString(columnIndex) ?: return null
    cursor.close()
    return File(s)
}

@Throws(IllegalStateException::class)
fun Uri.extExtractFileName(context: Context): String {
    var fileName = ""
    if (this.toString().startsWith("file:")) {
        fileName = this.path.orEmpty()
    } else { // uri.startsWith("content:")
        var cursor: Cursor? = null
        try {
            cursor = context.contentResolver.query(this, null, null, null, null)
            if (cursor != null && cursor.moveToFirst()) {
                val id: Int = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)
                if (id != -1) {
                    fileName = cursor.getString(id)
                }
            }
        } catch (e: Exception) {
            throw IllegalStateException(e.localizedMessage)
        } finally {
            cursor?.close()
        }
    }
    return fileName
}
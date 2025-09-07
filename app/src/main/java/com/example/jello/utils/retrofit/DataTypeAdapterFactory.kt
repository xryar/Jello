package com.example.jello.utils.retrofit

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class DataTypeAdapterFactory: TypeAdapterFactory {
    override fun <T : Any?> create(
        gson: Gson?,
        type: TypeToken<T>?
    ): TypeAdapter<T> {
        val lDelegate: TypeAdapter<T> = gson!!.getDelegateAdapter(this, type)
        val lElementAdapter: TypeAdapter<JsonElement> = gson.getAdapter(JsonElement::class.java)

        return object : TypeAdapter<T>() {
            override fun write(out: JsonWriter?, value: T?) {
                lDelegate.write(out, value)
            }

            override fun read(input: JsonReader?): T? {
                return lDelegate.fromJsonTree(lElementAdapter.read(input))
            }

        }
    }
}
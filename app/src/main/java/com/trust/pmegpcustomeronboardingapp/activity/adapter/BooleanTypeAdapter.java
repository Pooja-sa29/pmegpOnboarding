package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class BooleanTypeAdapter extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value);
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        JsonToken token = in.peek();
        switch (token) {
            case BOOLEAN:
                return in.nextBoolean();
            case NULL:
                in.nextNull();
                return false;
            case NUMBER:
                return in.nextInt() != 0;
            case STRING:
                String str = in.nextString();
                if (str.equalsIgnoreCase("true")) return true;
                if (str.equalsIgnoreCase("false")) return false;
                try {
                    return Integer.parseInt(str) != 0;
                } catch (Exception e) {
                    return false;
                }
            default:
                throw new IllegalStateException("Unexpected token: " + token);
        }
    }
}

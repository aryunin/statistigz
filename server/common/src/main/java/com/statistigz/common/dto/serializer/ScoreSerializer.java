package com.statistigz.common.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ScoreSerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (aDouble == null) {
            jsonGenerator.writeNull();
        } else {
            // TODO можно вынести в проперти ?
            var formatter = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance( Locale.ENGLISH ));
            formatter.setRoundingMode(RoundingMode.HALF_UP);
            jsonGenerator.writeNumber(formatter.format(aDouble));
        }
    }
}

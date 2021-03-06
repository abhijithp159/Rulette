package com.github.kislayverma.rulette.core.ruleinput.value.defaults;

import com.github.kislayverma.rulette.core.ruleinput.value.IInputValue;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

class InputDateValue implements IInputValue<Date>, Serializable {
    private static final long serialVersionUID = 5666450390675442878L;

    private final Date value;
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd");

    public InputDateValue (String value) throws Exception {
        this.value = value == null || value.isEmpty() ? null : formatter.parseDateTime(value).toDate();
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public Date getValue() {
        return this.value;
    }

    @Override
    public int compareTo(String obj) throws ParseException {
        return this.value.compareTo(formatter.parseDateTime(obj).toDate());
    }

    @Override
    public String getDataType() {
        return Date.class.getName();
    }

    @Override
    public int compareTo(IInputValue<Date> obj) {
        return this.value.compareTo(obj.getValue());
    }
}

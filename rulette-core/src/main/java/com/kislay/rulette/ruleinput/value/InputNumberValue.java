package com.kislay.rulette.ruleinput.value;

import java.io.Serializable;

public class InputNumberValue extends RuleInputValue implements IInputValue<Double>, Serializable {

    private final Double value;

    public InputNumberValue (String value) throws Exception {
        this.dataType = InputDataType.NUMBER;
        this.value = value == null || value.isEmpty() ? null : Double.parseDouble(value);
    }

    @Override
    public boolean isEmpty() {
        return this.value == null;
    }

    @Override
    public int compareTo(String obj) {
        if ((obj == null || "".equals(obj)) && (this.value == null || "".equals(this.value))) {
            return 0;
        } else if (obj == null || "".equals(obj)) {
            return 1;
        } else if (this.value == null) {
            return -1;
        } else {
            return this.value.compareTo(Double.parseDouble(obj));
        }
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}
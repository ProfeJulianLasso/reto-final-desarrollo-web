package org.sofka.mykrello.utilities;

import org.springframework.stereotype.Component;

@Component
public class MyResponseUtility {
    public Boolean error;
    public String message;
    public Object data;

    public MyResponseUtility() {
        error = false;
        message = "Success";
        data = null;
    }

    public void restart() {
        error = false;
        message = "Success";
        data = null;
    }
}

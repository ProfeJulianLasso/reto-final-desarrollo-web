package org.sofka.mykrello.utilities;

import org.springframework.stereotype.Component;

@Component //@Component es una anotación que indica que la clase es un componente de Spring.

/**
 * La clase MyResponseUtility es una clase que
 * permite generar un objeto de tipo MyResponse
 */
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

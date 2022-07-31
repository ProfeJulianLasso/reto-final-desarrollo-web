'use strict';

export class tablerosModel {
    #privateId;
    #privateName;
    #privateImage;
    #privateDescripcionTarea;
    #privateFechaCreacionTarea;



    constructor(id,name,image,descripcion,fecha) {
        debugger;
        this.#privateId = id;
        this.#privateName = name;
        this.#privateImage = image;
        this.#privateDescripcionTarea = descripcion;
        this.#privateFechaCreacionTarea = fecha;
        
    }

    get Name() {
        return this.#privateName;
    }

    set Name(name) {
        this.#privateName = name;
    }

    get Image() {
        return this.#privateImage;
    }

    set Image(image) {
        this.#privateImage = image;
    }

    get Id() {
        return this.#privateId;
    }

    set Id(id) {
        this.#privateId = id;
    }

    get DescripcionTarea() {
        return this.#privateDescripcionTarea;
    }

    set DescripcionTarea(descripcionTarea) {
        this.#privateDescripcionTarea = descripcionTarea;
    }

    get FechaCreacionTarea(){
        return this.#privateFechaCreacionTarea;
    }

    set FechaCreacionTarea(fechaCreacionTarea) {
        this.#privateFechaCreacionTarea = fechaCreacionTarea;
    }

    toString() {
        return `${this.#privateName} ${this.#privateImage}${this.#privateId}${this.#privateDescripcionTarea}${this.#privateFechaCreacionTarea}`;
    }
}
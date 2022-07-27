'use strict';

export class UserModel {
    #privateID;
    #privateNombre;
    #privateApellido;
    #privateCorreo;
    #privateTelefono;
    #privateCreado;

    constructor(data) {
        if (data) {
            this.#privateID = data.id;
            this.#privateNombre = data.nombre;
            this.#privateApellido = data.apellido;
            this.#privateCorreo = data.correo;
            this.#privateTelefono = data.telefono;
            this.#privateCreado = data.created;
        }
    }

    get ID() {
        return this.#privateID;
    }

    set ID(id) {
        this.#privateID = id;
    }

    get Nombre() {
        return this.#privateNombre;
    }

    set Nombre(nombre) {
        this.#privateNombre = nombre;
    }

    get Apellido() {
        return this.#privateApellido;
    }

    set Apellido(apellido) {
        this.#privateApellido = apellido;
    }

    get Correo() {
        return this.#privateCorreo;
    }

    set Correo(correo) {
        this.#privateCorreo = correo;
    }

    get Telefono() {
        return this.#privateTelefono;
    }

    set Telefono(telefono) {
        this.#privateTelefono = telefono;
    }

    get Creado() {
        return this.#privateCreado;
    }

    set Creado(creado) {
        this.#privateCreado = creado;
    }

    getValues() {
        return {
            id: this.#privateID,
            nombre: this.#privateNombre,
            apellido: this.#privateApellido,
            correo: this.#privateCorreo,
            telefono: this.#privateTelefono,
            creado: this.#privateCreado,
        };
    }
}
'use strict';

export class BoardModel {

    #privateID;
    #privateNombre;
    #privateCreado;
    #privateActualizado;

    constructor(data) {

        if (data != null) {
            this.#privateID = data.id;
            this.#privateNombre = data.name;
            this.#privateCreado = data.createdAt;
            this.#privateActualizado = data.updatedAt;
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

    get Creado() {
        return this.#privateCreado;
    }

    set Creado(creado) {
        this.#privateCreado = creado;
    }

    get Actualizado() {
        return this.#privateActualizado;
    }

    set Actualizado(actualizado) {
        this.#privateActualizado = actualizado;
    }

    getValues() {
        return {
            id: this.#privateID,
            nombre: this.#privateNombre,
            apellido: this.#privateCreado,
            correo: this.#privateActualizado,
        };
    }

}
'use strict';

import { FormularioUsurio } from "./components/formulario-usuario.component.mjs";
import { Navbar } from "./components/navbar.component.mjs";

export class UpdateView {
    #privateContainer;
    #privateNavbar;
    #privateForm;

    constructor() {
        this.#privateContainer = document.querySelector('.container');
        this.#privateNavbar = new Navbar();
        this.#privateForm = new FormularioUsurio();
    }

    init(formularioSubmit, data) {
        this.#privateContainer.append(
            this.#privateNavbar.get(),
            this.#privateForm.get(formularioSubmit, data)
        );
    }

}
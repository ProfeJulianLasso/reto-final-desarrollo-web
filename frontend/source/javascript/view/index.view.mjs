'use strict';

import { Navbar } from "./components/navbar.component.mjs";
import { Table } from "./components/table.component.mjs";

export class IndexView {
    #privateContainer;
    #privateNavbar;
    #privateTable;
    #privateData;

    constructor(header) {
        this.#privateContainer = document.querySelector('.container');
        this.#privateNavbar = new Navbar();
        this.#privateTable = new Table(header);
    }

    set Data(data) {
        this.#privateData = data;
    }

    init() {
        this.#privateTable.Data = this.#privateData;
        this.#privateContainer.append(
            this.#privateNavbar.get(),
            this.#privateTable.get()
        );
    }

}
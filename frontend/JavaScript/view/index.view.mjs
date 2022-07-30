'use strict';

import { Board } from "./components/board.component.mjs";

export class IndexView {
    #privateContainer;
    #privateBoard;
    #privateData;

    constructor() {
        this.#privateContainer = document.querySelector('.container');
        this.#privateBoard = new Board();
    }

    set Data(data) {
        this.#privateData = data;
    }

    init() {
      this.#privateBoard.Data = this.#privateData;
        this.#privateContainer.append(
            this.#privateBoard.get(),
        );
    }

}
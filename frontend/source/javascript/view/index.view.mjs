'use strict';

export class IndexView {

    #privateBody;

    constructor() {
        document.title = "Hola Mundo";
        this.#privateBody = document.querySelector('body');
    }

    init(name, data) {
        const paragraph = this.#privateCreateParagraph();
        paragraph.innerHTML = `Hello World!!! ${name}`;
        this.#privateBody.append(paragraph);
        console.log(data);
    }

    #privateCreateParagraph() {
        return document.createElement('p');
    }

}
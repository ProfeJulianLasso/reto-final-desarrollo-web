export class Navbar {

    #privateNavbar;

    constructor() {
        this.#privateGenerateNavbar();
    }

    get() {
        return this.#privateNavbar;
    }

    #privateGenerateNavbar() {
        const nav = document.createElement('nav');
        nav.classList.add('navbar', 'navbar-expand-lg', 'bg-light');

        const div = document.createElement('div');
        div.classList.add('container-fluid');

        const name = document.createElement('a');
        name.classList.add('navbar-brand');
        name.href = '#';
        name.textContent = 'Navbar';

        const button = document.createElement('button');
        button.type = 'button';
        button.classList.add('btn', 'btn-success');
        button.textContent = 'Agregar';

        div.append(name, button);
        nav.appendChild(div);

        this.#privateNavbar = nav;
    }
}
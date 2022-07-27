export class FormularioUsurio {

    #privateFormulario;

    constructor() { }

    get(formularioSubmit, data) {
        this.#privateGenerateFormulario(formularioSubmit, data);
        return this.#privateFormulario;
    }

    #privateGenerateFormulario(formularioSubmit, data) {
        const form = document.createElement('form');
        form.id = 'formulario';
        form.addEventListener('submit', (event) => {
            event.preventDefault();
            formularioSubmit();
        });

        const inputID = this.#privateInput('id', 'hidden', data.id);
        const inputNombre = this.#privateInputWithLabel('nombre', 'Nombre', 'text', 'Digite su nombre', true, data.nombre);
        const inputApellido = this.#privateInputWithLabel('apellido', 'Apellido', 'text', 'Digite su apellido', true, data.apellido);
        const inputCorreo = this.#privateInputWithLabel('correo', 'Email', 'email', 'Digite su correo electrónico', false, data.correo);
        const inputTelefono = this.#privateInputWithLabel('telefono', 'Telefono', 'phone', 'Digite su teléfono', false, data.telefono);
        const buttons = this.#privateButtons();

        form.append(inputID, inputNombre, inputApellido, inputCorreo, inputTelefono, buttons);
        // form.innerHTML = inputID + inputNombre + inputApellido + inputCorreo + inputTelefono + buttons;
        this.#privateFormulario = form;
    }

    #privateInputWithLabel(id, label, type, placeholder, required, value) {
        const div = document.createElement('div');
        div.classList.add('mb-3');

        const lblLabel = document.createElement('label');
        lblLabel.htmlFor = id;
        lblLabel.classList.add('form-label');
        lblLabel.textContent = label;

        const input = document.createElement('input');
        input.type = type;
        input.classList.add('form-control');
        input.id = id;
        input.name = id;
        input.placeholder = placeholder;
        if (required) input.required = true;
        if (value) input.value = value;

        div.append(lblLabel, input);
        return div;
        // return `<div class="mb-3">
        // <label for="${id}" class="form-label">${label}</label>
        // <input type="${type}" class="form-control" id="${id}" name="${id}" placeholder="${placeholder} ${required ? "required" : ''}" value="${value ? value : null}">
        // </div>`;
    }

    #privateInput(id, type, value) {
        const input = document.createElement('input');
        input.type = type;
        input.id = id;
        input.name = id;
        if (value) input.value = value;
        return input;
        // return `<input type="${type}" id="${id}" name="${id}" value="${value ? value : ''}">`;
    }

    #privateButtons() {
        const div = document.createElement('div');

        const btnCancelar = document.createElement('button');
        btnCancelar.classList.add('btn', 'btn-primary');
        btnCancelar.textContent = 'Cancelar';

        const btnSubmit = document.createElement('button');
        btnSubmit.classList.add('btn', 'btn-primary');
        btnSubmit.textContent = 'Modificar';

        div.append(btnCancelar, btnSubmit);
        return div;

        // return `<div>
        //     <button type="button" class="btn btn-primary">Cancelar</button>
        //     <button type="submit" class="btn btn-primary">Modificar</button>
        // </div>`;
    }
}
'use strict';
import { TablerosController} from "../controller/tableros.controler.mjs";
import { Config } from "../config.mjs";

export class TablerosView {

    #privateBody;

    constructor() {
        document.title = "Lista de tableros";
        this.#privateBody = document.querySelector('body');
    }

    /**
     * 
     * @param {} tableros 
     */
    init(tableros) {

        //this.#privateBody.remove();
        //this.#privateBody = document.querySelector('body');

        const description = new TablerosController();
        
        const card = this.#privateCreateCard();
        const title = this.#privateCreateTitle();
        title.textContent = "Crear un tablero nuevo";

        //se crea input
       
        const input = document.createElement('input');
        input.type = "text";
        input.classList.add("form-control");
        input.id = "create";
        input.placeholder = "Ingrese un nombre";
        input.required = true;

        //se crea boton
        const buttonCreate = document.createElement('a');
        buttonCreate.classList.add('btn', 'btn-primary');
        buttonCreate.textContent = 'Crear';
        //buttonCreate.href = Config.FrontendURL+"/"+option+"Update.html?id="+id;
        buttonCreate.addEventListener("click",() => {const text = document.getElementById("create").value; description.create(text); })

        card.append(title,input,buttonCreate);

        this.#privateBody.append(card);

        tableros.forEach((tablero)=>{
            const card = this.#privateCreateCard();
            card.id = tablero.Id;
            const title = this.#privateCreateTitle();
            title.textContent = tablero.Name;
          
           
            const inputEditar = document.createElement('input');
            inputEditar.type = "text";
            inputEditar.classList.add("form-control");
            inputEditar.id = "editar"+tablero.Id;
            inputEditar.placeholder = "Editar Nombre";
            inputEditar.required = true;

            const buttonEditar = this.#privateCreateButton();
            buttonEditar.classList.add('btn', 'btn-primary');
            buttonEditar.textContent = 'Editar';

            buttonEditar.addEventListener("click",() => {const text = document.getElementById("editar"+tablero.Id).value; description.editar(text,tablero.Id); })


            const buttonEliminar = this.#privateCreateButton();
            buttonEliminar.classList.add('btn', 'btn-primary');
            buttonEliminar.textContent = 'Eliminar';

            buttonEliminar.addEventListener("click",() => { description.delete(tablero.Id); })


            const buttonAbrir = this.#privateCreateButton();
            buttonAbrir.classList.add('btn', 'btn-primary');
            buttonAbrir.textContent = 'Abrir';

            buttonAbrir.addEventListener("click",() => location.href = Config.FrontendURL+"/tableroDentro.html?id="+tablero.Id);
            

            card.append(title,inputEditar,buttonEditar,buttonEliminar,buttonAbrir);
            this.#privateBody.append(card);
            return card;
        });
    }

    #privateCreateCard() {
        return document.createElement('div');
    }

    #privateCreateButton() {
        return document.createElement('button');
    }
    #privateCreateImage() {
        return document.createElement('img');
    }

    
    #privateCreateTitle() {
        return document.createElement('h1');
    }   
}
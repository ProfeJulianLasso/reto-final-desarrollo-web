"use strict";
// Config
import { Config } from "../config.mjs";

// Views
import { TablerosView  } from "../view/tableros.view.mjs";

// Services
import { TablerosService } from "../model/services/tableros.service.mjs";



export class TablerosController {
    #privateApiyURL;
    #privateView;

    constructor() {
        this.#privateApiyURL = Config.API_URL;        
        this.#privateView = new TablerosView();
        
    }

    async init() {
        
        const servicio = new TablerosService(this.#privateApiyURL);
        const tableros = await servicio.getTableros();
        this.#privateView.init(tableros);

    }  
    async create(text){
        
        if(text == ""){
            Swal.fire(
                'Error',
                'Ingresar un nombre al tablero que desea crear',
                'error'
            )
        }else{
            const servicio = new TablerosService(this.#privateApiyURL);
            let nombre = { "name":text,"createdAt": new Date().toISOString() };
            await servicio.create(nombre);

            Swal.fire({
                position: 'top-end',
                icon: 'success',
                text: 'Tablero creado correctamente',
                showConfirmButton: false,
                timer: 1500
            }).then(() => {
                window.location.reload()
            })
            //const tableros = await servicio.getTableros();
            //this.#privateView.init(tableros);
            //alert("Tablero Creado correctamente");
        }
    }

    async delete(id){
        const servicio = new TablerosService(this.#privateApiyURL);
        await servicio.delete(id);
        
    }

    async editar(text,id){debugger;
        if(text == ""){
            Swal.fire(
                'Error',
                'Ingresar un nombre nuevo al tablero que desea editar',
                'error'
            )
        }else{
            const servicio = new TablerosService(this.#privateApiyURL);
            let nombre = {"name":text,
            //"createdAt": new Date().toISOString(),
            "updatedAt":  new Date().toISOString()};
            await servicio.editar(nombre,id);
            //const tableros = await servicio.getTableros();
            //this.#privateView.init(tableros);

            Swal.fire({
                position: 'top-end',
                icon: 'success',
                text: 'Tablero Editado correctamente',
                showConfirmButton: false,
                timer: 1500
            }).then(() => {
                window.location.reload()
            })
        }
    }
}

export const instance = new TablerosController();
instance.init();
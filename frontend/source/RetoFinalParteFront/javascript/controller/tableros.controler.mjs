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
        
        if(text == "")
        {
            alert("Se debe ingresar un nombre al tablero a crear");
        }
        else
        {
            
            const servicio = new TablerosService(this.#privateApiyURL);
            let nombre = {"name":text,
            "createdAt": new Date().toISOString()};
            await servicio.create(nombre);
            //const tableros = await servicio.getTableros();
            //this.#privateView.init(tableros);
            alert("Tablero Creada correctamente");
        }
    }
    async delete(id){
        const servicio = new TablerosService(this.#privateApiyURL);
        await servicio.delete(id);
        alert("Tablero Eliminado correctamente");

    }
    async editar(text,id){debugger;
        if(text == "")
        {
            alert("Se debe ingresar un nombre al tablero a editar");
        }
        else
        {
            
            const servicio = new TablerosService(this.#privateApiyURL);
            let nombre = {"name":text,
            //"createdAt": new Date().toISOString(),
            "updatedAt":  new Date().toISOString()};
            await servicio.editar(nombre,id);
            //const tableros = await servicio.getTableros();
            //this.#privateView.init(tableros);
            alert("Tablero Editado correctamente");
        }
    }
}

export const instance = new TablerosController();
instance.init();
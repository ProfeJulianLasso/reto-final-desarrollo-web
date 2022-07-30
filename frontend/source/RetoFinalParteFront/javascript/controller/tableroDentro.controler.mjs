"use strict";
// Config
import { Config } from "../config.mjs";

// Views
import { TableroDentroView  } from "../view/tableroDentro.view.mjs";

// Services
import { TablerosService } from "../model/services/tableros.service.mjs";



export class TableroDentroController {
    #privateApiyURL;
    #privateView;

    constructor() {
        this.#privateApiyURL = Config.API_URL;        
        this.#privateView = new TableroDentroView();
        
    }

    async init() {
        
        const servicio = new TablerosService(this.#privateApiyURL);
        const tableros = await servicio.getColumnNames();
        var idTablero = 1;
        const tasks = await servicio.getTaskFoBoard(idTablero);
        this.#privateView.init(tableros,tasks,idTablero);

    }  
    
    async delete(id){
        debugger;
        const servicio = new TablerosService(this.#privateApiyURL);
        await servicio.deleteTask(id);
        alert("Tarea Eliminada correctamente");

    }
    async create(nombreTarea,descripcion,idTablero,idColumna){
        
        if(nombreTarea == "")
        {
            alert("Se debe ingresar un nombre a la tarea a crear");
        }
        else
        {
            
            const servicio = new TablerosService(this.#privateApiyURL);
            let nombre = {
                "idColumn":idColumna,
                "idBoard":idTablero,
                "name":nombreTarea,
                "description":descripcion,
                "create": new Date().toISOString()
            };
            await servicio.createTask(nombre);
            //const tableros = await servicio.getTableros();
            //this.#privateView.init(tableros);
            alert("Tarea Creada correctamente");
        }
    }
    async mover(idColumn,idTablero,name,descripcion,fechaCreacion,id){
        const servicio = new TablerosService(this.#privateApiyURL);

        debugger;
        let nombre = {
            "idColumn":idColumn,
            "idBoard":idTablero,
            "name":name,
            "description":descripcion,
            "create": fechaCreacion
        };
        await servicio.editarTarea(nombre,id);
        //const tableros = await servicio.getTableros();
        //this.#privateView.init(tableros);
        alert("Tarea movida correctamente");
    }

}

export const instance = new TableroDentroController();
instance.init();
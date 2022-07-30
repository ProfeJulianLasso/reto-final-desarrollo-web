'use strict';
import { TableroDentroController} from "../controller/tableroDentro.controler.mjs";
import { Config } from "../config.mjs";

export class TableroDentroView {

    #privateBody;

    constructor() {
        document.title = "Lista de tableros";
        this.#privateBody = document.querySelector('body');
    }

    /**
     * 
     * @param {} tableros 
     */
    init(columnas,tasks,idTablero) {
        const description = new TableroDentroController();

        let nombreColumnas = ["Por realizar","En progreso","Terminado"];
        var numeroColumnas = columnas.length;
        columnas.forEach((element)=>{

            const div = document.createElement("div");
            div.classList.add("as");

            div.id = element.Id;//element.Name.replace(' ','');

            const titulo = document.createElement("h1");
            titulo.textContent =  element.Name;

            

            const inputNombre = document.createElement("input");
            inputNombre.placeholder = "Nombre de la tarea";
            inputNombre.id = "nombre_"+element.Name;

            const inputDescripcion = document.createElement("input");
            inputDescripcion.placeholder = "Descripcion tarea";
            inputDescripcion.id = "descripcion"+element.Name;

            const buttonCrearTarea = this.#privateCreateButton();
            buttonCrearTarea.classList.add('btn', 'btn-primary');
            buttonCrearTarea.textContent = 'Crear tarea';

            buttonCrearTarea.id = "btn"+element.Name.replace(' ','');
            buttonCrearTarea.addEventListener("click",() => {
                const nombre = document.getElementById("nombre_"+element.Name).value;
                const descripcion = document.getElementById("descripcion"+element.Name).value;
                const idColumna = element.Id;
                
                description.create(nombre,descripcion,idTablero,idColumna);
            });
            

            div.append(titulo,inputNombre,inputDescripcion,buttonCrearTarea);

            this.#privateBody.append(div);
        });

        tasks.forEach((task)=>{
            var idColumn = task.Image;
            var h = document.getElementById(idColumn);

            const pruebaDiv = document.createElement("div");
            pruebaDiv.id = "tarea"+task.Id;
            pruebaDiv.classList.add("task");
     
            

             const p1 = document.createElement("p");
             p1.textContent = "Titulo: "+task.Name; 
     
             const p2 = document.createElement("p");
             p2.textContent = "Descripcion: "+task.DescripcionTarea; 
     
             const p3 = document.createElement("p");
             p3.textContent = "Fecha de creacion: "+task.FechaCreacionTarea; 
     
     
     
             pruebaDiv.append(p1,p2,p3);
     
             

             const divBotones = document.createElement("div");
             divBotones.classList.add("divBotones");
             
             const buttonAbrir = this.#privateCreateButton();
             buttonAbrir.classList.add('btn', 'btn-primary');
             buttonAbrir.textContent = 'Abrir';
     
             buttonAbrir.addEventListener("click",() => location.href = Config.FrontendURL+"/tableroDentro.html?id="+tablero.Id);
                 
     
             const buttonEliminar = this.#privateCreateButton();
             buttonEliminar.classList.add('btn', 'btn-primary');
             buttonEliminar.textContent = 'Eliminar';
     
             buttonEliminar.addEventListener("click",() => {description.delete(task.Id);});
             
             debugger;
             if(idColumn-1 == 0)
             {
                const buttonMoverDerecha = this.#privateCreateButton();
                buttonMoverDerecha.classList.add('btn', 'btn-primary');
                buttonMoverDerecha.textContent = '-->';

                buttonMoverDerecha.addEventListener("click",() => {

                    var name=task.Name;
                    var descripcion = task.DescripcionTarea;
                    var fechaCreacion = task.FechaCreacionTarea;
                    description.mover(idColumn+1,idTablero,name,descripcion,fechaCreacion,task.Id);
                
                });


                divBotones.append(buttonAbrir,buttonEliminar,buttonMoverDerecha);
             }
             
             else if(idColumn == numeroColumnas){
                const buttonMoverIzquierda = this.#privateCreateButton();
                buttonMoverIzquierda.classList.add('btn', 'btn-primary');
                buttonMoverIzquierda.textContent = '<--';


                buttonMoverIzquierda.addEventListener("click",() => {

                    var name=task.Name;
                    var descripcion = task.DescripcionTarea;
                    var fechaCreacion = task.FechaCreacionTarea;
                    description.mover(idColumn-1,idTablero,name,descripcion,fechaCreacion,task.Id);
                
                });


                divBotones.append(buttonMoverIzquierda,buttonAbrir,buttonEliminar);
             }
             else{
                const buttonMoverDerecha = this.#privateCreateButton();
                buttonMoverDerecha.classList.add('btn', 'btn-primary');
                buttonMoverDerecha.textContent = '-->';

                const buttonMoverIzquierda = this.#privateCreateButton();
                buttonMoverIzquierda.classList.add('btn', 'btn-primary');
                buttonMoverIzquierda.textContent = '<--';

                buttonMoverDerecha.addEventListener("click",() => {

                    var name=task.Name;
                    var descripcion = task.DescripcionTarea;
                    var fechaCreacion = task.FechaCreacionTarea;
                    description.mover(idColumn+1,idTablero,name,descripcion,fechaCreacion,task.Id);
                
                });

                buttonMoverIzquierda.addEventListener("click",() => {

                    var name=task.Name;
                    var descripcion = task.DescripcionTarea;
                    var fechaCreacion = task.FechaCreacionTarea;
                    description.mover(idColumn-1,idTablero,name,descripcion,fechaCreacion,task.Id);
                
                });

                divBotones.append(buttonMoverIzquierda,buttonAbrir,buttonEliminar,buttonMoverDerecha);
             }

             
             pruebaDiv.append(divBotones);
     
            h.append(pruebaDiv);
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

import { getByIdFunction, postFunction ,deleteFunction,putFunction } from "../Model/BoardModel/Board.Service.mjs";
import { Url_Boards as url } from "../Utilities/config.mjs";
import { eliminarLog } from "../Utilities/UtilsFunctions.mjs";

/**
 * vista de los tableros
 * @class
 */
export class Board {

  #Board;
  #data;
  
    constructor() {

        this.#data = null
        this.#Board = null

    }
    
    /**
     * metodo para la creacion e inyeccion de elementos al dom que muestra los tableros
     */
    #privateGenerateBoard() {

        const div = document.getElementById("tableContent");

        const btnAdd = document.createElement("button")
        btnAdd.className = "addBoardBtn"
        btnAdd.innerHTML = "+"

        div.append(btnAdd)

        btnAdd.addEventListener('click', async ()=>{

            let name = prompt("Ingresa el nombre de la nueva tabla")

            await postFunction(url,name)

        })

        this.#data.data.forEach((item) => {

            // CreateElement

            const divIterated = document.createElement("div")
            divIterated.className = "divBoard"
            divIterated.id = `tableroPrueba${item.id}`

            const inputTextNameBoard = document.createElement("input")
            inputTextNameBoard.type ="text"
            inputTextNameBoard.value =item.name
            inputTextNameBoard.readOnly = true
            inputTextNameBoard.id = `btnName${item.id}`

            const verTablero = document.createElement("button")
            verTablero.className="verTablero"
            verTablero.id = item.id

            verTablero.addEventListener('click', ()=>{
                localStorage.setItem("id", verTablero.id)
            })
            
            const aEnlace = document.createElement("a")
            aEnlace.href="../../Html/board.html"
            aEnlace.innerHTML="Ver tablero"

            const buttonEdit = document.createElement("button")
            buttonEdit.id = `btnEdit_${item.id}`
            buttonEdit.className = "editarTablero"
            buttonEdit.innerHTML = "Editar"

            buttonEdit.addEventListener('click', async()=>{
                
                const id = verTablero.id
                let btn = document.getElementById(`btnName${id}`)
                btn.readOnly = false
                btn.focus()

                if(buttonEdit.innerHTML === "Cambiar"){
                    await putFunction(url,id,inputTextNameBoard.value)
                }

                buttonEdit.innerHTML = "Cambiar"

            })

            const buttonDel = document.createElement("button")
            buttonDel.id = `btnDel_${item.id}`
            buttonDel.className = "eliminarTablero"
            buttonDel.innerHTML = "Eliminar"

            buttonDel.addEventListener('click', async ()=>{

                let data = await getByIdFunction(url,verTablero.id)
                let taskData = data.data.task

                if (confirm(`seguro de eliminar este tablero? ${data.data.name}`)) {

                    taskData.forEach( task =>{

                        let logsData = task.logs
    
                        if(task.logs.length){
                            logsData.forEach( log =>{ 
    
                                eliminarLog(log.id)
        
                            })
                        }
    
                    })

                    await deleteFunction(url, verTablero.id)
                    
                }               

            })

            verTablero.append(aEnlace)

            divIterated.append(inputTextNameBoard, verTablero, buttonEdit,buttonDel)

            div.append(divIterated)

        });
        
        this.#Board = div;
        
    }
    
    get() {
        this.#privateGenerateBoard();
        return this.#Board;
    }

    setData (data) {
        this.#data = data
    }

}


// Eventslistener



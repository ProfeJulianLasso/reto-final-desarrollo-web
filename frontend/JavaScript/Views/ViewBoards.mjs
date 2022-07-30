
import { getByIdFunction, deleteFunction } from "../Model/Services/Board.Service.mjs";
import { Url_Boards as url } from "../Utilities/config.mjs";

export class Board {

  #Board;
  #data;
  
    constructor() {

        this.#data = null
        this.#Board = null

    }
    
    #privateGenerateBoard() {

        const div = document.getElementById("tableContent");

        const btnAdd = document.createElement("button")
        btnAdd.className = "addBoardBtn"
        btnAdd.innerHTML = "+"

        div.append(btnAdd)

        this.#data.data.forEach((item) => {

            // CreateElement

            const divIterated = document.createElement("div")
            divIterated.className = "divBoard"
            divIterated.id = `tableroPrueba${item.id}`

            const inputTextNameBoard = document.createElement("input")
            inputTextNameBoard.type ="text"
            inputTextNameBoard.value =item.name

            const verTablero = document.createElement("button")
            verTablero.className="verTablero"
            verTablero.id = item.id

            verTablero.addEventListener('click', ()=>{
                alert(verTablero.id)
            })
            
            const aEnlace = document.createElement("a")
            aEnlace.href="./board.html" 
            aEnlace.innerHTML="Ver tablero"

            const buttonEdit = document.createElement("button")
            buttonEdit.id = `btnEdit_${item.id}`
            buttonEdit.className = "editarTablero"
            buttonEdit.innerHTML = "Editar"

            buttonEdit.addEventListener('click', ()=>{

                alert("El id a editar es: " + verTablero.id)

            })

            const buttonDel = document.createElement("button")
            buttonDel.id = `btnDel_${item.id}`
            buttonDel.className = "eliminarTablero"
            buttonDel.innerHTML = "Eliminar"

            buttonDel.addEventListener('click', async ()=>{

                let data = await getByIdFunction(url,verTablero.id)

                console.log(data)

                alert("El id a eliminar es: " + verTablero.id)

                await deleteFunction(url, verTablero.id)

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



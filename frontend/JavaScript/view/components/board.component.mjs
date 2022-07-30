import { BoardsService } from"../../Model/services/boards.service.mjs"

export class Board {
  #privateBoard;
  #privateData;
  privateBoardsService
  algo = "asdasd"
  
  constructor() {
      this.privateBoardsService = new BoardsService();
    }
    
    #privateGenerateBoard() {
        const div = document.createElement("div");
        div.setAttribute("id","tableContent");
        this.#privateData.forEach((item,index) => {
            item = item.getValues();
            div.innerHTML += 
            `<div class="divBoard" id="tableroPrueba${index+1}">
            <input type="text" value="${item.nombre}" />
            <button class="verTablero">
            <a href="./board.html">Ver tablero</a>
            </button>
            <button class="editarTablero" >Editar</button>
            <h6>${item.id}</h6>
            <button class="eliminarTablero" ${onclick = async function () {await fetch(`http://localhost:8080/board/${item.id}`, {method: 'DELETE'})}}>Eliminar</button>
            </div>`;
        });
        
        this.#privateBoard = div;
        
    }
    
    get() {
        this.#privateGenerateBoard();
        return this.#privateBoard;
    }

    set Data(data) {
        this.#privateData = data;
        
        console.log(this.#privateData);
    }
}

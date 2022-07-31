
import { Url_Task as url } from '../../Utilities/config.mjs'
import {postFunction,putFunction} from './Task.Service.mjs'

class Task {

    #id
    #name
    #description
    #column
    #board
    #delivery	

    constructor(id,name, description, column, board, delivery){

        this.#id = id
        this.#name = name
        this.#description = description
        this.#column = column
        this.#board = board
        this.#delivery = delivery		
        
    }

    setName(name) { this.#name = name }
    setDescription(description) {this.#description = description}
    setColumn(column) {this.#column = column}
    setBoard(board) {this.#board = board}
    setDelivery(delivery) {this.#delivery = delivery}	

    getName() { return this.#name }
    getDescription() {return this.#description}
    getColumn() {return this.#column}
    getBoard() {return this.#board}
    getDelivery() {return this.#delivery}

    async postTask(){
        await postFunction(url, this.#name, this.#description, this.#column, this.#board, this.#delivery)
    }

    async updateTask(){
        await putFunction(url, this.#id, this.#name, this.#description, this.#column, this.#board, this.#delivery)
    }

}
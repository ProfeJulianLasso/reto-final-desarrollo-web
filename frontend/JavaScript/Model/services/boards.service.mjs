import { Config } from "../../config.mjs";
import { BoardModel } from "../board.model.mjs";

export class BoardsService {

    constructor() { }

    async getBoards() {
        const response = await fetch(`${Config.Url_Boards}`).then(response => response.json());
        const boards = new Array();
        response.data.forEach(item => {
            const board = new BoardModel(item);
            boards.push(board);
        });
        return boards;
    }

    async getBoards1() {
        return "hola"
    }


    async getBoardById(id) {
        const data = await fetch(`${Config.Url_Boards}/${id}`).then(response => response.json());
        return new BoardModel(data);
    }

    async updateBoard(id, data) {
        await fetch(
            `${Config.Url_Boards}/${id}`,
            {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

    async deleteBoard(id){
        await fetch(`${Config.Url_Boards}/${id}`, {method: 'DELETE'})
    }

}
import {getFunction} from "../Model/BoardModel/Board.Service.mjs"
import {Url_Boards} from "../Utilities/config.mjs"
import { Board } from "../Views/ViewBoards.mjs"

/**
 * controlador del tablero
 * @class
 */
export class BoardController{

    generateViews(){

        const viewBoards = new Board;

        const getData = async() =>{
            const data = await getFunction(Url_Boards)
            viewBoards.setData(data)
            viewBoards.get()
        }

        getData()
        

    }

}
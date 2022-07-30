import {getFunction} from "../Model/Services/Board.Service.mjs"
import {Url_Boards} from "../Utilities/config.mjs"
import { Board } from "../Views/ViewBoards.mjs"

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
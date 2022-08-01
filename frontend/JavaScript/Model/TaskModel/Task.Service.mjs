import { methodBody } from "./MethodBody.mjs"
import {postFunction as postLog} from "../LogModel/Log.service.mjs"
import { Url_Log as urlLog } from "../../Utilities/config.mjs"

// Funcion para obtener los datos de mi api
export const getFunction = async(url) =>{

    try {
        
        return (
            fetch(url)
            .then( res => res.json() )
        )

    } catch (err) {
        console.error(err)
    }

}

export const getByIdFunction = async(url,id) =>{

    try {
        
        return (
            fetch(`${url}/${id}`)
            .then( res => res.json() )
        )

    } catch (err) {
        console.error(err)
    }

}

// Funcion para enviar datos a mi api
export const postFunction = async(url, name, description, column, board, date) =>{

    let data = methodBody('POST', name, description, column, board, date)
    console.log(data)

    try {
        await fetch(url, data)
    } catch (err) {
        console.log(err)
    }

    window.location.href = 'http://127.0.0.1:5501/Html/board.html';

}

// Funcion para actualizar datos de mi api
export const putFunction = async(url, id, name, description, column, board, date) => {

    await postLog(urlLog, id, localStorage.getItem("columnaTareaSeleccionada"),column)

    let data = methodBody('PUT', name, description, column, board, date)

    try {
        await fetch(`${url}/${id}`, data)
    } catch (err) {
        console.log(err)
    }

    window.location.href = 'http://127.0.0.1:5501/Html/board.html';

}

// Funcion para eliminar datos de mi api
export const deleteFunction = async(url,id) =>{

    let data = methodBody('DELETE')

    try {
        await fetch(`${url}/${id}`, data)
    } catch (err) {
        console.log(err)
    }

    window.location.href = 'http://127.0.0.1:5501/Html/board.html';


}
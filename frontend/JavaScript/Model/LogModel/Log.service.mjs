import { methodBody } from "./MethodBody.mjs"

/**
 * esta funcion trae los datos de la api
 * @param {String} url 
 */
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

/**
 * Funcion para traer un dato de acuerdo al id
 * @param {String} url 
 * @param {Number} id 
 */
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

/**
 * Funcion para crear un dato en la api
 * @param {String} url 
 * @param {Number} taskId 
 * @param {Number} columnaPrevious 
 * @param {Number} columnaCurrent 
 */
export const postFunction = async(url, taskId, columnaPrevious ,columnaCurrent) =>{

    let data = methodBody('POST', taskId, columnaPrevious ,columnaCurrent)
    console.log(data)

    try {
        await fetch(url, data)
    } catch (err) {
        console.log(err)
    }

    window.location.href = 'http://127.0.0.1:5501/Html/board.html';

}

/**
 * Funcion para actualizar datos de la api
 * @param {String} url 
 * @param {String} id 
 * @param {Number} taskId 
 * @param {Number} columnaPrevious 
 * @param {Number} columnaCurrent 
 */
export const putFunction = async(url,id, taskId, columnaPrevious ,columnaCurrent) => {

    let data = methodBody('PUT', taskId, columnaPrevious ,columnaCurrent)

    try {
        await fetch(`${url}/${id}`, data)
    } catch (err) {
        console.log(err)
    }

    location.reload()

}

// 
/**
 * Funcion para eliminar ujn dato de la api
 * @param {String} url 
 * @param {Number} id 
 */
export const deleteFunction = async(url,id) =>{

    let data = methodBody('DELETE')

    try {
        await fetch(`${url}/${id}`, data)
    } catch (err) {
        console.log(err)
    }

    location.reload()

}
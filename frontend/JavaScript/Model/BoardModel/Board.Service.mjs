import { methodBody } from "./MethodBody.mjs"

/**
 * Esta funcion es la encrgada de obtener los datos de la api
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
 * Esta funcion es la encrgada de obtener los datos de la api de acurdo al id 
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
 * Esta funcion es la encargada de enviar datos a la api
 * @param {String} url 
 * @param {String} name 
 * @param {String} updatedAt 
 */
export const postFunction = async(url, name, updatedAt) =>{

    let data = methodBody('POST', name, updatedAt)
    console.log(data)

    try {
        await fetch(url, data)
    } catch (err) {
        console.log(err)
    }

    location.reload()

}

/**
 * esta funcion es la encargada de actualizar datos en la api
 * @param {String} url 
 * @param {Number} id 
 * @param {String} name 
 * @param {String} updatedAt 
 */
export const putFunction = async(url,id, name, updatedAt) => {

    let data = methodBody('PUT', name, updatedAt)

    try {
        await fetch(`${url}/${id}`, data)
    } catch (err) {
        console.log(err)
    }

    location.reload()

}

/**
 * esta funcion se usa para eliminar un dato en la api
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
/**
 * metodo HTTP para el llamado de la api
 * @param {String} method 
 * @param {String} name 
 * @param {String} updatedAt 
 */
export const methodBody = (method, name, updatedAt) =>{

    return {

        method: `${method}`,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "name": name||'',
            "updatedAt": updatedAt||null
        })

    }

}
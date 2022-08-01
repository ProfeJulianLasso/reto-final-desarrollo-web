
/**
 * metodo HTTP para el llamado de la api
 * @param String*} method 
 * @param {Number} taskId 
 * @param {Number} columnaPrevious 
 * @param {Number} columnaCurrent 
 */

export const methodBody = (method, taskId, columnaPrevious ,columnaCurrent) =>{

    return {

        method: `${method}`,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            taskId: taskId,
            columnaPrevious: columnaPrevious || 1,
            columnaCurrent: columnaCurrent || 1
        })

    }

}





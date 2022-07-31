
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





export const methodBody = (method, name, description, column, board, date) =>{

    return {

        method: `${method}`,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "name": name||'',
            "description":description||'',
            "column": column || 1,
            "board": board || 1,
            "delivery": date
        })

    }

}